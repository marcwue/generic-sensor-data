(ns generic-sensor-data-collector.handler
  (:require [compojure.api.sweet :refer [api]]
            [generic-sensor-data-collector.routes.spec]))

(def app
  (api
    {:swagger
     {:ui "/"
      :spec "/swagger.json"
      :data {:info {:title "Generic-sensor-data-collector"
                    :description "Compojure Api example"}
             :tags [{:name "api", :description "some apis"}]}}}

    ;generic-sensor-data-collector.routes.schema/routes
    generic-sensor-data-collector.routes.spec/routes
    ))
