#lang racket
(define (first-factor N)




  
(define (factor N)
  (if (equal?(quotient N N) 0)
      1
      










; provided tests
(check-expect (first-factor 41) 41)
(check-expect (first-factor 42) 2)

(check-expect (factor 41) '(1 41))
(check-expect (factor 42) '(1 2 3 6 7 14 21 42))