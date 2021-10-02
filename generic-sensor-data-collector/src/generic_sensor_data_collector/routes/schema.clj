(ns generic-sensor-data-collector.routes.schema
  (:require
   [compojure.api.sweet :refer [context GET POST]]
   [ring.util.http-response :refer :all]
   [schema.core :as s]
   [clojure.core.async :as a]
   [generic-sensor-data-collector.api :refer :all]))

(s/defschema GenericData
  {:value s/Num
   :type (s/enum :TEMP :HUMIDITY)
   :origin s/Str
   (s/optional-key :description) s/Str})

(s/defschema GenericDataResponse
  {:_id s/Any
   :value s/Num
   :type (s/enum :TEMP :HUMIDITY)
   (s/optional-key :description) s/Str})

(s/defschema MongoDbId
  {:timestamp s/Num
   :machineIdentifier s/Num
   :processIdentifier s/Num
   :counter s/Num
   :time s/Num
   :date s/Str
   :timeSecond s/Num})

(def routes
  (context "/api" []
           :tags ["api"]

           (POST "/generic-data" []
                 :return GenericDataResponse
                 :body [genericData GenericData]
                 :summary "echoes a data"
                 (ok (post-generic-data genericData)))
           
           (GET "/generic-data" []
                :query-params [type :- String]
                (a/go
                  (a/<! (a/timeout 5000))
                  (ok {:message (str "Hello, " name)})))))
