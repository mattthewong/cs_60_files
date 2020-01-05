#lang racket
;login(s): eu6 and kc1
(require htdp/testing)
;subbag takes in two lists (S and B) and returns a boolean based on whether or not the elements in S are present within B.
(define (subbag? S B)
(if (null? S)
    #t
    (if (null? B)
        #f
        (if (member (first S) B)
            (subbag? (rest S) (remove (first S) B))
            #f))))


  
;provided tests
(check-expect (subbag? '()      '(s p a m s))   #t)
(check-expect (subbag? '(s s)   '(s p a m s))   #t)
(check-expect (subbag? '(s m)   '(s p a m s))   #t)
(check-expect (subbag? '(a p)   '(s p a m s))   #t)
(check-expect (subbag? '(a m a) '(s p a m s))   #f)
(check-expect (subbag? '(a s)   '(s a))         #t)
;additional tests
(check-expect (subbag? '(p p e)      '(s a a m s))   #f)
(check-expect (subbag? '(s s s s s)   '(s p a m s))   #f)



(define (score-letter l)
;score letter is a helper function designed to take in a a letter
;in the form of '#\ and output the value asscoiated with it from scrabble-tile bag
  (second (assoc l scrabble-tile-bag)))

;provided test
(check-expect (score-letter '#\w) 4)

;additional tests
(check-expect (score-letter '#\z) 10)
(check-expect (score-letter '#\y) 4)



(define (score-word w)
;score-word takes in a word w in the form of either a list or string, and returns the total value of that string using score-letter.
  (if (list? w)
      (if (null? w)
          0
      (+ (score-letter (first w)) (score-word (rest w))))
      
      (if (equal? (string-length w) 0)
         0
         (+ (score-letter(first(string->list w))) (score-word(rest (string->list w)))))))



      
;provided tests
(check-expect (score-word "zzz")  30)
(check-expect (score-word "fortytwo") 17)
(check-expect (score-word "twelve")  12)
;additional tests
(check-expect (score-word "xjfnsdjf") 36)
(check-expect (score-word "tcdshjf")  23)




(define (scrabblehelper rack WL)
;scrabblehelper takes in a word rack and a list of potential scrabble words, outputting a new list with all scrabble words that can be
;formed from the rack word as well as the values associated with them
  (cond [(null? WL) WL]
        
        [(subbag? (string->list (first WL)) (string->list rack))
         
         (cons (list (first WL) (score-word (first WL))) (scrabblehelper rack (rest WL)))]
        
        [else (scrabblehelper rack (rest WL))]))


(define (best-word rack WL)
;; rack is a string; WL is a list of strings
  (let [(listoflists (scrabblehelper rack WL))]
    (cond
      [(null? (scrabblehelper rack WL)) '("" 0)]
      
      [(equal? (length listoflists) 1) (list (first WL) (score-word (first WL)))]
      
      [(> (second (first listoflists)) (second (second listoflists)))
       
       (best-word rack (remove (second WL) WL))]
      
      [else (best-word rack (rest WL))])))
            


(check-expect (best-word "academy" '("ace" "ade" "cad" "cay" "day"))  '("cay" 8))
(check-expect (best-word "appler" (list "peal" "peel" "ape" "paper")) '("paper" 9))
(check-expect (best-word "paler" (list "peal" "peel" "ape" "paper"))  '("peal" 6))
(check-expect (best-word "kwyjibo" '("ace" "ade" "cad" "cay" "day"))  '("" 0))
;; Do you recognized "kwyjibo"? http://www.hulu.com/watch/29524




;; scrabble-tile-bag  
;;   letter tile scores and counts from the game of Scrabble
;;   the counts aren't needed (until the ex. cr.) they're obtained from
;;   http://en.wikipedia.org/wiki/Image:Scrabble_tiles_en.jpg
;;
(define scrabble-tile-bag
  '((#\a 1 9) (#\b 3 2) (#\c 3 2) (#\d 2 4) (#\e 1 12)
   (#\f 4 2) (#\g 2 3) (#\h 4 2) (#\i 1 9) (#\j 8 1)
   (#\k 5 1) (#\l 1 4) (#\m 3 2) (#\n 1 6) (#\o 1 8)
   (#\p 3 2) (#\q 10 1)(#\r 1 6) (#\s 1 4) (#\t 1 6)
   (#\u 1 4) (#\v 4 2) (#\w 4 2) (#\x 8 1) (#\y 4 2)
   (#\z 10 1) (#\_ 0 2)) ) 
;; end define scrabble-tile-bag
;;
;; The underscore will be used to represent a blank tile, which is a wild-card





(generate-report)