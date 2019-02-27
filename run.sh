#!/bin/bash
ant regex

#rm -rf models
#mkdir models

rm libsempre/sempre-regex.jar

cp libregex/sempre-regex.jar libsempre/sempre-regex.jar

#./run @mode=simple -languageAnalyzer corenlp.CoreNLPAnalyzer -Grammar.inPaths demo/demo.grammar -SimpleLexicon.inPaths demo/demo.lexicon -Parser.beamSize $beam -Parser.dumpAllFeatures true -FeatureExtractor.featureDomains rule span context bigram phrase-category  -Dataset.inPaths train:regex/data/$dataset/regex.examples -Learner.maxTrainIters 5
./run @mode=simple -languageAnalyzer corenlp.CoreNLPAnalyzer -Grammar.inPaths demo/demo.fine.grammar -SimpleLexicon.inPaths demo/demo.lexicon
