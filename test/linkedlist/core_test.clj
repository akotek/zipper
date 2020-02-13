(ns linkedlist.core-test
  (:require [clojure.test :refer :all]
            [linkedlist.core :refer :all])
  (:use linkedlist.core))


;; utils
; ====================================
(defn to-vec [n]
  (loop [acc []
         n n]
    (if (nil? n)
      acc
      (recur (conj acc (:v n)) (:next n)))))

(defn to-linked [lst]
  (reduce (fn [n v] (append n v)) nil lst))
; ====================================

;; tests
(deftest test-prepend
  (testing "should add in start of list"
    (let [lst (prepend (prepend (prepend nil 1) 2) 3)
          expected [3 2 1]]
      (is (= (to-vec lst) expected)))))

(deftest test-append
  (testing "should add to end of list"
    (let [lst (append (append (append nil 1) 2) 3)
          expected [1 2 3]]
      (is (= (to-vec lst) expected)))))

(deftest test-containz?
  (testing "should return true if value exists"
    (let [lst (to-linked [1 2])]
      (is (= (containz? lst 2) true))
      (is (= (containz? lst 3)) false))))

(deftest test-get-nth
  (testing "should return the nth element of the list"
    (let [items [1 2 3]
          lst (to-linked items)]
      (doseq [[i v] (map-indexed vector items)]
        (is (= (get-nth lst i) v))))))