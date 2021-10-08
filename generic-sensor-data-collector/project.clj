 (defproject generic-sensor-data-collector "0.1.0"
   :description "backend for generic sensor data"
   :dependencies [[org.clojure/clojure "1.10.0"]
                  [metosin/compojure-api "2.0.0-alpha30"]
                  [org.clojure/core.async "1.3.618"]
                  [com.novemberain/monger "3.1.0"]
                  [clj-commons/clj-yaml "0.7.107"]]
   :ring {:handler generic-sensor-data-collector.handler/app
          ; this is for clojure.core.async
          :async? true
          ; you can use cider-connect with port 9000 to connect emacs
          :nrepl {:start? true :port 9000}}
   :uberjar-name "server.jar"
   :profiles {:dev {:dependencies [[javax.servlet/javax.servlet-api "3.1.0"]]
                    :plugins [[lein-ring "0.12.5"]]}})
