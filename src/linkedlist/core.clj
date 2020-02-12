(ns linkedlist.core)

;TODO
; 1. finish implementation of single-linked-list API as same as HASKELL API
; 2. implement as a zipper
; 3. post in stackReview your versions

(defrecord Node [v size next])

(defn new-node
  ([v] (Node. v 1 nil)))

(defn prepend [n v]
  (if (nil? n)
    (new-node v)
    (Node. v (inc (:size n)) n)))

(defn append [n v]
  (if (nil? n)
    (new-node v)
    (prepend (append (:next n) v) (:v n))))

(defn containz? [n v]
  (cond
    (nil? n) false
    (= (:v n) v) true
    :else (containz? (:next n) v)))

(defn -main
  "I don't do a whole lot...yet."
  [& args]
  (println "Hello, World!"))