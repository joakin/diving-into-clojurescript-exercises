
(ns basic.p05-pre)

;; -----------------------------------------------------------------------------------------
;; You may have noticed that map, filter, ... return a
;; collection that is shown with (1 2 3) instead of []
;; Thats a list (immutable)

(list 1 2 3)
'(1 2 3)

;; Efficient prepend, not efficient random access or count
;; Its what the std lib coll functions return usually
;; You can convert back to whatever you want, no overhead

(vec (map inc (range 10)))

;; -----------------------------------------------------------------------------------------
;; All functions in stdlib work with all collections
;; Some more

(partition 2 (range 10))

(interpose "," (repeat 5 "Joaquin"))

(interleave (repeat 5 :hi) (range 5))

;; -----------------------------------------------------------------------------------------
;; Careful with functions that return lazy inf seqs

;; (range) ; Infinite! Editor will try to print it
;; We can use take with them to check them out
(take 100 (range))

;; map filter and all work with lazy seqs. Won't compute
;; until needed

;; We can create our own infinite seqs
(take 50 (repeat "HI!"))

(take 20 (iterate inc 1))

(take 20 (iterate #(str % "0") ""))

(take 5 (cycle [1 2 3]))

;; Very useful for computing functionally instead of loops

;; -----------------------------------------------------------------------------------------
;; We also got list comprehensions (es6 and coffeescript like)
;; Like a for, but it produces an array with the result of each iteration.

;; Lets create a matrix of points (x, y)
(for [x (range 10) y (range 10)]
  [x y])
;; Just with the diagonal
(for [x (range 10) y (range 10) :when (= x y)]
  [x y])
;; Lets have also (x times y in our points (x, y, x*y))
(for [x (range 10) y (range 10) :let [prod (* x y)]]
  [x y prod])

;; -----------------------------------------------------------------------------------------
;; One more, group-by

;; Imagine we want to group a coll of numbers into evens and odds in a map

(defn even-or-odd [n]
  (if (even? n) :even :odd))

(group-by even-or-odd (range 10))

;; -----------------------------------------------------------------------------------------
;; And a couple more
(range 5)
(first (range 5))
(second (range 5))
(rest (range 5))
(last (range 5))
(butlast (range 5))

