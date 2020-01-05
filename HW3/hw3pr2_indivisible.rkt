
; hw3pr2_indivisible.rkt
; login(s): eu6
#lang racket
(require htdp/testing)
(require racket/trace)



;; <NOTE: Delete this note and fill in a comment for indivisible>
;; using higher-order functions (no raw recursion)
(define (indivisible e L)
    (if (null? L)
      L
      (if (equal? e 1)
          L
          (filter (lambda (Y) (not(integer?(/ Y e)))) L))))
            


; provided tests
(check-expect (indivisible 3 '( 2 3 4 5 6 7 8 9 10 )) '(2 4 5 7 8 10))
; additional tests
(check-expect (indivisible 3 '( 2 3 4 5 6 7 8 9 11 12 15 20 )) '(2 4 5 7 8 11 20))
(check-expect (indivisible 3 '( 2 2 2 2 2 2 3 6 9)) '(2 2 2 2 2 2 ))

(generate-report)