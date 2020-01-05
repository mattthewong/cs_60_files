#|
hw1pr3_power.rkt
login(s):eu6
|#

#lang racket
(require htdp/testing)


;; *************************************
;;   Part B - Power
;; *************************************

;power takes two non-negative integers, with the term 'base' as the base raised to the power of user-defined 'pow'.

(define (power base pow)
  
  (if (equal? pow 0)
      1
  (* base (power base (- pow 1)))))


; provided tests
(check-expect (power 2 10) 1024)
(check-expect (power 42 10) 17080198121677824)

;my test cases
(check-expect (power 2 3) 8)
(check-expect (power 2 0) 1)


;; *************************************
;;   Part C - Fast-Power
;; *************************************

;fast-power has identical inputs to power, but runs faster / more efficiently.   
       
(define (fast-power base pow)
  (if (equal? pow 0)
      1
(if (odd? pow)
    (* base (fast-power base (- pow 1)))
    
    (let* ((halfpow (quotient pow 2))
          (X (fast-power base halfpow)))
      (* X X)))))

; provided tests
(check-expect (power 2 10) 1024)
(check-expect (power 42 10) 17080198121677824)

;my test cases
(check-expect (power 2 3) 8)
(check-expect (power 2 0) 1)
          
;; *************************************
;;   Part D - Time Trials (Power)
;; *************************************

;; power time trials
(begin (print "Timing: (power 1 100000)") ; 1^100000
       (newline)
       (time (power 1 100000))
       ;
       (print "Timing: (power 1 200000)") ; 1^200000
       (newline)
       (time (power 1 200000)) 
       ;
       (print "Timing: (power 1 300000)") ; 1^300000
       (newline)
       (time (power 1 300000)) 
       ;
       (print "Timing: (power 1 400000)") ; 1^400000
       (newline)
       (time (power 1 400000))
       ;
       (print "Timing: (power 1 500000)") ; 1^500000
       (newline)
       (time (power 1 500000)))

#|What could explain why there is so much variation in the time it takes for each one and why the result
is that we don’t see a clear linear pattern?

Maybe the fact that we are using a recursion call for our power function that could be made simpler
could play a role in the variation in runtimes for each test; this creates a varying amount of work for the computer
depending on when the test is run because the computer is also processing other information.
 
|#

;; *************************************
;;   Part E - Time Trials (Fast-Power)
;; *************************************

;; fast-power time trials
(begin (print "Timing: (fast-power 1 100000)") ; 1^100000
       (newline)
       (time (fast-power 1 100000))
       ;
       (print "Timing: (fast-power 1 200000)") ; 1^200000
       (newline)
       (time (fast-power 1 200000)) 
       ;
       (print "Timing: (fast-power 1 300000)") ; 1^300000
       (newline)
       (time (fast-power 1 300000)) 
       ;
       (print "Timing: (fast-power 1 400000)") ; 1^400000
       (newline)
       (time (fast-power 1 400000))
       ;
       (print "Timing: (fast-power 1 500000)") ; 1^500000
       (newline)
       (time (fast-power 1 500000))
       ;
       (newline)
       (time (fast-power 1 1000000000000000000000000000000000000000000000000000000000000000000000000000000)))
;essentially takes an extremely large exponent to make even a slight difference in cpu time, real time, or gc time
;(aka gc: 1 versus gc = 0)






(generate-report)