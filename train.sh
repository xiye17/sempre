ant regex

beam=200
dataset="t"
modeldir="models/b_"$beam"_ds_"$dataset

java -Xmx32g -cp libregex/*:libsempre/*:lib/* -ea regex.Train -languageAnalyzer corenlp.CoreNLPAnalyzer -Grammar.inPaths regex/regex.grammar -SimpleLexicon.inPaths regex/regex.lexicon -Parser.beamSize $beam -FeatureExtractor.featureDomains rule -Dataset.inPaths train:regex/data/$dataset/regex.examples -Learner.maxTrainIters 3 $modeldir


