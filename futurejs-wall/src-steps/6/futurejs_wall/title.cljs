
(ns futurejs-wall.title
  (:require [monet.canvas :as canvas]))

(defn create [x y text]
  {:x x :y y :text text})

(def update nil)

(defn render! [ctx t]
  (-> ctx
      (canvas/fill-style "#eeeeff")
      (canvas/font-style "bold 72pt Monaco")
      (canvas/text t)))
