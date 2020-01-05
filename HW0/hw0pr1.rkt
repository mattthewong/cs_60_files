#lang slideshow
;Matt Wong
;Homework0

;PART C: Do a Racket Tutorial (10 points)


;STEP 4: Definitions
;defining c as a circle with radius 10.
(define c (circle 10))
;defining r as a rectangle size 10 by 20.
(define r (rectangle 10 20))

;created a square size n that is filled.
(define (filled_square n)
(filled-rectangle n n))

;STEP 5: Local Bindings
;created local bindings with nested defines.
(define (four p)
  (define two-p (hc-append p p))
  (vc-append two-p two-p))

;STEP 6: Functions/Values
;let function used so variable can be used in any expression position.
(define (checker p1 p2)
  (let ([p12 (hc-append p1 p2)]
        [p21 (hc-append p2 p1)])
    (vc-append p12 p21)))

; using let* to bind to earlier bindings.
(define (checkerboard p)
  (let* ([rp (colorize p "red")]
         [bp (colorize p "black")]
         [c (checker rp bp)]
         [c4 (four c)])
    (four c4)))

;defining functions that expect other functions as arguments.
(define (series mk)
  (hc-append 4 (mk 5) (mk 10) (mk 20)))

;using lambda to anonymously define functions.


;PART D:Reflect (5 points)

#|Relative to SQL, the use of Racket's nested define functions is similar to SQL's nested select functions.

I find the syntax of the built-in functions to be a little strange? (ie. vc-append).

It seems that the let and let* functions will be very useful for referring to previous functions|#



;PART E: cboard function (20 points)

;created checkerboard with both color and size defined by user.
(define  (cboard size color1 color2)
  (let* ((rp (colorize (filled_square size) color1))
         (bp (colorize (filled_square size) color2))
         (c (checker rp bp))
         [c4 (four c)])
    (four c4)))


;PART F
;first created a three-by-three grid for reference.

(define (3by3 p)
(define threep (vc-append p p p))
(hc-append threep threep threep))

;next created the same grid with different types of input.
(define (comb p1 p2 p3)
 (let [(p123 (vc-append p1 p2 p3))
       (p312 (vc-append p3 p1 p2))
       (p231 (vc-append p2 p3 p1))]
       (hc-append p123 p312 p231)))

;used both comb and 3by3 to generate a 27X27 eclipse output with user-defined colors/sizes.
(define (hcomb n color1 color2 color3)
  (let*((x  (colorize (filled-ellipse n n ) color1))
        (y  (colorize (filled-ellipse n n ) color2))
        (z  (colorize (filled-ellipse n n) color3))
        (p  (comb x y z))
        (p3 (3by3 p)))
  (3by3 p3)))
;PART H: Self-Teaching

;Question: What do people use Racket for in the computer science profession?

#|Answer: Racket enables programmers to link components written in different dialects, and it empowers programmers to
create new, project-specific dialects (project-specific languages). Racket's libraries support applications from web servers and databases to
GUIs and charts. Furthermore, you are able to grow your program with Racket's interactive mode and easily compose these scripts into
larger systems!|#

;Source : http://racket-lang.org/











  


  



  

























 

