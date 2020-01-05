#|
  hw1pr1_erdos.rkt
  Login(s): eu6
|#
#lang racket
(require htdp/testing) ;; this enables the testing interface
;; erdos: the "3N+1 function"
;;   inputs: an integer, N
;;   output: 3N+1, if N is odd
;;           N/2, if N is even

(define (erdos N)
  
  (define X
    (* 3 N))
  
    (if (odd? N) 

    (+ X 1)
     
    (/ N 2))

  )

; additional tests
(check-expect (erdos 5) 16)
(check-expect (erdos 6) 3)

; provided tests
(check-expect (erdos 84) 42)
(check-expect (erdos 85) 256)

; erdos-count: returns the number of erdos iterations it takes for input N to arrive at the value 1.
;input: an integer, N
;output: # of iterations before N = 1.
(define (erdos-count N)
  (if (equal? N 1)
  0
  (+ 1 (erdos-count(erdos N))))
  
  )

; additional tests
(check-expect (erdos-count 6) 8)
(check-expect (erdos-count 12) 9)


; provided tests
(check-expect (erdos-count 26) 10)
(check-expect (erdos-count 27) 111)


(generate-report)
