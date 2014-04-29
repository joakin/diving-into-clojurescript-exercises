(ns futurejs-wall.core
  (:require [monet.core :refer [animation-frame]]
            [monet.canvas :as canvas]
            [futurejs-wall.color :as c]))

(enable-console-print!)

(println "Hello world!")

;; CANVAS

(def window-width (.-innerWidth js/window))
(def window-height (.-innerHeight js/window))

(def canvas-dom (.getElementById js/document "canvas"))

(set! (.-width canvas-dom) window-width)
(set! (.-height canvas-dom) window-height)

(def mc (canvas/init canvas-dom "2d"))

#_(canvas/stop-updating mc)

;; BACKGROUND

(defn draw-background! [ctx xs]
  (doseq [x xs]
    (-> ctx
        (canvas/fill-style (c/color->hex (:color x)))
        (canvas/fill-rect x))))

(defn update-background! [tiles]
  (let [update-color #(assoc % :color
                        (c/soft-random! (:color %)))]
    (map update-color tiles))
  )

(defn generate-tiles! [w h]
  (let [size (+ 20 (rand-int 250))
        cols (.ceil js/Math (/ w size))
        rows (.ceil js/Math (/ h size))]
    (for [x (range cols) y (range rows)]
      {:x (* x size) :y (* y size)
       :w size :h size
       :color (map rand-int (repeat 3 255))}
      )))
#_(generate-tiles! window-width window-height)

(defn add-background! []
  (canvas/add-entity mc :background
                     (canvas/entity (generate-tiles! window-width window-height)
                                    update-background!
                                    draw-background!)))

(add-background!)

(js/setInterval add-background! 2000)

;; TEXT

(defn draw-text! [ctx v]
  (-> ctx
      (canvas/fill-style "#ffffff")
      (canvas/font-style "bold 72pt Monaco")
      (canvas/text v)))

(canvas/add-entity mc :text
                   (canvas/entity {:text "FutureJS"
                                   :x 40
                                   :y 100}
                                  nil
                                  draw-text!))
