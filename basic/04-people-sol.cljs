
(ns basic.p04-sol)

;; Having some users
(def users [{:name "Juan"   :age 31 :city "Alicante"}
            {:name "Maria"  :age 28 :city "Valencia"}
            {:name "Pablo"  :age 66 :city "Barcelona"}
            {:name "German" :age 51 :city "Madrid"}
            {:name "David"  :age 43 :city "Madrid"}
            {:name "Alba"   :age 25 :city "Albacete"}])

;; Get the average age of all users

(defn average-age
  "Gets the average age of a collection of x with :age"
  [xs]
  (let [len (count xs)
        sum (reduce + (map :age xs))]
    (/ sum len)))

(average-age users)

;; Which cities are the +40yo people from?
;; Hint: distinct

(defn cities-of-elders [xs]
  (let [old? #(> (:age %) 40)]
    (distinct (map :city (filter old? xs)))))

;; (defn cities-of-elders [xs]
;;   (let [old? #(> (:age %) 40)]
;;     (->> xs
;;      (filter old?)
;;      (map :city)
;;      distinct)))
;; There is also -> for the first argument

(cities-of-elders users)

;; List of alphabetically ordered names
;; Hint: sort

(def names (comp sort (partial map :name)))

(defn names [xs]
  (sort (map :name xs)))

(names users)
