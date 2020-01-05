;login(s): eu6
#lang racket
(require htdp/testing)

(define (ftail-fib N f)
;ftail-fib helper function takes in two accumulator arguments and generates a value f based on input N.
  (if (< N 2)
      f
      (+ (ftail-fib (- N 1) f) (ftail-fib(- N 2) f))))

(define (tail-fib N)
; tail-fib uses ftail-fib to generate the fibonacci number of N by setting f = 1.
  (ftail-fib N 1))
  
;provided tests
(check-expect (tail-fib 8)  34)
;additional tests
(check-expect (tail-fib 10)  89)
(check-expect (tail-fib 2)  2)




(generate-report)
