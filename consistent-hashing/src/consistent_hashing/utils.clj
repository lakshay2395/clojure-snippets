(ns consistent-hashing.utils)

(defn random-index-generator [start end]
  (+ (Math/floor (* (Math/random) (- end start))) start))

(defn find-random-empty-index-in-range [start end]
  (loop [random-index (random-index-generator start end)]
    (let [server-name (get map random-index)]
      (if (nil? server-name)
        (int random-index)
        (recur (random-index-generator start end))))))