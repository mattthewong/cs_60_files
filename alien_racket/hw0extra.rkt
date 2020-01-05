#lang slideshow
; this function allows the user to define the size of the alien, while keeping the colors of black eyes/mouth, green body the same.
(define (alien input)
  (let*(( x (colorize (filled-ellipse input input) "green"))
        ( y (colorize (filled-ellipse input input) "black"))
        ( z (colorize (filled-ellipse input input) "white"))
        (green (hc-append x x x x x ))
        (eye (hc-append x y x y x))
        (mouth (hc-append x y y y x))
        (body (hc-append  z z x z z))
        (legs (hc-append z x z x z)))
  (vc-append legs legs green eye green mouth green body body body green body body body legs legs legs)))
;extra allows the user to define the size of two separate aliens, creating a collage of alien images /unique pattern scheme.
(define (extra input1 input2)
  (let*((alien1 (alien input1))
        (alien2 (alien input2))
        (horizontal1 (hc-append alien1 alien2))
        (horizontal2 (hc-append alien2 alien1))
        (pattern (hc-append horizontal1 horizontal2 horizontal1))
        (pattern1 (hc-append horizontal2 horizontal1 horizontal2)))
    (vc-append pattern pattern1 pattern)))
    
    
        
  

    
    
  

