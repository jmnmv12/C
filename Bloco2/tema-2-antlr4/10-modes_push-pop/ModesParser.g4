parser grammar ModesParser;

options {
   tokenVocab=ModesLexer;
}

all: ( ACTION_START | OUTSIDE_TOKEN | ACTION_END | INSIDE_TOKEN | INSIDE_ACTION_START)* EOF;
