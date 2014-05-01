
(ns basic.p06-sol)

;; Make a function that gives us madeup-fizzbuzz from 1 to n (argument)
;; Fizzbuzz : numbers modulo 2 say Fizz
;;            numbers modulo 3 say Buzz
;;            numbers modulo 2 & 3 say FizzBuzz

(defn mult? [n d]
  (= (mod n d) 0))

(mult? 6 2)
(mult? 3 2)

(defn num->fizzbuzz [n]
  (cond
   (and (mult? n 2)
        (mult? n 3)) "FizzBuzz"
   (mult? n 2) "Fizz"
   (mult? n 3) "Buzz"
   :else n))

(num->fizzbuzz 2)
(num->fizzbuzz 3)
(num->fizzbuzz 6)

(defn fizzbuzz [n]
  (map num->fizzbuzz (range 1 (inc n))))

(fizzbuzz 30)


;; -----------------------------------------------------------------------------------------
;; Make a function that when passed in a key (:up, :down, ...) gives us a game command
;; Next you can see the correspondence of command -> accepted keys
;; :left -> :left :a
;; :right -> :right :d
;; :shoot -> :space :s :enter
;; :turbo -> :t :w
;; :menu -> :esc

(def left-keys #{:left :a})
(def right-keys #{:right :d})
(def shoot-keys #{:space :s :enter})
(def turbo-keys #{:t :w})
(def menu-keys #{:esc})

(defn key->command [k]
  (cond
   (left-keys k) :left
   (right-keys k) :right
   (shoot-keys k) :shoot
   (turbo-keys k) :turbo
   (menu-keys k) :menu))

(key->command :esc)

;; Another way

(def commands {#{:left :a} :left
               #{:right :d} :right
               #{:space :s :enter} :shoot
               #{:t :w} :turbo
               #{:q} :menu})

(defn key->command [k]
  (let [matches (fn [[keys cmd]]
                  (if (keys k) cmd))]
    (some matches commands)))

(key->command :d)
