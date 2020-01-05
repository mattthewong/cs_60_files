
;; file:  BST.rkt
;; submission site id/login: eu6 and bv0

#lang racket
(require htdp/testing)
(require racket/trace)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; BST interface - DO NOT MODIFY!!! 
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Constructing a BST
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; make-BST: BST constructor
;;   inputs: a key, the left sub-BST, and the right sub-BST
;;   output: a new BST, with key as the root
(define (make-BST key left right)
  (list key left right))

;; make-empty-BST: creates an empty BST.
;;   inputs: none
;;   output: an empty BST
(define (make-empty-BST)
  '())

;; make-BST-leaf: creates a BST with one node (aka a leaf).
;;   inputs: a key
;;   output: a new BST, with key as the root
(define (make-BST-leaf key)
      (make-BST key ; key
                (make-empty-BST)   ; left subtree 
                (make-empty-BST))) ; right subtree

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Access elements of a BST
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; key: returns the key for the BST
;;   inputs: a BST
;;   output: the key
(define (key  tree)
  (first tree))

;; leftTree: returns the left tree from the BST
;;   inputs: a BST
;;   output: the left subtree
(define (leftTree tree)
  (second tree))

;; rightTree: returns the right tree from the BST
;;   inputs: a BST
;;   output: the right subtree
(define (rightTree tree)
  (third tree))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; BST Boolean Functions
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; emptyTree?: checks if a tree is empty
;;   inputs: a BST
;;   outputs: #t if tree is empty; otherwise #f
(define (emptyTree? tree)
  (null? tree))

;; leaf?: - checks if the input is a BST with no children
;;   inputs: a BST
;;   output: #t if tree is a leaf, otherwise #f
(define (leaf? tree)
  (and (null? (leftTree tree))
       (null? (rightTree tree))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; START OF ASSIGNMENT - Do not modify above! 
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Part B : Create 4 additional trees
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;



;; Provided: a big binary search tree for testing:
(define BigBST 
  (make-BST 42
            (make-BST 20
                      (make-BST 7
                                (make-BST-leaf 1)
                                (make-BST-leaf 8))
                      (make-BST 31
                                (make-empty-BST)
                                (make-BST-leaf 41)))
            (make-BST 100 
                      (make-BST-leaf 60)
                      (make-empty-BST))))
;; makes a BST with one node.
(define tree-1-node
(make-BST 15
          (make-empty-BST)
          
          (make-empty-BST)))
;; makes a BST that contains a node with one left child. 
(define node-wLeftChild
(make-BST 10
          (make-BST-leaf 5)
          (make-empty-BST)))
 ;;makes a BST that contains a node with one right child.
(define node-wRightChild
(make-BST 16
          (make-empty-BST)
          (make-BST-leaf 20)))
         
;; makes a BST that contains a node with two children.
(define node-wTwoChildren
  (make-BST 10
            (make-BST-leaf 6)

            (make-BST-leaf 11)))
    



;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Part C: Define height
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(define (height BST)
  
  (if (emptyTree? BST)
      -1
      (if (equal? (leaf? BST) #t)
      0
      (let* (
             (lefttreecount (+ 1 (height (leftTree BST))))
             
             (righttreecount (+ 1 (height (rightTree BST)))))
        
        (if (> lefttreecount righttreecount)
            lefttreecount
            righttreecount)))))
            

; provided tests
(check-expect (height BigBST) 3) 
(check-expect (height (make-empty-BST)) -1)

; additional tests
(check-expect (height tree-1-node) 0)
(check-expect (height node-wLeftChild) 1)
(check-expect (height node-wRightChild) 1)
(check-expect (height node-wTwoChildren) 1)


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Part D: Define find-min
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(define (find-min BST)
  
  (if (equal? (leaf? BST) #t)
      
      (key BST)
   
  (if (emptyTree? (second BST))
      (key BST)

  (if (equal? (second (second BST)) '())
          (first (second BST))
          
          
          
      (find-min (second (second BST)))))))
          

; provided tests
(check-expect (find-min BigBST) 1) ;; using the tree defined above

; additional tests
(check-expect (find-min tree-1-node) 15)
(check-expect (find-min node-wLeftChild) 5)
(check-expect (find-min node-wRightChild) 16)
(check-expect (find-min node-wTwoChildren) 6)


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Part E: Define in-order
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;; 
(define (in-order BST)
  
(if (emptyTree? BST)
    '()
    
    (if (equal? (leaf? BST) #t)
        (list (key BST))

        (let* ((leftside (in-order (second BST)))
               (keynode (list (key BST)))
               (rightside (in-order (third BST))))
          (append (append leftside keynode) rightside)))))
               
               
  

; provided tests
(check-expect (in-order BigBST) '(1 7 8 20 31 41 42 60 100)) ;; using the tree defined above

; additional tests
(check-expect (in-order tree-1-node) '(15))
(check-expect (in-order node-wLeftChild) '(5 10))
(check-expect (in-order node-wRightChild) '(16 20))
(check-expect (in-order node-wTwoChildren) '(6 10 11))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Part F: Define delete
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(define (delete e BST)
  
  (if (equal? (member e (in-order BST)) #f)
      BST

      (if (< e (key BST))
          (make-BST (key BST) (delete e (second BST)) (third BST))

          (if (> e (key BST))
              (make-BST (key BST) (second BST) (delete e (third BST)))

              (if (emptyTree? (third BST))
                  (second BST)
                  (make-BST (find-min (third BST)) (second BST) (delete (find-min (third BST)) (third BST))))))))
                  
        
; provided tests
(define BigBST_without20   
  (make-BST 42
            (make-BST 31
                      (make-BST 7
                                (make-BST-leaf 1)
                                (make-BST-leaf 8))
                      (make-BST-leaf 41))
            (make-BST 100 
                      (make-BST-leaf 60)
                      (make-empty-BST))))

;;;; (check-expect (delete 20 BigBST) BigBST_without20)


(define BigBST_without42   
  (make-BST 60
            (make-BST 20
                      (make-BST 7
                                (make-BST-leaf 1)
                                (make-BST-leaf 8))
                      (make-BST 31
                                (make-empty-BST)
                                (make-BST-leaf 41)))
            (make-BST-leaf 100))) 

(check-expect (delete 42 BigBST) BigBST_without42)



;;test case for Remove X from a tree where X has no children & was in a left subtree
(define node-wleftdeleted
  (make-BST 10
          (make-empty-BST)
          (make-empty-BST))) 
 ;; test case for Remove X from a tree where X has no children & was in a right subtree
(define node-wRightChilddeleted
(make-BST 16
          (make-empty-BST)
          (make-empty-BST)))
         

;; test case for Remove X from a tree where X has only a left child
(define BigBST100removed
  (make-BST 42
            (make-BST 20
                      (make-BST 7
                                (make-BST-leaf 1)
                                (make-BST-leaf 8))
                      (make-BST 31
                                (make-empty-BST)
                                (make-BST-leaf 41)))
            (make-BST 60 
                      (make-empty-BST)
                      (make-empty-BST))))
;; test case for Remove X from a tree where X has only a right child
(define BigBSTremove31
  (make-BST 42
            (make-BST 20
                      (make-BST 7
                                (make-BST-leaf 1)
                                (make-BST-leaf 8))
                      (make-BST 41
                                (make-empty-BST)
                                (make-empty-BST)))
                                
            (make-BST 100 
                      (make-BST-leaf 60)
                      (make-empty-BST))))
;; test case for Remove X from a tree where X has two children.
(define BigBSTremove7
  (make-BST 42
            (make-BST 20
                      (make-BST 8
                                (make-BST-leaf 1)
                                (make-empty-BST))
                      (make-BST 31
                                (make-empty-BST)
                                (make-BST-leaf 41)))
            (make-BST 100 
                      (make-BST-leaf 60)
                      (make-empty-BST))))


  
; additional tests

(check-expect (delete 1000 BigBST) BigBST)

; Remove X from a tree with only one node.
(check-expect (delete 15 tree-1-node) '())
; Remove X from a tree where X has no children & was in a left subtree
(check-expect (delete 5 node-wLeftChild) node-wleftdeleted) 
; Remove X from a tree where X has no children & was in a right subtree
(check-expect (delete 20 node-wRightChild) node-wRightChilddeleted)
; Remove X from a tree where X has only a right child
(check-expect (delete 31 BigBST) BigBSTremove31) 
; Remove X from a tree where X has only a left child
(check-expect (delete 100 BigBST) BigBST100removed)
; Remove X from a tree where X has two children
(check-expect (delete 7 BigBST) BigBSTremove7) 
               
(generate-report)