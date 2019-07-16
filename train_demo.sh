ant regex

beam=$1
dataset=$2
modeldir="models/b_"$beam"_ds_"$dataset

rm -rf $modeldir

java -Xmx32g -cp libregex/*:libsempre/*:lib/* -ea regex.Train -languageAnalyzer corenlp.CoreNLPAnalyzer -Grammar.inPaths demo/popl.grammar -SimpleLexicon.inPaths demo/popl.lexicon -Parser.beamSize $beam -Parser.dumpAllFeatures true -FeatureExtractor.featureDomains rule span context bigram phrase-category   -parser SketchParser -Dataset.inPaths train:regex/data/$dataset/regex.train.examples -Learner.maxTrainIters 5  $modeldir

