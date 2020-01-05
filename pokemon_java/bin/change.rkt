
;
; change.rkt
;
; login(s): eu6 and 

#lang racket
(require htdp/testing)
(require racket/trace)


; make-ones (uses embedded-recursion)
;
; input: count - the non-negative number of 1s to put in a list
; return: a list of count 1s.
(define (make-ones count) 
  (if (equal? count 0)
      '()
      (append '(1) (make-ones (- count 1)))))
      
      




; tests for make-ones
(check-expect (make-ones 0)  '())
(check-expect (make-ones 1)  '(1))
(check-expect (make-ones 2)  '(1 1))
(check-expect (make-ones 3)  '(1 1 1))
(check-expect (make-ones 10) '(1 1 1 1 1 1 1 1 1 1))


; make-ones-tail (uses tail-recursion)
;
; input: count - the non-negative number of 1s to put in a list
; return: a list of count 1s.
(define (make-ones-tail count)
(make-ones-tailhelper count '()))

(define (make-ones-tailhelper count thelist)

(if (equal? count 0)
     thelist
     (make-ones-tailhelper (- count 1) (append thelist '(1)))))
  
  

; tests for make-ones-tail
(check-expect (make-ones-tail 0)  '())
(check-expect (make-ones-tail 1)  '(1))
(check-expect (make-ones-tail 2)  '(1 1))
(check-expect (make-ones-tail 3)  '(1 1 1))
(check-expect (make-ones-tail 10) '(1 1 1 1 1 1 1 1 1 1))



; min-change
;
; input: goal - the total amount of coins we want to produce
;        coins - a list of non-negative coin values from smallest to largest
; returns: a list of the smallest number of coins necessary to provide a sum of goal.
; Note - You can always assume you can use 1-cent coins! 
(define (min-change goal coins)
  (if (equal? goal 0)
      '()
      
      (if (null? coins)
          (make-ones goal)

          (if (< goal (first coins))
              (make-ones goal)
              
      (let* ([it (first coins)]
             [useit (sort (append (list it) (min-change (- goal (first coins)) coins)) <)]
             [loseit (sort(min-change goal (rest coins)) <)])
             (if (< (length useit) (length loseit))
                 useit
             loseit))))))
             
             
             
                     


; tests for min-change
(check-expect (min-change 42 '(1 5 10 25 50)) '(1 1 5 10 25))
(check-expect (min-change 42 '(1 5 21 35))    '(21 21))
(check-expect (min-change 1 '(1 5 21 35))     '(1))
(check-expect (min-change 0 '(1 5 21 35))     '())
(check-expect (min-change 6 '(5 10))          '(1 5))
(check-expect (min-change 3 '(8 9))           '(1 1 1))


(generate-report)
