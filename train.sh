ant regex

beam=$1
dataset=$2
modeldir="models/b_"$beam"_ds_"$dataset

java -Xmx32g -cp libregex/*:libsempre/*:lib/* -ea regex.Train -languageAnalyzer corenlp.CoreNLPAnalyzer -Grammar.inPaths regex/regex1.grammar -SimpleLexicon.inPaths regex/regex1.lexicon -Parser.beamSize $beam -FeatureExtractor.featureDomains rule -Dataset.inPaths train:regex/data/$dataset/regex.examples -Learner.maxTrainIters 3 $modeldir


