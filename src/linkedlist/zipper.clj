(ns linkedlist.zipper)

;TODO
; 2. implement zipper
; 3. post in stackReview your versions

(defn build
  ([data]
   (build data nil))
  ([data focus]
  (if (nil? focus)
    data
    (let [idx (.indexOf data focus)]
      [(reverse (take idx data)) focus (nthnext data (inc idx))]))))

(defn right [loc])

(defn left [loc])

(defn insert-after [loc elem])

(defn insert-before [loc elem])

(defn remove [loc])

