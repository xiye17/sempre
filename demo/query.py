import os, sys
from postprocess import process_sketch, tricky_process_sketch
from os.path import join
import subprocess
import time

DATASEET = "so"
RESNAX_PATH = "/Users/xiye/WorkSpace/DevSpace/resnax"

# dirty for now!
def parse_java_command(prefix, sketch, benchmark):

    if DATASEET == "so":
        # bpath = '{}/{}/{}'.format(prefix, "exp/so/benchmark-popl", benchmark)
        bpath = '{}/{}'.format("exp/so/benchmark-popl", benchmark)
        # logpath = '{}/{}/'.format(prefix, "query")
        # temppath = '{}/{}/'.format(prefix, "qtemp")
        logpath = "query/"
        temppath = "qtemp/"

        java_command = 'exec java -Xmx16G -Djava.library.path={} -cp {} -ea {} {} {} \"{}\" \"{}\" {} {} {} \"{}\"'.format(
                    'lib',
                    'jars/resnax.jar:lib/*',
                    'resnax.Main',
                    '0',
                    bpath,
                    logpath,
                    sketch,
                    '0',
                    '1',
                    '0',
                    temppath
            )
        return java_command, logpath

def read_record(filename, timeout, sketch):
    if os.path.exists(filename):
        with open(filename) as f:
            lines = f.readlines()
    else:
        lines = []

    gt = ""
    learned = ""
    time_synth = ""
    match = ""
    for line in lines:
        if "Learned program" in line:
            idx = line.find(":")
            learned = (line[(idx + 1):len(line)]).strip()
        elif "GT program" in line:
            idx = line.find(":")
            gt = (line[(idx + 1):len(line)]).strip()
        elif "Match gt" in line:
            idx = line.find(":")
            match = (line[(idx + 1):len(line)]).strip()   
        elif "Total time" in line:
            idx = line.find(":")
            time_synth = (line[(idx + 1):len(line)]).strip()
    
    result = {}
    result["gt"] = gt
    result["sketch"] = sketch
    result["learned"] = learned
    result["match"] = match
    if result["gt"] == "":
        result["time"] = 0
        result["timeout"] = timeout
    else:
        result["time"] = float(time_synth)
        result["timeout"] = 0

    return result

def sythesis(prefix, timeout, id, sketch):
    java_cmd, logpath = parse_java_command(prefix, sketch, id)
    try:
        output = str(subprocess.check_output(java_cmd, shell=True, timeout=timeout))
    except subprocess.TimeoutExpired:
        pass
    except subprocess.CalledProcessError:
        pass
    # read and get result

    result = read_record(join(logpath, id+"-0"), timeout, sketch)

    return result

def main(timeout, id, sketch):
    ## postprocessing
    sketch = tricky_process_sketch(id, sketch, DATASEET)
    sketch = process_sketch(sketch, DATASEET)

    sys.path.append(RESNAX_PATH)
    os.chdir(RESNAX_PATH)

    from ResultCache import ResultCache
    cache_filename = DATASEET + "rlcache.pkl"
    cache = ResultCache(cache_filename)
    cache.load()
    # check cache first
    pre_result = cache.query(id, sketch)
    if pre_result is None:
        print("NOT IN")
        result = sythesis(RESNAX_PATH, timeout, id, sketch)
    elif pre_result["timeout"] > 0 and pre_result["timeout"] < timeout:
        print("NOT TIME")
        result = sythesis(RESNAX_PATH, timeout, id, sketch)
    else:
        # make a log file
        print("FOUND")
        result = pre_result
    # print(result)

    if pre_result is None:
        cache.add(id, result["sketch"], result)
        cache.rewrite()
    else:
        # time out
        if pre_result["timeout"] > 0:
            # tested for longer time
            if result["timeout"] == 0 or pre_result["timeout"] < result["timeout"]:
                cache.add(id, result["sketch"], result)
                cache.rewrite()
        else:
            # take less time
            if pre_result["time"] > result["time"] and result["timeout"] == 0:
                cache.add(id, result["sketch"], result)
                cache.rewrite()

    if result["match"] == "true":
        print("true")
    else:
        print("false")

if __name__ == "__main__":
    main(int(sys.argv[1]), sys.argv[2][2:], sys.argv[3])
