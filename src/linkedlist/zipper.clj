(ns linkedlist.zipper)

;TODO
; 2. implement zipper
; 3. post in stackReview your versions

(defn build
  ([data]
   (build data nil))
  ([data idx]
   (if (nil? idx)
     data
     (when (< -1 idx (count data))
       [(reverse (take idx data)) (get data idx) (nthnext data (inc idx))]))))

(defn right [loc])

(defn left [loc])

(defn insert-after [loc elem])

(defn insert-before [loc elem])

(defn remove [z]
  (let [[before loc after] z]
    (if-not (and (seq? before) (some? loc) (seq? after))
      z
      [before (first after) (rest after)])))

;;
; Moving to neighbours in O(1) time