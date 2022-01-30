(ns generic-sensor-data-collector.api
  (:require [generic-sensor-data-collector.database :refer :all]))

(defn add-sensor-data [data]
  (println data)
  ;(insert-temperature "temperature" data)
  data)

(defn add-sensor-data-list [data]
  (println data)
  ;(insert-temperature "temperature" data)
  data)
