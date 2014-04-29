
(ns basic.p05)

;; Given some todos:
(def todos ["Buy milk"
            "Read newspaper"
            "Pick up olives"
            "1h jog"])

;; Produce numbered and line separated text of the todos. Ex
;; 1. asdf
;; 2. fdsa
;; All together in one string

;; Try to make little functions that do one thing and compose them
;; together as you go.

__

(print (todos->str todos)) ; Look at the console (View -> Console)


;; -----------------------------------------------------------------------------------------
;; Create the multiplication tables from 1 to 10
;; Choose how to represent your data. Then create it and massage it.

;; Ask for hints if you can't think of anything

(def multiplication-table
  __)

;; Make a string representation of it (for the console)
;; Ex:
;; Table of 1
;; -----------
;; 1 * 1 = 1
;; 1 * 2 = 2
;; 1 * 3 = 3
;; 1 * 4 = 4
;; 1 * 5 = 5
;; 1 * 6 = 6
;; 1 * 7 = 7
;; 1 * 8 = 8
;; 1 * 9 = 9
;; 1 * 10 = 10

;; Table of 2
;; ...

__...

(println (tables->str multiplication-table))
