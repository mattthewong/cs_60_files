#|
  hw2pr2_prefix_sublist.rkt
  Login(s): eu6
|#


#lang racket
(require htdp/testing)
(generate-report)


(define (prefix? P L)
;outputs #t or #f depending on whether or not the list P is a prefix of the list L.
  (if (null? P)
      #t
      
      (if (not(equal? (first P) (first L)))
          #f
          
          (prefix? (rest P) (rest L)))))

; provided tests
(check-expect (prefix? '()    '(s p a m))   #t)
(check-expect (prefix? '(s p) '(s p a m))   #t)
(check-expect (prefix? '(s m) '(s p a m))   #f)
(check-expect (prefix? '(p a) '(s p a m))   #f)
(check-expect (prefix? '(s a) '(s p s a m)) #f)

; additional tests
(check-expect (prefix? '(p p a m) '(s p a m)) #f)
(check-expect (prefix? '(a m) '(p a m))  #f)


(define (sublist? S L)
  ;outputs #t or #f depending on whether or not list S is identical to some set of the consecutive elements in list L.
   (if (null? S)
      #t
      (if (null? L)
          #f
      (if (prefix? S L)
          #t
          (sublist? S (rest L))))))

                  
;provided tests          
(check-expect (sublist? '() '(s p a m))      #t)
(check-expect (sublist? '(s p) '(s p a m))   #t)
(check-expect (sublist? '(s m) '(s p a m))   #f)
(check-expect (sublist? '(p a) '(s p a m))   #t)
;additional tests
(check-expect (sublist? '(n m) '(s p a m))      #f)
(check-expect (sublist? '(p) '(s p a m))   #t)



(generate-report)