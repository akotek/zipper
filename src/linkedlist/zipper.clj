(ns linkedlist.zipper)

;TODO
; 1. finish implement for linkedlist use case
; 2. analyze runtime
; 3. post in stackReview your versions
; 4. implement general case for zipper

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
  (when (not-empty after)
    [(cons loc before) (first after) (rest after)]))

(defn left [[before loc after]]
  (when-not (empty? before)
    [(rest before) (first before) (cons loc after)]))

;; insertion/deletion
(defn insert-after [[before loc after] elem]
  (when loc
    [before loc (cons elem after)]))

(defn insert-before [[before loc after] elem]
   (when loc
     [(cons elem before) loc after]))

(defn remove' [[before loc after]]
  (when (and loc (some? (first after)))
    [before (first after) (rest after)]))

;;
; Moving to neighbours in O(1) time