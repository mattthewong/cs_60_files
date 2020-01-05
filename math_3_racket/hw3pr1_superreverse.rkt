;; file:  hw3pr1_superreverse.rkt
;; submission site id/login: eu6

#lang racket
(require htdp/testing)
(require racket/trace)



(define (superreverse L)
;; superreverse
;;   inputs: list L
;;   output: reversal of top level sublists.
;; using higher-order functions (no raw recursion)
  (if (null? L)
      '()
      (cons (reverse (first L)) (map reverse (rest L)))))


; provided tests
(check-expect (superreverse '( (1 2 3) (4 5 6) (#\k #\o #\o #\l) (#\a #\m) ))
    '( (3 2 1) (6 5 4) (#\l #\o #\o #\k) (#\m #\a) ) )
(check-expect (superreverse '( (1 2 3) (4 5 6 (7 8) 9 ) ))
    '( (3 2 1) (9 (7 8) 6 5 4) ) )
; additional tests
(check-expect (superreverse '( (1 2 3) (4 5 6) ("h" "e" "l" "l" "o") (#\a #\m) ))
    '( (3 2 1) (6 5 4) ("o" "l" "l" "e" "h") (#\m #\a) ) )
(check-expect (superreverse '( (1 2 3) (4 5 6 (7 8) 9 ) (0 6 "S" "C" )))
    '( (3 2 1) (9 (7 8) 6 5 4) ("C" "S" 6 0 ) ))



(generate-report)
