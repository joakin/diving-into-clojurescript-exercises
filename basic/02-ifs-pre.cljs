
(ns basic.p02-pre)

;; -----------------------------------------------------------------------------------------
;; To the important stuff. How do I if?
(if false
  1
  2)

;; -----------------------------------------------------------------------------------------
;; The only falsy values are nil and false, nothing else
(if nil
  1
  2)

;; -----------------------------------------------------------------------------------------
;; Not like in JS (I'm looking at you, 0, '' and [])
(if (or 0 "" [])
  1 2)

;; -----------------------------------------------------------------------------------------
;; BTW, boolean logic
and
or
not

;; -----------------------------------------------------------------------------------------
;; There is also a nice when
(when true
  (+ 1 2)
  (+ 2 3))

;; -----------------------------------------------------------------------------------------
;; How the hell do I define variables?

;; Namespace level variables:
(def x 1)

x

;; -----------------------------------------------------------------------------------------
;; Local variables
(let [y 1 z 2]
  y
  z)

y
z