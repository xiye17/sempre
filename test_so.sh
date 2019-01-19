ant regex

beam=$1
dataset=$2
modeldir="models/b_"$beam"_ds_"$dataset
params=$modeldir/params

#java -Xmx2g -cp libregex/*:libsempre/*:lib/* -ea regex.Test -languageAnalyzer corenlp.CoreNLPAnalyzer -Grammar.inPaths regex/regex1.grammar -SimpleLexicon.inPaths regex/regex1.lexicon -Parser.beamSize $beam -Builder.inParamsPath $params $dataset
#java -Xmx2g -cp libregex/*:libsempre/*:lib/* -ea regex.TestSimple -languageAnalyzer corenlp.CoreNLPAnalyzer -Grammar.inPaths regex/regex2.grammar -SimpleLexicon.inPaths regex/regex2.lexicon -Parser.beamSize $beam $dataset
java -Xmx2g -cp libregex/*:libsempre/*:lib/* -ea regex.TestSimple -languageAnalyzer corenlp.CoreNLPAnalyzer -Grammar.inPaths regex/regex4.grammar -SimpleLexicon.inPaths regex/regex4.lexicon -Parser.beamSize $beam $dataset
