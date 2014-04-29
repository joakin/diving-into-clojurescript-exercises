(defproject lt-plugins "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"

  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2173"]
                 [reagent "0.4.2"]
                 [cljs-ajax "0.2.3"]]

  :plugins [[lein-cljsbuild "1.0.2"]]

  :source-paths ["src"]

  :cljsbuild {
    :builds [{:id "lt-plugins"
              :source-paths ["src"]
              :compiler
              {:output-to "web/lt_plugins.js"
               :output-dir "web/out"
               :optimizations :none
               :source-map true
               }}]})
