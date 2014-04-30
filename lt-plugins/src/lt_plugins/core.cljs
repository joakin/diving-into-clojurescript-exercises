(ns lt-plugins.core
  (:require [reagent.core :as reagent]
            [lt-plugins.ajax :as ajax]
            [lt-plugins.ui.app :refer [app]]))

(enable-console-print!)

(println "Hello world!")

(def app-dom (.querySelector js/document "#app"))

(defn init []
  (let [data {:plugins (ajax/get-plugins)}]
    (reagent/render-component [app data]
                              app-dom)))

(init)
