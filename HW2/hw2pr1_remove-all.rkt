;; file:  hw2pr1_remove-all.rkt
;; submission site id: eu6

#lang racket
(require htdp/testing)
  
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; remove-all
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(define (remove-all e L)
;; remove-all : takes a List L, and removes all top level instances of e.
;;  inputs: instance e, and list L
;;  output: list L that doesn't contain top-level instances e
  (if (null? L)
      '()
      (if (equal? e (first L))
          (remove-all e (rest L))
            (cons (first L) (remove-all e (rest L))))))
         

; provided tests
(check-expect (remove-all "i" '("a" "l" "i" "i" "i" "e" "n")) 
              '("a" "l" "e" "n"))
(check-expect (remove-all "i" '( ("a" "l" "i") "i" "i" "e" "n")) 
              '(("a" "l" "i" ) "e" "n"))
(check-expect (remove-all 0 '(1 0 1 0 1 0))  
              '(1 1 1))

; additional tests
(check-expect (remove-all "i" '( ("a" "l" "i") ("i" "i" ) "e" "n")) 
              '(("a" "l" "i" ) ("i" "i") "e" "n"))
(check-expect (remove-all 0 '(1 0 1 0 1 0))  
              '(1 1 1))

            
(generate-report)