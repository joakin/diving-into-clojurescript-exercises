
(ns basic.p01)

;; -----------------------------------------------------------------------------------------
;; Some comparisons. Check them out
(= 2 2)

(= false true)

(= :hi :hi)

;; -----------------------------------------------------------------------------------------
;; Cljs equality is the same as in JS, except for cljs data structures
(= #js[1 2 3] #js[1 2 3])

(= [1 2 3] [1 2 3])
;; WOHOOO (it is efficient, not a mere deepEquals)

;; -----------------------------------------------------------------------------------------
;; Cljs has kinky math
(= __ (+ 1 (- 6 2) (* 3 4)))
;; Lots of arguments, and you can pass them around as functions

;; -----------------------------------------------------------------------------------------
;; For string concat we use the str function
(= __ (str "He" "llo"))

;; -----------------------------------------------------------------------------------------
;; Can you guess how you compare greater than, less than, etc?
(__ 1 5)
(__ 2 2)
(__ 5 1)

