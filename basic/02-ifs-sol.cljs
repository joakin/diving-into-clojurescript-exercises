
(ns basic.p02-sol)

;; -----------------------------------------------------------------------------------------
;; Get correct when evaling these results

(let [x 2 y 6]
  (if (and (< x y)
           (= (/ y x) 3))
    "Correct!"))

;; -----------------------------------------------------------------------------------------
(def my-name "Joaquin")

(let [s "qu"
      k "Jo"
      n (str k "a" s "in")]
  (when (= my-name n)
    "Correct!"))

