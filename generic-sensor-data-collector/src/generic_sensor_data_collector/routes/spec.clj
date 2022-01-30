(ns generic-sensor-data-collector.routes.spec
  (:require [compojure.api.sweet :refer [context GET resource]]
            [ring.util.http-response :refer [ok]]
            [clojure.spec.alpha :as s]
            [spec-tools.spec :as spec]
            [generic-sensor-data-collector.api :refer :all]
            [generic-sensor-data-collector.config :refer :all]))

(s/def ::value number?)
(s/def ::type (get-allowed-sensors))
(s/def ::origin string?)
(s/def ::description string?)
(s/def ::_id any?)
(s/def ::date string?)

;(s/def ::generic-data-model (s/keys :req-un [::value ::type ::origin ::date]
;                                    :opt-un [::description]))

;(s/def ::sensor-data-seq2 (s/coll-of number?))
;(s/def ::generic-data-model2 (s/keys :req-un [::sensor-data-seq2]
;                                     :opt-un [::description]))

(s/def ::sensor-data (s/keys :req-un [::value ::type ::origin ::date]
                             :opt-un [::description]))
(s/def ::sensor-data-coll-of (s/coll-of ::sensor-data))
(s/def ::sensor-data-list (s/keys :req-un [::sensor-data-coll-of]))

(s/def ::sensor-data-response (s/keys :req-un [::value ::type ::origin ::date ::_id]
                                      :opt-un [::description]))

(def routes
  (context "/generic-data-api" []
    :tags ["spec"]
    :coercion :spec

    (context "/add" []
      (resource
        {:post {:summary    "data-driven plus with clojure.spec"
                :parameters {:body-params ::sensor-data}
                :responses  {200 {:schema ::sensor-data}}
                :handler    (fn [{b :body-params}]
                              (ok (add-sensor-data b)))}}))

    (context "/add-list" []
      (resource
        {:post {:summary    "data-driven plus with clojure.spec"
                :parameters {:body-params ::sensor-data-list}
                :responses  {200 {:schema ::sensor-data-list}} ; ::generic-data-response
                :handler    (fn [{b :body-params}]
                              (ok (add-sensor-data-list b)))}}))))

; todo add post for single data
