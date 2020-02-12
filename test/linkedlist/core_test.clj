(ns linkedlist.core-test
  (:require [clojure.test :refer :all]
            [linkedlist.core :refer :all])
  (:use linkedlist.core))


;; utils
; ====================================
(defn get-last [n]
  (if (nil? (:next n))
    n
    (get-last (:next n))))

(defn to-vec-helper [n v]
  (if (nil? n)
    v
    (to-vec-helper (:next n) (conj v (:v n)))))

(defn to-vec [n]
  (to-vec-helper n []))

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
    (let [lst (append (append nil 1) 2)]
      (is (= (containz? lst 2) true))
      (is (= (containz? lst 3)) false))))