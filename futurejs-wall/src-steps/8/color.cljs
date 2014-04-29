(ns futurejs-wall.color)

(defn random-color! []
  (str "#" (.toString (rand-int 16rFFFFFF) 16)))

#_(random-color!)

(defn- randomize-component [n]
  (let [rnd (- (rand-int 9) 4)
        nn (+ n rnd)]
    (-> nn
        (min 255)
        (max 0))))

#_(randomize-component 250)

(defn soft-random! [color]
  (map randomize-component color))

#_(soft-random [1 1 1])

(defn- int->hex [color]
  (let [h (.toString color 16)]
    (if (= 1 (count h))
      (str "0" h)
      h)))

(defn color->hex [color]
  (str "#" (apply str (map int->hex color))))

#_(color->hex (soft-random! [16 2 3]))

#_(defn make-color-gradient
  ([fx px] (make-color-gradient fx px 128 127 50))
  ([fx px c w l]
   (let [xs (map #(repeat 3 %) (range l))
         fxs (repeat l fx)
         pxs (repeat l px)
         to-color (fn [is fs ps]
                    (map #(+ (* (.sin js/Math (+ (* % %2) %3)) w) c) is fs ps)
                    )]
     (map to-color xs fxs pxs))))


#_(do
    (set! (.-innerHTML js/document.body) "")
    (doseq [c (make-color-gradient [0.3 0.3 0.3] [0 2 4])]
      (.write js/document
              (str "<font color=\"" (color->hex c) "\">&#9608;</font>"))))
