
(ns basic.p05-sol)

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

(defn todo->str [index todo]
  (str index ". " todo "\n"))

(todo->str 5 "Call mom")

(defn index-todos [ts]
  (partition 2 (interleave (iterate inc 1) ts)))

(index-todos todos)

(defn todos->str [ts]
  (->> ts
       index-todos
       (map #(apply todo->str %))
       (apply str)
       )
;;   (apply str (map #(apply todo->str %) (index-todos ts)))
  )

(print (todos->str todos)) ; Look at the console (View -> Console)


;; -----------------------------------------------------------------------------------------
;; Create the multiplication tables from 1 to 10
;; Choose how to represent your data. Then create it and massage it.

;; What I chose:
;; 3 * 5 = 15 -> [3 5 15]
;; A table 3 * 1 .. 3 * 10 -> [ [3 1 3] .. [3 10 30] ]
;; All 10 -> { 1 table-of-1 2 table-of-2  ... }

(def multiplication-table
  (group-by first
            (for [x (range 1 11) y (range 1 11) :let [prod (* x y)]]
              [x y prod])))

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

(defn line->str [[x y r :as line]]
  (str x " * " y " = " r "\n"))

(line->str [3 5 15])

(defn table->str [i ts]
  (str "Table of " i "\n"
       "-----------\n"
       (apply str (map line->str ts))
       "\n"))

(println
 (table->str 1 (multiplication-table 1)))

(defn tables->str [m]
  (apply str (map #(apply table->str %) m)))

(println (tables->str multiplication-table))

