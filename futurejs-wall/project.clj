(defproject futurejs-wall "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"

  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2173"]
                 [rm-hull/monet "0.1.11"]]

  :plugins [[lein-cljsbuild "1.0.2"]]

  :source-paths ["src"]

  :cljsbuild {
    :builds [{:id "futurejs-wall"
              :source-paths ["src"]
              :compiler {
                :output-to "web/futurejs_wall.js"
                :output-dir "web/out"
                :optimizations :none
                :source-map true}}]})
