
(ns lt-plugins.ui.label-value)

(defn label-value [label value]
  [:div.label-value
   [:div.label label]
   [:div.value value]])
