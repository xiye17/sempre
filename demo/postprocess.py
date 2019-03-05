import os
import argparse
import shutil
from os.path import join

# convert raw format to sth suitable for sempre


def _parse_args():
    parser = argparse.ArgumentParser(description="so preprocess")
    parser.add_argument("--infile", type=str, dest="infile", default="./demo/so.raw.txt")
    parser.add_argument("--outfile", type=str, dest="outfile", default="./demo/so.ready.txt")
    parser.add_argument("--outpath", type=str, dest="outpath", default="/Users/xiye/WorkSpace/DevSpace/resnax/exp/demo/")
    parser.add_argument("--dataset", type=str, dest="dataset", default="demo")
    parser.add_argument("--beam", type=int, dest="beam", default=500)
    parser.add_argument("--maxcnt", type=int, dest="maxcnt", default=25)

    args = parser.parse_args()
    return args

def process_sketch(x):
    y = x.replace("<space>", "< >")
    y = y.replace("<-lrb->", "<(>")
    y = y.replace("<-rrb->", "<)>")
    y = y.replace("\\\\", "\\")
    while y.find("upper") != -1:
        pos = y.find("upper")
        end_pos = pos + 5
        nex_tok = y[end_pos]
        y = y[:pos] + nex_tok.upper() + y[(end_pos + 1):]
    return y

def read_pred_file(filename):
    preds = []
    with open(filename) as f:
        while True:
            line = f.readline()
            if not line:
                break
            line = line.strip()
            line = line.split("\t")
            id = line[0]
            num_deriv = int(line[1])
            # print(id)
            derivs = []
            for i in range(num_deriv):
                line = f.readline().strip()
                derivs.append(line)
            preds.append({"id": id, "derivations": derivs})
    return preds
    
def write_derivs(filename, derivs):
    lines = [str(x[0]) + " " + x[1] + "\n" for x in derivs]
    with open(filename, "w") as f:
        f.writelines(lines)

def read_ready_data(filename):
    with open(filename) as f:
        lines = f.readlines()
    lines = [x.strip() for x in lines]
    line_fields = [x.split("\t") for x in lines]
    d = {}
    for fields in line_fields:
        d[fields[0]] = fields[2]
    return d

def eval_match(args):
    id_gt_map = read_ready_data(args.outfile)
    prefix = join("./regex/data/", args.dataset)
    pred_file = join(prefix, str(args.beam)+"-pred-test.txt")
    ids = []
    cnt_total = 0
    cnt_coverage = 0
    cnt_coverage_top = 0
    with open(pred_file) as f:
        while True:
            line = f.readline()
            if not line:
                break
            line = line.strip()
            line = line.split("\t")
            id = line[0]
            ids.append(id)
            num_deriv = int(line[1])
            derivs = []
            for i in range(num_deriv):
                line = f.readline().strip()
                line = line.split("\t")
                sketch = (line[0])
                rank = int(line[1]) + 1
                derivs.append((rank, sketch))
            derivs.sort(key=lambda x:x[0])
            derivs = [x[1] for x in derivs]

            cnt_total += 1
            flag = False
            if id_gt_map[id] in derivs:
                flag = True
                cnt_coverage += 1
            if id_gt_map[id] in derivs[:args.maxcnt]:
                cnt_coverage_top += 1
            print(id, flag)
    print("Data: {}, coverage: {}, top {} coverage: {}".format(cnt_total, cnt_coverage, args.maxcnt, cnt_coverage_top))

def make_sketch(args):
    prefix = join("./regex/data/", args.dataset)
    
    pred_file = join(prefix, str(args.beam)+"-pred-test.txt")
    ids = []
    with open(pred_file) as f:
        while True:
            line = f.readline()
            if not line:
                break
            line = line.strip()
            line = line.split("\t")
            id = line[0]
            ids.append(id)
            num_deriv = int(line[1])
            print(id)
            derivs = []
            for i in range(num_deriv):
                line = f.readline().strip()
                line = line.split("\t")
                print(line[0])
                sketch = process_sketch(line[0])
                print(sketch)
                print("-------")
                rank = int(line[1]) + 1
                derivs.append((rank, sketch))
            derivs.sort(key=lambda x:x[0])
            derivs = derivs[:args.maxcnt]
            write_derivs(join(args.outpath, "sketch", id), derivs)
    return ids

def make_bemchmark(ids, args):
    src_prefix = "/Users/xiye/WorkSpace/DevSpace/resnax/exp/so/benchmark_selected/"
    dst_prefix = join(args.outpath, "benchmark")
    for id in ids:
        shutil.copyfile(join(src_prefix, id), join(dst_prefix, id))

def postprecess(args):
    ids = make_sketch(args)
    make_bemchmark(ids, args)
    eval_match(args)

def main():
    args = _parse_args()
    print(args)
    postprecess(args)

if __name__ == "__main__":
    main()
