(ns linkedlist.core-test
  (:require [clojure.test :refer :all]
            [linkedlist.core :refer :all]))

;; utils
; ====================================
(defn to-vec [ls]
  (loop [acc []
         lst ls]
    (if (nil? lst)
      acc
      (recur (conj acc (first' lst)) (rest' lst)))))

(defn to-linked [ls]
  (reduce (fn [n v] (append n v)) nil ls))
; ====================================

;; tests
(deftest test-prepend
  (testing "should add e to start of list ls"
    (let [lst (prepend 3 (prepend 2 (prepend 1 nil)))
          expected [3 2 1]]
      (is (= (to-vec lst) expected)))))

(deftest test-append
  (testing "should add to end of ls the element e"
    (let [lst (append (append (append nil 1) 2) 3)
          expected [1 2 3]]
      (is (= (to-vec lst) expected)))))

(deftest test-length
  (testing "should return length of list"
    (is (= (length (to-linked [1])) 1))
    (is (= (length (to-linked [1 2 3])) 3))))

(deftest test-containz?
  (testing "should return true if value exists"
    (let [lst (to-linked [1 2])]
      (is (= (contains?' lst 2) true))
      (is (= (contains?' lst 3)) false))))

(deftest test-get-nth
  (testing "should return the nth element of the list"
    (let [items [1 2 3]
          lst (to-linked items)]
      (doseq [[i v] (map-indexed vector items)]
        (is (= (get-nth lst i) v))))))

(deftest test-insert-after
  (testing "should insert after old-v the new-v on list ls"
    (let [lst (to-linked [1 2 3])
          exp1 [1 4 2 3]
          exp2 [1 2 3 4]
          exp3 [1 2 4 3]]
      (is (= (to-vec (insert-after 1 4 lst)) exp1))
      (is (= (to-vec (insert-after 3 4 lst)) exp2))
      (is (= (to-vec (insert-after 2 4 lst)) exp3)))))

(deftest test-removal
  (testing "should remove head node and value after giving node"
    (let [lst (to-linked [1 2 3])
          exp1 [2 3]
          exp2 [1 3]
          exp3 [1 2]]
      (is (= (to-vec (remove-head lst)) exp1))
      (is (= (to-vec (remove lst 1)) exp1))
      (is (= (to-vec (remove lst 2)) exp2))
      (is (= (to-vec (remove lst 3))) exp3))))

(deftest test-map
  (testing "should map on the linked list"
    (let [lst (to-linked [1 2 3])
          expected (to-linked [2 3 4])]
      (is (= (map' inc lst) expected)))))