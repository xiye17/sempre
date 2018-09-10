#ant regex

#./run @mode=simple -languageAnalyzer corenlp.CoreNLPAnalyzer -Grammar.inPaths regex_grammars/sql.grammar -SimpleLexicon.inPaths regex_grammars/sql.lexicon
#./run @mode=simple -languageAnalyzer corenlp.CoreNLPAnalyzer -Grammar.inPaths regex_grammars/regex.grammar -SimpleLexicon.inPaths regex_grammars/regex.lexicon

./run @mode=simple -Grammar.inPaths regex/regex.grammar -SimpleLexicon.inPaths regex/regex.lexicon

#./run @mode=simple -Grammar.inPaths data/tutorial-arithmetic.grammar

#java -cp libregex/*:libsempre/*:lib/* -ea regex.Main -Grammar.inPaths regex/regex.grammar -SimpleLexicon.inPaths regex/regex.lexicon
