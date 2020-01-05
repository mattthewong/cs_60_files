#lang racket
; hw3pr3_lotto-winner.rkt
; login(s): eu6
(require htdp/testing)

; matches  
; input: list-of-tickets - representing a lotto ticket
;          expected format:  '(name # # ... #)
;        winning-numbers - representing the winning numbers
;          expected format;  '(# # .. #)
; output: the number elements that match between 
;         list-of-tickets and winning-numbers
(define (matches list-of-tickets winning-numbers)
  (length 
   (filter (lambda (one-ticket) 
             (member one-ticket winning-numbers))
           list-of-tickets)))



; provided tests:
(check-expect (matches '(cat 1)     '())       0)
(check-expect (matches '(cat 1)     '(2 3 4))  0)
(check-expect (matches '(cat 1)     '(1))      1)
(check-expect (matches '(ace 2 3 4) '(3 42 2)) 2)
(check-expect (matches '(ace 2 3 4) '(8 4 5))  1)

; lotto-winner 
; input: list-of-tickets - representing a list of lotto tickets
;         expected format: '((name1 # # ... #)... (nameN # # ... #)) 
;        winning-numbers - representing the winning numbers
;          expected format;  '(# # .. #)
; output: the name and number of matching tickets from the ticket 
;         with the most matches in winning-numbers
(define (lotto-winner list-of-tickets winning-numbers)
 (let* (
         [P  (map (lambda (x) (flatten(cons (first x) (matches x winning-numbers)))) list-of-tickets)]
         [F (sort P (lambda (x1 y1) (> (second x1) (second y1))))]
         [W (first F)])
                                 
   W
  
       )
    
   )
      
;provided tests
(check-expect (lotto-winner
    '( (alice 2 4 16 33 42)  
       (bob 3 4 5 6 7) 
       (cdrthecat 3 15 16 41 42) )  
    '(2 3 15 32 42)) ; winning tickets
              '(cdrthecat 3)) ; <- output of lotto-winner
;additional tests
(check-expect (lotto-winner
    '( (jon 2 4 16 33 42)  
       (bob 3 4 5 6 7) 
       (john 3 15 2 42 8) )  
    '(2 3 15 32 42)) ; winning tickets
              '(john 4)) ; <- output of lotto-winner

(check-expect (lotto-winner
    '( (matt 2 2 2 1 1)  
       (sera 3 1 1 1 1) 
       (anant 3 15 16 41 8) )  
    '(2 3 15 32 42)) ; winning tickets
              '(matt 3)) ; <- output of lotto-winner




(generate-report)