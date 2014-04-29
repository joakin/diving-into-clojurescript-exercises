
(ns basic.p03-sol)

;; -----------------------------------------------------------------------------------------
;; Define a function that will return true/false when the number argument
;; is a multiple of 2 and 3. (Hint: mod)

(defn mult-2-3? [n]
  (if (= 0 (mod n 2) (mod n 3))
    true
    false))

(comment
  (mult-2-3? 6)
  (mult-2-3? 50)
  (mult-2-3? 13)
  (mult-2-3? 24)
  )

;; -----------------------------------------------------------------------------------------
;; Salute function. Write a function that says "Hi! We are learning Cljs."
;; When passed a name, then salute that person "Hi Joaquin! We are learning Cljs."
;; Hints: empty?

(defn salute
  "Say hi! With no args it gives a generic salutation
  When passed a name it salutes such person"
  ([] (salute ""))
  ([s]
   (let [str-name (if (empty? s) "" (str " " s))]
     (str "Hi" str-name "! "
          "We are learning Cljs."))))

(comment
  (salute)
  (salute "Joaquin")
  )
