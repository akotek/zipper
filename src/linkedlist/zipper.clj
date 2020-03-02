(ns linkedlist.zipper)

;TODO
; 1. removeEdgECases
; 2. implement zipper
; 3. analyze runtime
; 3. post in stackReview your versions

;; creation
(defn build
  ([data]
   (build data nil))
  ([data idx]
   (if (nil? idx)
     (build data 0)
     (when (< -1 idx (count data))
       [(reverse (take idx data)) (get data idx) (drop (inc idx) data)]))))

(defn to-vec [[before loc after]]
  (vec (concat (reverse before) [loc] after)))

;; traversal
(defn right [[before loc after]]
  [(cons loc before) (first after) (rest after)])

(defn left [[before loc after]]
  [(rest before) (first before) (cons loc after)])

;; insertion/deletion
(defn insert-after [[before loc after] elem]
  [before loc (cons elem after)])

(defn insert-before [[before loc after] elem]
  [(cons elem before) loc after])

(defn remove [[before loc after]]
  [before (first after) (rest after)])

;;
; Moving to neighbours in O(1) time