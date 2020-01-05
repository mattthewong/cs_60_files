#lang racket
(require htdp/testing)


(define (n-enumerate n L)
#|n-enumerate takes in two values—a number n and list L. This helper function outputs each element from the
 original list as a second element of a sequentially numbered list.|#

(if (null? L)
    '()
    (cons (list n (first L)) (n-enumerate (+ n 1) (rest L)))))

(define (enumerate L)
#|enumerate takes in a list L and outputs each element from the original input as
the second element of a sequentially numbered list, starting from 0.|#
   (n-enumerate 0 L))



(check-expect (enumerate '(jan feb mar apr)) '((0 jan) (1 feb) (2 mar) (3 apr)))
(check-expect (enumerate '(0 I II III IV V VI)) '((0 0) (1 I) (2 II) (3 III) (4 IV) (5 V) (6 VI)))
(check-expect (enumerate '())  '())


(generate-report)

