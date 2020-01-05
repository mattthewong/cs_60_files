#lang racket
;logins(s): eu6
(require htdp/testing)

(define (xtail-reverse L x)
;helper function for tail-reverse.
  (if (null? L)
      x
     (xtail-reverse (rest L) (cons (first L) x))))


(define (tail-reverse L)
;tail reverse takes in a list L and uses xtail-reverse to output a new list that is reversed by tail-recursion.
  (xtail-reverse (rest L) (list(first L))))

;provided tests
(check-expect (tail-reverse '(6 7 1 2))  '(2 1 7 6))

;additional tests
(check-expect (tail-reverse '(0 0 0 1 0))  '(0 1 0 0 0))
(check-expect (tail-reverse '(5 4 5 6))  '(6 5 4 5))
(generate-report)