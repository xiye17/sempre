grammar SpecGrammar;


regex : 
  CC          # CharClass
| 'contain(' regex ')'    # Contains
| 'startwith(' regex ')'   # StartsWith 
| 'endwith(' regex ')'     # EndsWith 
| 'repeat(' regex ',' INT ')'     # Repeat0 
| 'repeat(' regex ',' INT ',)'    # Repeat1 
| 'repeat(' regex ',' INT ',' INT ')'    # Repeat2 
| 'followedby(' regex ',' regex ')'    # FollowedBy 
| 'not(' regex ')'            # Not
| 'and(' regex ',' regex ')'    # And 
| 'or(' regex ',' regex ')'     # Or
| 'optional(' regex ')'         # Optional
;


CC: 
  'fb:en.num'
| 'fb:en.cap'
| 'fb:en.low'
| 'fb:en.vow'
| 'fb:en.let'
| 'fb:en.any'
| 'fb:en.const'
| 'fb:en.letnum'
| 'fb:en.dp'
;


INT: [0-9]+;

