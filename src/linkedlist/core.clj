(ns linkedlist.core)

;TODO
; 1. finish implementation of single-linked-list API as same as HASKELL API
; 2. implement as a zipper
; 3. post in stackReview your versions

(defrecord Node [v size next])

;; creation
(defn new-node
  ([v] (Node. v 1 nil)))
seq
;; query
(defn length [n]
  (if (nil? n) 0 (:size n)))

(defn empt? [n]
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

;; insertion
(defn prepend [e n]
  (if (nil? n)
    (new-node e)
    (Node. e (inc (:size n)) n)))

(defn append [n e]
  (if (nil? n)
    (new-node e)
    (prepend (:v n) (append (:next n) e))))

(defn insert-after [new old n]
  (cond
    (nil? n) n
    (= (:v (:next n)) (:v old)) (append n (prepend (:next n) new))
    :else (prepend (:v n) (insert-after new old (:next n)))))

(defn insert-after [new old ls]
  (cond (empty? ls) ls
        (= (first ls) old) (cons old (cons new (rest ls)))
        :else (cons (first ls) (insert-after new old (rest ls)))))
;; deletion
(defn delete [n v])

;;end

(defn -main
  "I don't do a whole lot...yet."
  [& args]
  (println "Hello, World!"))