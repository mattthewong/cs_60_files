#lang racket
#|
  hw1pr2_count1bits.rkt
  Login(s): eu6
|#

(require htdp/testing)


; count1bits counts the number of times the bit '1' appears in in the binary representation of value N.
(define (count1bits N)
(if (< N 2)
    1
(if (equal? (modulo N 2) 0 )
    (count1bits (quotient N 2))
    (+ 1 (count1bits (quotient N 2))))))
   

;my test cases
(check-expect (count1bits 72) 2)
(check-expect (count1bits 100000) 6)
; provided tests
(check-expect (count1bits 6) 2)
(check-expect (count1bits 7) 3)
(check-expect (count1bits 42) 3)


(generate-report)