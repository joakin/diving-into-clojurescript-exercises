
(ns futurejs-wall.background
  (:require [monet.canvas :as canvas]))

(defn create [width height]
  {:x 0 :y 0 :w width :h height :color "#191d21"})

(def update nil)

(defn render! [ctx bg]
  (-> ctx
      (canvas/fill-style (:color bg))
      (canvas/fill-rect bg)))
