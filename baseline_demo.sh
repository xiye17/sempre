ant regex

beam=$1
dataset=$2
modeldir="models/b_"$beam"_ds_"$dataset

java -Xmx2g -cp libregex/*:libsempre/*:lib/* -ea regex.TestBaseline -languageAnalyzer corenlp.CoreNLPAnalyzer -parser SketchParser -Grammar.inPaths demo/demo.fn.fine.grammar -SimpleLexicon.inPaths demo/demo.lexicon -Parser.beamSize $beam $dataset
