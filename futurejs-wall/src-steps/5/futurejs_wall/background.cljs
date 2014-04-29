
(ns futurejs-wall.background
  (:require [monet.canvas :as canvas]
            [futurejs-wall.color :refer [random-color! color->hex]]))

(defn create [width height]
  {:x 0 :y 0 :w width :h height :color (random-color!)})

(defn update [bg]
  (assoc bg :color (random-color!)))

(defn render! [ctx bg]
  (-> ctx
      (canvas/fill-style (color->hex (:color bg)))
      (canvas/fill-rect bg)))
