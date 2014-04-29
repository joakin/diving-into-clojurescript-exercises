
(ns futurejs-wall.background
  (:require [monet.canvas :as canvas]
            [futurejs-wall.color
             :refer [random-color! color->hex randomize-color!]]))

(defn create [width height]
  (let [size (+ 10 (rand-int 250))
        how-many? #(.ceil js/Math (/ % %2))
        cols (how-many? width size)
        rows (how-many? height size)]
    (for [x (range cols) y (range rows)
          :let [px (* x size) py (* y size)
                color (random-color!)] ]
      {:x px :y py
       :w size :h size
       :color color}))
  )

#_(create 500 500)

(defn- update-tile [{:keys [color] :as bg}]
  (assoc bg :color (randomize-color! color)))

#_(update-tile {:color [20 50 10]})

(defn update [bgs]
  (map update-tile bgs))

#_(update [{:color [20 50 10]} {:color [20 50 10]}])

(defn- render-tile! [ctx bg]
  (-> ctx
      (canvas/fill-style (color->hex (:color bg)))
      (canvas/fill-rect bg)
      ))

(defn render! [ctx bgs]
  (doseq [bg bgs]
    (render-tile! ctx bg)))
