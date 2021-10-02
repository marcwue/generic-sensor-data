(ns generic-sensor-data-collector.database
  (:require [monger.core :as mg]
            [monger.credentials :as mcred]
            [monger.collection :as mc])
  (:import [com.mongodb MongoOptions ServerAddress]))

(let [conn (let [conn-db "admin"
                 conn-u "clojure-rw"
                 conn-p "asdf1234"]
             (mg/connect-with-credentials "127.0.0.1" 27017 (mcred/create conn-u conn-db conn-p)))
             ;(mg/connect))
      db (mg/get-db conn "sensor-data")]

  (defn insert-temperature [collection data]
    (mc/insert-and-return db collection data)))
