(ns futurejs-wall.core
  (:require [monet.canvas :as canvas]))

(enable-console-print!)

(println "Hello world!")

;; Window dimensions
(def width (.-innerWidth js/window))
(def height (.-innerHeight js/window))

(def canvas-dom (.getElementById js/document "canvas"))

;; Resize the canvas to fullscreen
(set! (.-width canvas-dom) width)
(set! (.-height canvas-dom) height)

(def monet-canvas (canvas/init canvas-dom "2d"))

(canvas/add-entity monet-canvas :background
                   (canvas/entity {:x 0 :y 0 :w width :h height}
                                  nil                       ; update function
                                  (fn [ctx val]             ; draw function
                                    (-> ctx
                                        (canvas/fill-style "#191d21")
                                        (canvas/fill-rect val)))))
