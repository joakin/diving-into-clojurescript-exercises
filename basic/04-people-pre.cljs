
(ns basic.p04-pre)

;; -----------------------------------------------------------------------------------------
;; We also have cljs maps (immutable)

(def me {:name "Joaquin" :city "Alicante"})

;; -----------------------------------------------------------------------------------------
;; For JS maps we do as with vectors
(def obj (js-obj "name" "Joaquin"))
(= obj #js{:name "Joaquin"})

;; -----------------------------------------------------------------------------------------
;; To get something from a map:

(get me :name)
(get me :age :immortal)

(me :name)
(:name me)

(def mes (repeat 3 me))

(map :name mes)

;; There is also get-in for nested keys
(let [p {:name "Anonymous"
         :prefs {:food :shushi}}]
  (get-in p [:prefs :food]))

;; -----------------------------------------------------------------------------------------
;; Get works also with vectors

(get [1 2 3] 2)

([1 2 3] 1)

;; -----------------------------------------------------------------------------------------
;; Lets see how we manipulate collections (we don't usually
;; do loops)

(range 2 8)
;; Careful when evaling (range), infinite seq

;; Usual suspects
(map inc (range 10))

(filter even? (range 10))

(reduce + (range 10))

;; -----------------------------------------------------------------------------------------
;; We can count collections with count

(count mes)

(count (range 10))

;; Works with maps and all other collections
(count me)
(keys me)
(vals me)





