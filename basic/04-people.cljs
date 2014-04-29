
(ns basic.p04)

;; Having some users
(def users [{:name "Juan"   :age 31 :city "Alicante"}
            {:name "Maria"  :age 28 :city "Valencia"}
            {:name "Pablo"  :age 66 :city "Barcelona"}
            {:name "German" :age 51 :city "Madrid"}
            {:name "David"  :age 43 :city "Madrid"}
            {:name "Alba"   :age 25 :city "Albacete"}])

;; Get the average age of all users

__

(average-age users)

;; Which cities are the +40yo people from?
;; Hint: distinct

__

(cities-of-elders users)

;; List of alphabetically ordered names
;; Hint: sort

__

(names users)
