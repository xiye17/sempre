ant regex

beam=$1
dataset=$2
modeldir="models/b_"$beam"_ds_"$dataset
params=$modeldir/params

java -Xmx2g -cp libregex/*:libsempre/*:lib/* -ea regex.TestDemo -languageAnalyzer corenlp.CoreNLPAnalyzer -parser SketchParser -Grammar.inPaths demo/popl.grammar -SimpleLexicon.inPaths demo/popl.lexicon -FeatureExtractor.featureDomains rule span context bigram phrase-category -Builder.inParamsPath $params -Parser.beamSize $beam $dataset
# java -Xmx2g -cp libregex/*:libsempre/*:lib/* -ea regex.TestDemo -languageAnalyzer corenlp.CoreNLPAnalyzer -Grammar.inPaths demo/demo.lambda.grammar -SimpleLexicon.inPaths demo/demo.lexicon -FeatureExtractor.featureDomains rule span context bigram phrase-category -Builder.inParamsPath $params -Parser.beamSize $beam $dataset
