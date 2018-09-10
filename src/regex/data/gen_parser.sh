#!/bin/bash
path="ast"
g4_file="DeepRegexGrammar.g4"
package_name="regex.data.ast"
antlr_path="../../../libregex/antlr-4.7.1-complete.jar"

rm -rf $path/*
#antlr4 dsl.g4 -no-listener -visitor -package apps.matrix.ast -o $path
java -Xmx500M -cp $antlr_path org.antlr.v4.Tool $g4_file -no-listener -visitor -package $package_name -o $path
chmod -w $path/*

