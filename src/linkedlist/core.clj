(ns linkedlist.core)

;TODO
; 1. finish implementation of single-linked-list API as same as HASKELL API
; 2. implement as a zipper
; 3. post in stackReview your versions

(defrecord Node [v size next])

;; creation
(defn new-node
  ([v] (Node. v 1 nil)))

;; insertion
(defn prepend [n v]
  (if (nil? n)
    (new-node v)
    (Node. v (inc (:size n)) n)))

(defn append [n v]
  (if (nil? n)
    (new-node v)
    (prepend
      (append (:next n) v) (:v n))))

(defn insert-before [n v])

(defn insert-after [n v])

;; deletion
(defn delete [n v])

;; query
(defn length [n]
  (if (nil? n) 0 (:size n)))

(defn empty-list? [n]
  (or (nil? n) (> (:size n) 0)))

(defn containz? [n v]
  (cond
    (nil? n) false
    (= (:v n) v) true
    :else (recur (:next n) v)))

(defn get-nth [n nth]
  (if (nil? n)
    nil
    (if (= nth 0)
      (:v n)
      (recur (:next n) (dec nth)))))

;;end

(defn -main
  "I don't do a whole lot...yet."
  [& args]
  (println "Hello, World!"))