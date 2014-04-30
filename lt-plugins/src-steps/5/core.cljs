(ns lt-plugins.core
  (:require [reagent.core :as reagent :refer [atom]]
            [lt-plugins.ajax :as ajax]))

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

(defn timestamp->str [t]
  (.toDateString (js/Date. t)))

(defn label-value [label value]
  [:div.label-value
   [:div.label label]
   [:div.value value]])

(defn plugin-details [{:keys [added updated installs repo url user]
                        {:keys [name version author source desc]} :info
                        :as p}]
  [:div.details
   [:p.desc desc]
   [label-value "By" author]
   [label-value "Updated" (timestamp->str updated)]
   [label-value "Added" (timestamp->str added)]
   [label-value "Url" [:a {:href url} url]]
   ])

(defn plugin []
  (let [expanded (atom false)]
    (fn [{:keys [url installs] {:keys [name version]} :info :as p}]
      ^{:key name}
      [:div.plugin
       [:h3 [:a {:href url} name]]
       [:p.version version]
       [:p.installs installs]
       [:div.actions
        [:button.expand {:on-click #(swap! expanded not)}
         (if @expanded "-" "+")]]
       (when @expanded
         [plugin-details p])
       ])))

(defn plugins [ps]
  [:div.plugins
   (for [p @ps] [plugin p])])

(defn app [data]
  [:div.app
   [:h1.title "LightTable plugins list"]
   [plugins (:plugins data)]])

(defn init []
  (let [data {:plugins (ajax/get-plugins)}]
    (reagent/render-component [app data]
                              app-dom)))

(init)
