
(ns lt-plugins.ui.plugins
  (:require [reagent.core :as reagent :refer [atom]]
            [lt-plugins.ui.label-value :refer [label-value]]
            [lt-plugins.date :refer [timestamp->str]]))

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
   (for [p ps] ^{:key p} [plugin p])])
