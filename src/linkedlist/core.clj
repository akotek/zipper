(ns linkedlist.core)

;; Simple implementation of a singly-linked-list
;; most operations are linear O(n), some are constant O(1)

(defrecord Node [v next])

;; creation
(defn new-node
  ([v] (Node. v nil)))

;; query
(defn first' [ls]
  (:v ls))

(defn rest' [ls]
  (:next ls))

(defn length [ls]
  (loop [ls ls
         acc 0]
    (if (nil? ls)
      acc
      (recur (rest' ls) (inc acc)))))

(defn contains?' [ls v]
  (cond
    (nil? ls) false
    (= (first' ls) v) true
    :else (recur (rest' ls) v)))

(defn get-nth [ls nth]
  (if (nil? ls)
    nil
    (if (= nth 0)
      (first' ls)
      (recur (rest' ls) (dec nth)))))

;; insertion
(defn cons' [e ls]
  (if (nil? ls)
    (new-node e)
    (Node. e ls)))

(defn prepend [e ls]
  (cons' e ls))

(defn append [ls e]
  (if (nil? ls)
    (new-node e)
    (cons' (first' ls) (append (rest' ls) e))))

(defn insert-after [old-v new-v ls]
  (cond
    (nil? ls) ls
    (= (first' ls) old-v) (cons' old-v (cons' new-v (rest' ls)))
    :else (cons' (first' ls) (insert-after old-v new-v (rest' ls)))))

;; deletion
(defn remove-head [ls]
  (rest' ls))

(defn remove [ls v]
  (cond
    (nil? ls) ls
    (= (first' ls) v) (rest' ls)
    :else (cons' (first' ls) (remove (rest' ls) v))))

;; iteration
(defn map' [f ls]
    (if (empty? ls)
      nil
      (cons' (f (first' ls)) (map' f (rest' ls)))))
;;end

;; NOTES ::
; 0. append is O(n), cons' O(1)
; 1. Improving 'length' to O(1) is possible with adding 'size' key to record,
; 2. Disadvantages of single-linked-list:
; inability to traverse from end to start
; most operations are O(n)
; unable to improve performance giving a node (insert-after(ls, n, v), remove(ls, n)) which is able with doubly
; doubly-linked-list becomes very difficult to implement
;;