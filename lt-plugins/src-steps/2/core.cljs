(ns lt-plugins.core
  (:require [reagent.core :as reagent :refer [atom]]
            [ajax.core :refer [GET POST]]))

(enable-console-print!)

(println "Hello world!")

(def app-dom (.querySelector js/document "#app"))

(defn plugins []
  [:div.plugins
   [:p "Nothing to see here... yet"]])

(defn app []
  [:div.app
   [:h1.title "LightTable plugins list"]
   [plugins]])

(reagent/render-component [app] app-dom)
