
(ns basic.p02-sol)

;; -----------------------------------------------------------------------------------------
;; Get correct when evaling these results

(let [x __ y __]
  (if (and (< x y)
           (= (/ y x) 3))
    "Correct!"))

;; -----------------------------------------------------------------------------------------
(def my-name "Joaquin")

(let [s "qu"
      k "Jo"
      n (__ __ "a" __ "in")]
  (when (= my-name n)
    "Correct!"))

