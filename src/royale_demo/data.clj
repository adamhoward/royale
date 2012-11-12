(ns royale-demo.data
  (:require [clojure.java.jmx :as jmx]
           [clojure.set :as set]
           [clojure.math.numeric-tower :as math]
           [clojure.string :as string]))

;;; http://stackoverflow.com/questions/1676891
(defn- map-over-map-values [f m]
  (into {} (for [[k v] m] [k (f v)])))

(defn- bytes-to-megabytes [bytes]
  (str (math/round (/ (/ bytes 1024) 1024)) " MB"))

(defn my-memory []
  (set/rename-keys
   (map-over-map-values
    bytes-to-megabytes
    (jmx/read "java.lang:type=Memory" :HeapMemoryUsage))
   {:committed :total}))

(defn my-classes-loaded []
  {:classes (jmx/read "java.lang:type=ClassLoading" :LoadedClassCount)})

(defn my-generations []
  (map
   #(set/union
     {:generation (second (string/split (.toString %) #"name="))}
     (map-over-map-values bytes-to-megabytes (jmx/read % :Usage)))
   (jmx/mbean-names "java.lang:type=MemoryPool,name=*")))