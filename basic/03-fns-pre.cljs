
(ns basic.p03)

;; FUNCTIONAL programming!!

;; -----------------------------------------------------------------------------------------
;; We can define functions 3 different ways (top-level, anonymous, and inline-anonymous)

;; ns level
(defn add [x y]
  (+ x y))

(add 1 2)

;; anonymous
(fn not-add [x y]
  (- x y))

(not-add 4 2)

(let [i-said-not-add!!please? (fn [x y] (+ x y))]
  (i-said-not-add!!please? 4 2))

;; anonymous inline (short concise syntax for short inline functions)

(#(+ % %2) 4 2)

;; -----------------------------------------------------------------------------------------
;; Commenting code (not text, but code)

#_(str "Hi, " 10 " people")

(defn str->evil-str [s]
  (str s " MUAHAHAHAH!!!!"))

(comment
  (str->evil-str "Hi guys!")
  (str->evil-str "I love dogs.")
  )

;; -----------------------------------------------------------------------------------------
;; defn functions can have goodies, like documentation and multiple bodies
;; depending on arguments length

(defn add
  "Adds numbers"
  ([x] x)
  ([x y] (+ x y))
  ([x y & xs] (+ x y (apply add xs))))

(comment
  (add 1)
  (add 1 2)
  (add 1 2 3 4 5)
  )

;; Note the &, that is rest arguments, like es6 ... rest operator and coffeescript
