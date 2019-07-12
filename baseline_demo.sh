ant regex

beam=$1
dataset=$2
modeldir="models/b_"$beam"_ds_"$dataset

java -Xmx2g -cp libregex/*:libsempre/*:lib/* -ea regex.TestBaseline -languageAnalyzer corenlp.CoreNLPAnalyzer -parser SketchParser -Grammar.inPaths demo/popl.grammar -SimpleLexicon.inPaths demo/popl.lexicon -Parser.beamSize $beam $dataset
