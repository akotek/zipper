(ns linkedlist.core)

;TODO
; 1. finish implementation of single-linked-list
; 2. implement as a zipper
; 3. post in stackReview your versions


(defrecord LinkedList [head size])

(defrecord Node [v next])

(defn create []
  (LinkedList. nil 0))

(defn new-node
  ([v] (Node. v nil))
  ([v n] (Node. v n)))

(defn add [l v]
  (let [{:keys [h s], :or {h nil, s 0}} l
        node (new-node v h)]
    (LinkedList. node (inc s))))



(defn -main
  "I don't do a whole lot...yet."
  [& args]
  (println "Hello, World!"))