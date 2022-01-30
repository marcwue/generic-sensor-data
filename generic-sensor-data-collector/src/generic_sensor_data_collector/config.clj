(ns generic-sensor-data-collector.config
  (:require [clj-yaml.core :as yaml]))

(def configfile "config.yaml")

(def config
  (yaml/parse-string (slurp configfile)))

(defn get-allowed-sensors []
  (reduce (fn [result [k v]] (reduce conj result v)) #{} (:sensor-tables (:collector config))))
