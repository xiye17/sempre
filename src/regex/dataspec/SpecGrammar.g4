grammar SpecGrammar;


regex : 
  CC          # CharClass
| 'contain(' regex ')'    # Contains
| 'startwith(' regex ')'   # StartsWith 
| 'endwith(' regex ')'     # EndsWith 
| 'repeat(' regex ',' INT ')'    # Repeat 
| 'followedby(' regex ',' regex ')'    # FollowedBy 
| 'not(' regex ')'            # Not
| 'and(' regex ',' regex ')'    # And 
| 'or(' regex ',' regex ')'     # Or
;


CC: 
  'fb:en.num'
| 'fb:en.cap'
| 'fb:en.low'
| 'fb:en.vow'
| 'fb:en.let'
| 'fb:en.any'
| 'fb:en.const'
;


INT: [0-9]+;

