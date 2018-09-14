ant regex

beam=200
dataset="t"
modeldir="models/b_200_ds_t"
params=$modeldir/params

java -Xmx32g -cp libregex/*:libsempre/*:lib/* -ea regex.Test -languageAnalyzer corenlp.CoreNLPAnalyzer -Grammar.inPaths regex/regex.grammar -SimpleLexicon.inPaths regex/regex.lexicon -Parser.beamSize $beam -Builder.inParamsPath $params $dataset


