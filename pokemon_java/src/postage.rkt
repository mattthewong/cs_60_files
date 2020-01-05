
;
; postage.rkt
;
; login(s): eu6 and tl5 and jb9


#lang racket
(require htdp/testing)

(define (make-postage goal stamp-list)
  (if (equal? goal 0)
      #t
  (if (null? stamp-list)
      #f
  (if (< goal 0)
  #f
  (let* ((useit  (make-postage (- goal (first stamp-list)) (rest stamp-list)))
         
         (loseit (make-postage goal (rest stamp-list))))
    
    (or useit loseit))))))
         


(check-expect (make-postage -10 '(1 2 3))             #f)
(check-expect (make-postage 0   '(1 4 6 15 54 25 29)) #t)
(check-expect (make-postage 29  '(1 4 6 15 54 25 29)) #t)
(check-expect (make-postage 11  '(1 4 6 15 54 25 29)) #t)
(check-expect (make-postage 76  '(1 4 6 15 54 25 29)) #t)
(check-expect (make-postage 6   '(2 2 2 2 2 2 2 2 2)) #t)
(check-expect (make-postage 9   '(1 4 6 15 54 25 29)) #f)
(check-expect (make-postage 77  '(1 4 6 15 54 25 29)) #f)




(generate-report)

