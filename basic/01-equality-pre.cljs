
;; This is how you define a clojurescript module (ns for NameSpace) (subns with dots)
(ns basic.p01-pre)

; This is a comment (used for EOL or in-code small comments)
;; This is too (Used for text comments, like the ones in this file)

;; Lets go:

;; -----------------------------------------------------------------------------------------
;; A number (JS numbers)

1

0.2

(+ 0.1 0.2)

;; -----------------------------------------------------------------------------------------
;; A string (JS strings)

"Hi, how are you people?"

;; -----------------------------------------------------------------------------------------
;; A boolean (JS booleans)

;; true
;; false
;; If you leave them uncommented you wont be able to eval after them (??? wtf)

;; -----------------------------------------------------------------------------------------
;; A keyword (Only cljs)

:hi-guys

;; -----------------------------------------------------------------------------------------
;; Our old friend null here is called nil

;; nil

;; -----------------------------------------------------------------------------------------
;; How do I call a function?
;; Just give it a parenthesis hug
;; Instead of add(1, 2) you hug (add) and put the parameters after it

(+ 1 2)

;; -----------------------------------------------------------------------------------------
;; Math: + - / *
;; Weird prefix math...

;; How do I do == or === in cljs?
;; There is = function for that, just one, no type coercion, and it does value comparison

(= 1 1)

;; -----------------------------------------------------------------------------------------
;; There is a function to check if a num is even. Guess?

(even? 1)
;; Check this out (docs (ctrl-d) (cmd-shift-d))
;; Symbols (var names) can have all chars!!

;; -----------------------------------------------------------------------------------------
;; Vector (kind of like the js array) (Only cljs)

[1 2 3]
(vector 1 2 3)
;; No commas, just the values inside.
;; Immutable, we will see that later
;; Efficient append and random access

;; -----------------------------------------------------------------------------------------
;; Array (JS array)

(array 1 2 3)
;; Short notation
;; #js[1 2 3]
