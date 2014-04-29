
(ns futurejs-wall.color)

(defn random-color! []
  (map rand-int (repeat 3 255)))

#_(random-color!)

(defn randomize-component! [n]
  (let [r (- (rand-int 15) 7)
        rn (+ n r)]
    (-> rn
     (min 255)
     (max 0))))

#_(randomize-component! 255)

(defn randomize-color! [color]
  (map randomize-component! color))

#_(randomize-color! [50 255 0])

(defn- int->hex [n]
  (.toString n 16))

#_(int->hex 16)

(defn- pad [s]
  (if (= 1 (count s))
    (str "0" s)
    s))

#_(pad "4")
#_(pad "10")

(defn color->hex [color]
  (let [hex-color (map (comp pad int->hex) color)]
    (str "#" (apply str hex-color))))

#_(color->hex [5 120 250])
