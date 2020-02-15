(ns linkedlist.core)

;TODO
; 2. implement zipper
; 3. post in stackReview your versions

;; Simple implementation of a singly-linked-list
;; most operations are linear O(n), some are constant O(1)

(defrecord Node [v size next])

;; creation
(defn new-node
  ([v] (Node. v 1 nil)))

;; query
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
    :else (prepend (:v ls) (insert-after old-v new-v (:next ls)))))

;; deletion
(defn remove-head [ls]
  (:next ls))

(defn remove [ls v]
  (cond
    (nil? ls) ls
    (= (:v ls) v) (:next ls)
    :else (prepend (:v ls) (remove (:next ls) v))))
;;end

;;
;; Disadvantages of single-linked-list:
; inability to traverse from end to start
; most operations are O(n)
; unable to improve performance giving a node (insert-after(ls, n, v), remove(ls, n)) which is able with doubly
; doubly-linked-list becomes very difficult to implement
;;