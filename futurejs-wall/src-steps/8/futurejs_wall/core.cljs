(ns futurejs-wall.core
  (:require [monet.canvas :as canvas]
            [futurejs-wall.background :as bg]
            [futurejs-wall.title :as title]
            ))

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

;; Add background
(defn add-background []
  (canvas/add-entity monet-canvas :background
                     (canvas/entity (bg/create width height)
                                    bg/update
                                    ;;                                   nil
                                    bg/render!)))

(add-background)
(js/setInterval add-background 1500)

;; Add title
(canvas/add-entity monet-canvas :title
                   (canvas/entity (title/create 20 100 "FutureJS")
                                  title/update
                                  title/render!))
