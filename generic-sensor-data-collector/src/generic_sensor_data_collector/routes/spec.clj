(ns generic-sensor-data-collector.routes.spec
  (:require [compojure.api.sweet :refer [context GET resource]]
            [ring.util.http-response :refer [ok]]
            [clojure.spec.alpha :as s]
            [spec-tools.spec :as spec]
            [generic-sensor-data-collector.api :refer :all]))

(s/def ::value number?)
(s/def ::type #{"TEMP" "HUMIDITY"})
(s/def ::origin string?)
(s/def ::description string?)
(s/def ::_id any?)
(def generic-data-model (s/keys :req-un [::value ::type ::origin]
                                :opt-un [::description]))

(def asdf (s/keys :req-un [::value ::type]))

(s/def ::generic-data-response (s/keys :req-un [::value ::type ::origin ::_id]
                                       :opt-un [::description]))

(def routes
  (context "/api" []
    :tags ["spec"]
    :coercion :spec

    (context "/generic-data" []
      (resource
        {:post
         {:summary "data-driven plus with clojure.spec"
          :parameters {:body-params generic-data-model}
          :responses {200 {:schema ::generic-data-response}}
          :handler (fn [{b :body-params}]
                     (ok (post-generic-data b)))}}))))
