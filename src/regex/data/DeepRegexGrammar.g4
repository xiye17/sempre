grammar DeepRegexGrammar;

regex : 
  CC        # CharClass
| '(' regex ')'     # Paren
| '.*' regex '.*'     # Contains
| regex '|' regex     # Or
| regex '+'           # Plus
| '~' regex           # Not
| regex '&' regex     # And
| '.*' regex          # EndsWith
| '(.*)' regex          # EndsWith1
| regex '.*'          # StartsWith
| regex '(.*)'          # StartsWith1
| regex '{' INT ',}'        # Repeat
| CC  '.*' CC    # FollowedBy
| '(' regex  ').*(' regex ')'    # FollowedBy1
| '(' regex ')*'        # KleeneStar
| '\\b' regex '\\b'   # Word
;

CC: 
  '<VOW>' 
| '<LET>' 
| '<CAP>' 
| '<LOW>' 
| '<NUM>' 
| '<M0>' 
| '<M1>' 
| '<M2>' 
| '<M3>' 
| '.' 
;

INT: [0-9]+;

