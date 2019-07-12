#!/bin/bash
ant regex

#rm -rf models
#mkdir models

rm libsempre/sempre-regex.jar

cp libregex/sempre-regex.jar libsempre/sempre-regex.jar

./run @mode=simple -languageAnalyzer corenlp.CoreNLPAnalyzer -Grammar.inPaths demo/popl.grammar -SimpleLexicon.inPaths demo/popl.lexicon
