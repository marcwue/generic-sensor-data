(ns generic-sensor-data-collector.api
  (:require [generic-sensor-data-collector.database :refer :all]))

(defn post-generic-data [data]
  (println data)
  (insert-temperature "temperature" data))
