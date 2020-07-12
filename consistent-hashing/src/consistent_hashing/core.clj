(ns consistent-hashing.core
  (:require [consistent-hashing.ring :refer :all])
  (:import (consistent_hashing.ring HashMapRing)))

(defn -main
  [& args]
  (let [servers '({:name "server-1"
                  :weight 1}
                 {:name "server-2"
                  :weight 1}
                 {:name "server-3"
                  :weight 1})]
        (println (getServerDistribution (doall (create-new-ring servers))))
        (let [r (HashMapRing. {23 "server-2", 184 "server-3", 27 "server-3", 220 "server-1", 14 "server-1", 120 "server-3", 177 "server-2", 253 "server-2", 117 "server-1", 310 "server-2", 318 "server-3", 295 "server-1"})]
          (println (findServer r "lakshay"))
          (println (findServer r "balle"))
          (println (findServer r "yoyo")))))
