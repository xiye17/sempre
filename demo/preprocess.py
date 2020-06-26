import os
import argparse
from os.path import join

# convert raw format to sth suitable for sempre


def _parse_args():
    parser = argparse.ArgumentParser(description="so preprocess")
    parser.add_argument("--infile", type=str, dest="infile", default="./demo/so.raw.txt")
    parser.add_argument("--outfile", type=str, dest="outfile", default="./demo/so.ready.txt")
    # parser.add_argument("--outpath", type=str, dest="outpath", default="./exp")
    parser.add_argument("--dataset", type=str, dest="dataset", default="so")

    args = parser.parse_args()
    args.infile = join("demo", "{}.raw.txt".format(args.dataset))
    args.outfile = join("demo", "{}.ready.txt".format(args.dataset))
    if args.dataset.startswith('kb13') or args.dataset.startswith('turk'):
        if '.' in args.dataset:
            args.split = args.dataset.split('.')[1]
            args.dataset = args.dataset.split('.')[0]
        else:
            args.split = None
    else:
        args.split = None

    return args

def process_nl(x):
    y = []
    inquotation = False
    for tok in x:
        if tok == "\"":
            if inquotation:
                y.append(" ")
                y.append("rightquoatation")
            else:
                y.append("leftquoatation")
                y.append(" ")

            inquotation = not inquotation
        else:
            if inquotation and tok.isupper():
                y.append("upper"+tok.lower())
            else:
                y.append(tok)
    y = "".join(y)
    y = y.replace("the string leftquoatation", "leftquoatation")
    y = y.replace("the strings leftquoatation", "leftquoatation")

    return y

def tricky_process_nl(id, nl, dataset):
    if not dataset.startswith("so"):
        return nl

    list_id = ["3", "52", "77"]
    if id not in list_id:
        return nl
    src_strings = ['"&" "|" "." "(" ")"', '"_" "-" "+" "(" ")" "/" "\\"', '"~" "!" "@" "#" "$" "-" "_"']
    dst_string = '"enumconsts"'

    idx = list_id.index(id)
    print(id, nl)
    nl = nl.replace(src_strings[idx], dst_string)
    print(id, nl)
    return nl

def process_sketch(x, dataset):
    if dataset.startswith("so"):
        y = []
        for tok in x:
            if tok.isupper():
                y.append("upper"+tok.lower())
            else:
                y.append(tok)
        y = "".join(y)

        # replace some tokens
        y = y.replace("< >", "<space>")
        y = y.replace("<(>", "<-lrb->")
        y = y.replace("<)>", "<-rrb->")
        y = y.replace("\\", "\\\\")
    elif dataset.startswith("turk") or dataset.startswith("kb13"):
        y = x.replace("<m0>", "<!>")
        y = y.replace("<m1>", "<@>")
        y = y.replace("<m2>", "<#>")
        y = y.replace("<m3>", "<$>")
    return y

def read_raw_data(filename, dataset):
    with open(filename) as f:
        lines = f.readlines()
    lines = lines[1:]
    lines = [x.strip() for x in lines]
    line_fields = [x.split("\t") for x in lines]
    line_fields = [x for x in line_fields if len(x) == 3]
    exs = []
    for fields in line_fields:
        ex_id = fields[0]
        ex_nl = tricky_process_nl(ex_id, fields[1], dataset)
        ex_nl = process_nl(ex_nl)
        ex_sketch = process_sketch(fields[2], dataset)
        exs.append((ex_id, ex_nl, ex_sketch))
    return exs

def write_ready_data(filename, exs):
    with open(filename, "w") as f:
        lines = [("\t".join(x) + "\n") for x in exs]
        f.writelines(lines)

def preprocess(args):

    exs = read_raw_data(args.infile, args.dataset)
    write_ready_data(args.outfile, exs)

def read_ready_data(filename):
    with open(filename) as f:
        lines = f.readlines()
    lines = [x.strip() for x in lines]
    line_fields = [x.split("\t") for x in lines]
    return line_fields

def fit_for_exs(x):
    x = x.replace('\\', '\\\\')
    x = x.replace(')', '\\)')
    x = x.replace('"', '\\"')
    return x

def makedir_p(dir):
    if not os.path.exists(dir):
        # shutil.rmtree(dir)
        os.mkdir(dir)

def prepare_dataset(args):
    # regex.examples
    exs = read_ready_data(args.outfile)

    prefix = join("./regex/data", args.dataset)
    makedir_p(prefix)
    if args.split:
        exs_file = join(prefix, "regex.{}.examples".format(args.split))
    else:   
        exs_file = join(prefix, "regex.examples")
    lines = []

    for ex in exs:
        lines.append('(example (utterance "{0}") (targetValue (name "{1}")))\n'.format(fit_for_exs(ex[1]), ex[2]))
    with open(exs_file, "w") as f:
        f.writelines(lines)
    
    # src-test.txt
    if args.split:
        test_file = join(prefix, "src-{}.txt".format(args.split))
    else:
        test_file = join(prefix, "src-test.txt")

    lines = []
    for ex in exs:
        lines.append(ex[0] + "\t" + ex[1] + "\n")
    with open(test_file, "w") as f:
        f.writelines(lines)
           
def main():
    args = _parse_args()
    print(args)

    preprocess(args)
    prepare_dataset(args)


if __name__ == "__main__":
    main()
