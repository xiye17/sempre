beam=0
dataset=0

# beam = 200, 1k data set
beam=200
dataset="regex/data/turk_1k/regex.examples"
java -Xmx2g -cp libregex/*:libsempre/*:lib/* -ea regex.Main -Grammar.inPaths regex/regex.grammar -SimpleLexicon.inPaths regex/regex.lexicon -Parser.beamSize $beam  -FeatureExtractor.featureDomains rule -Dataset.inPaths train:$dataset -Learner.maxTrainIters 3 > b200ds1k


# beam = 1k, 1k data set
beam=1000
dataset="regex/data/turk_1k/regex.examples"
java -Xmx2g -cp libregex/*:libsempre/*:lib/* -ea regex.Main -Grammar.inPaths regex/regex.grammar -SimpleLexicon.inPaths regex/regex.lexicon -Parser.beamSize $beam  -FeatureExtractor.featureDomains rule -Dataset.inPaths train:$dataset -Learner.maxTrainIters 3 > b1kds1k



# beam = 200, 10k data set
beam=200
dataset="regex/data/turk/regex.examples"
java -Xmx2g -cp libregex/*:libsempre/*:lib/* -ea regex.Main -Grammar.inPaths regex/regex.grammar -SimpleLexicon.inPaths regex/regex.lexicon -Parser.beamSize $beam  -FeatureExtractor.featureDomains rule -Dataset.inPaths train:$dataset -Learner.maxTrainIters 3 > b200ds10k



# beam = 1k, 10k data set

beam=1000
dataset="regex/data/turk/regex.examples"
java -Xmx2g -cp libregex/*:libsempre/*:lib/* -ea regex.Main -Grammar.inPaths regex/regex.grammar -SimpleLexicon.inPaths regex/regex.lexicon -Parser.beamSize $beam  -FeatureExtractor.featureDomains rule -Dataset.inPaths train:$dataset -Learner.maxTrainIters 3 > b1kds10k


