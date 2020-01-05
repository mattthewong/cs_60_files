#lang racket
(require htdp/testing)

(define (superreverse L)
#|superreverse takes in a list L and outputs a list identical to L,
except that all of its top-level lists should be reversed. No deeper structures should be altered. |#
  (if (null? L)
      '()
      (if (list? (first L))
          (cons (reverse (first L)) (superreverse (rest L)))
          (cons  (first L) (superreverse (rest L))))))


;provided tests 
(check-expect (superreverse '( (1 2 3) (4 5 6) (#\k #\o #\o #\l) (#\a #\m) ))
    '( (3 2 1) (6 5 4) (#\l #\o #\o #\k) (#\m #\a) ) )
(check-expect (superreverse '( (1 2 3) (4 5 6 (7 8) 9 ) ))
    '( (3 2 1) (9 (7 8) 6 5 4) ) )
;additional tests
(check-expect (superreverse '( (1 2 3) (4 5 6) ("h" "e" "l" "l" "o") (#\a #\m) ))
    '( (3 2 1) (6 5 4) ("o" "l" "l" "e" "h") (#\m #\a) ) )
(check-expect (superreverse '( (1 2 3) (4 5 6 (7 8) 9 ) (0 6 "S" "C" )))
    '( (3 2 1) (9 (7 8) 6 5 4) ("C" "S" 6 0 ) ))


(define (duperreverse L)
;duper reverse takes in a list L and outputs a list identical to L, except all top level and deep level lists are reversed.
 (if (null? L)
     '()
      (if (list? (first L))
          (append (duperreverse (rest L)) (list (duperreverse (first L))))
          (append (duperreverse (rest L)) (list(first L))))))


; provided tests
(check-expect (duperreverse '( (1 2 3) (4 5 6) 42 ("k" "o" "o" "l") ("a" "m") ))
    '(  ("m" "a") ("l" "o" "o" "k") 42 (6 5 4) (3 2 1) ) )
(check-expect (duperreverse '( (1 2 3) (4 5 6 (7 8) 9 ) ))
    '( (9 (8 7) 6 5 4) (3 2 1) ) )
;additional tests
(check-expect (duperreverse '( ("hi" "mom") (1 2 3) (4 5 6) 42 ("k" "o" "o" "l") ("a" "m") ))
    '( ("m" "a") ("l" "o" "o" "k") 42 (6 5 4) (3 2 1) ("mom" "hi" )))
(check-expect (duperreverse '( (1 "h" 3) (4 "t" 6 (7 8) 9 ) ))
    '( (9 (8 7) 6 "t" 4) (3 "h" 1) ) )

(generate-report)

              