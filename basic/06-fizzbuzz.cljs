
(ns basic.p06)

;; Make a function that gives us madeup-fizzbuzz from 1 to n (argument)
;; Fizzbuzz : numbers modulo 2 say Fizz
;;            numbers modulo 3 say Buzz
;;            numbers modulo 2 & 3 say FizzBuzz

__...

(defn fizzbuzz [n]
  __)

(fizzbuzz 30)

;; -----------------------------------------------------------------------------------------
;; Make a function that when passed in a key (:up, :down, ...) gives us a game command
;; Next you can see the correspondence of command -> accepted keys
;; :left -> :left :a
;; :right -> :right :d
;; :shoot -> :space :s :enter
;; :turbo -> :t :w
;; :menu -> :esc

(defn key->command [k]
   __)

(key->command :esc)
