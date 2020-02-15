(ns linkedlist.core)

;TODO
; 1. finish implementation of single-linked-list API as same as HASKELL API
; 1.1. add runtime of implementation
; 2. implement as a zipper
; 3. post in stackReview your versions

(defrecord Node [v size next])

;; creation
(defn new-node
  ([v] (Node. v 1 nil)))

;; query
(defn length [ls]
  (if (nil? ls) 0 (:size ls)))

(defn empt? [ls]
  (or (nil? ls) (> (:size ls) 0)))

(defn containz? [ls v]
  (cond
    (nil? ls) false
    (= (:v ls) v) true
    :else (recur (:next ls) v)))

(defn get-nth [ls nth]
  (if (nil? ls)
    nil
    (if (= nth 0)
      (:v ls)
      (recur (:next ls) (dec nth)))))

;; insertion
(defn prepend [e ls]
  (if (nil? ls)
    (new-node e)
    (Node. e (inc (:size ls)) ls)))

(defn append [ls e]
  (if (nil? ls)
    (new-node e)
    (prepend (:v ls) (append (:next ls) e))))

(defn insert-after [old-v new-v ls]
  (cond
    (nil? ls) ls
    (= (:v ls) old-v) (prepend old-v (prepend new-v (:next ls)))
    :else (prepend (:v ls) (recur old-v new-v (:next ls)))))

;; deletion
(defn remove-head [ls]
  (:next ls))

(defn remove-node [ls v])

;;end

(defn -main
  "I don't do a whole lot...yet."
  [& args]
  (println "Hello, World!"))