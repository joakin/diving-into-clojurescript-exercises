
(ns lt-plugins.server
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]))

(def root (str (System/getProperty "user.dir") "/web"))

(defroutes app-routes
  (route/files "/" (do (println root) {:root root}))
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
