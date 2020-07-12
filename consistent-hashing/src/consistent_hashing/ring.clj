(ns consistent-hashing.ring
  (:require [consistent-hashing.utils :as utils]
            [biscuit.core :as digest]))

(defprotocol Ring
  (findServer      [this request-key])
  (addServer       [this name weight])
  (removeServer    [this name])
  (getServerDistribution [this]))

(defrecord HashMapRing [map]
  Ring

  (findServer [this request-key]
    (let [crc32 (digest/crc32 request-key)
          ring-index (mod crc32 360)]
      (println "request-key = " request-key " , index = " ring-index)
      (loop [index ring-index]
        (if-not (nil? (get map index))
          (get map index)
          (recur (mod (inc index) 360))))))

  (addServer [this name weight]
    (loop [iteration-count weight
           result map]
      (if (zero? iteration-count)
        (HashMapRing. result)
        (let [indices [(utils/find-random-empty-index-in-range 0 90)
                       (utils/find-random-empty-index-in-range 90 180)
                       (utils/find-random-empty-index-in-range 180 270)
                       (utils/find-random-empty-index-in-range 270 360)]
              new-map (assoc map (get indices 0) name (get indices 1) name (get indices 2) name (get indices 3) name)]
          (println indices)
          (recur (- iteration-count 1) new-map)))))

  (removeServer [this name]
    (loop [index 0
           result map]
      (if (= index 360)
        (HashMapRing. result)
        (if (= (get result index) name)
          (recur (inc index) (dissoc result index))
          (recur (inc index) result)))))

  (getServerDistribution [this]
    map))


(defn create-new-ring [distribution]
  (reduce (fn [ring item]
            (let [name (:name item)
                  weight (:weight item)]
              (addServer ring name weight)))
          (HashMapRing. {})
          distribution))