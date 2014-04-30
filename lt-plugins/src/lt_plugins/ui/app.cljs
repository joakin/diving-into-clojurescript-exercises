
(ns lt-plugins.ui.app
  (:require [lt-plugins.ui.plugins :refer [plugins]]))

(defn app [data]
  [:div.app
   [:h1.title "LightTable plugins list"]
   [plugins (:plugins data)]])
