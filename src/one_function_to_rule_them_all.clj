(ns one-function-to-rule-them-all)

(defn concat-elements [a-seq]
  (reduce (fn [a b] (loop [coll b
                           acc a]
                      (if (empty? coll)
                        acc
                        (recur (rest coll) (conj acc (first coll)))))) [] a-seq))

(defn str-cat [a-seq]
  (reduce str (concat-elements (interpose " " a-seq))))

(defn my-interpose [x a-seq]
  [:-])

(defn my-count [a-seq]
  :-)

(defn my-reverse [a-seq]
  [:-])

(defn min-max-element [a-seq]
  [:-])

(defn insert [sorted-seq n]
  [:-])

(defn insertion-sort [a-seq]
  [:-])

(defn parity [a-seq]
  [:-])

(defn minus [x]
  :-)

(defn count-params [x]
  :-)

(defn my-* [x]
  :-)

(defn pred-and [x]
  (fn [x] :-))

(defn my-map [f a-seq]
  [:-])