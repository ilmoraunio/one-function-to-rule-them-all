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
  (reduce #(if (empty? %1)
            (conj %1 %2)
            (conj %1 x %2))
    [] a-seq))

(defn my-count [a-seq]
  (reduce (fn [a _] (inc a)) 0 a-seq))

(defn my-reverse [a-seq]
  (reduce #(conj %1 %2) () a-seq))

(defn min-max-element [a-seq]
  (reduce (fn [[min max :as a] b]
            (if (empty? a)
              [b b]
              (let [min (if (< b min) b min)
                    max (if (> b max) b max)]
                [min max]))) () a-seq))

(defn insert [sorted-seq n]
  (concat (take-while #(< % n) sorted-seq)
          (list n)
          (drop-while #(> n %) sorted-seq)))

(defn insertion-sort [a-seq]
  (reduce #(insert %1 %2) () a-seq))

(defn parity [a-seq]
  (reduce #(if (contains? %1 %2)
            (disj %1 %2)
            (conj %1 %2)) #{} a-seq))

(defn minus
  ([x] (* -1 x))
  ([x y] (- x y)))

(defn count-params [& more]
  (count more))

(defn my-*
  ([] 1)
  ([x] x)
  ([x y & more] (reduce * (* x y) more)))

(defn pred-and
  ([] (fn [x] true))
  ([p?] p?)
  ([p1? p2?] (fn [x] (and (p1? x) (p2? x))))
  ([p1? p2? & preds] (fn [x]
                       (reduce (fn [a b] (and a (b x))) (and (p1? x) (p2? x)) preds))))

(defn my-map
  ([f a-seq] (reduce (fn [a b] (concat a [(f b)])) () a-seq))
  ([f a-seq & a-seqs] (loop [colls (concat (list a-seq) a-seqs)
                             acc (empty a-seqs)]
                        (if (every? (complement nil?)
                                    (map (partial not-empty) colls))
                          (recur (my-map rest colls)
                                 (concat acc [(apply f (my-map first colls))]))
                          acc))))
