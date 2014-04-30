
(ns lt-plugins.date)

(defn timestamp->str [t]
  (.toDateString (js/Date. t)))
