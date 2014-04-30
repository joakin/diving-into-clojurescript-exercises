
(ns lt-plugins.ajax
  (:require [ajax.core :refer [GET POST]]
            [reagent.core :as reagent :refer [atom]]))

(def plugins (atom nil))

;; If we had to do an ajax call:
(defn handler [response]
  (reset! plugins response))

(defn error-handler [{:keys [status status-text]}]
  (.log js/console (str "something bad happened: " status " " status-text)))

(defn get-plugins-edn []
  (GET "plugins.edn"
     {:handler handler
      :error-handler error-handler}))

(defn get-plugins-lighttable []
  (GET "http://www.corsproxy.com/plugins.lighttable.com/"
     {:handler handler
      :error-handler error-handler}))

(defn get-plugins []
  (get-plugins-lighttable)
  plugins)

#_(get-plugins)
