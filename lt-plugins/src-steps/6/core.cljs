(ns lt-plugins.core
  (:require [reagent.core :as reagent]
            [lt-plugins.ajax :as ajax]
            [lt-plugins.ui.app :refer [app]]))

(enable-console-print!)

(println "Hello world!")

(def app-dom (.querySelector js/document "#app"))


;; {:added 1389153835495,
;;  :info {:dependencies {},
;;         :name Clojure,
;;         :version 0.0.10,
;;         :author Kodowa,
;;         :source https://github.com/LightTable/Clojure,
;;         :desc Clojure integration for Light Table,
;;         :behaviors clojure.behaviors},
;;  :installs 10290,
;;  :repo Clojure,
;;  :updated 1397752711508,
;;  :url https://github.com/LightTable/Clojure,
;;  :user LightTable}

(defn init []
  (let [data {:plugins (ajax/get-plugins)}]
    (reagent/render-component [app data]
                              app-dom)))

(init)
