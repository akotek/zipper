(ns linkedlist.zipper-test
  (:require [clojure.test :refer :all]
            [linkedlist.zipper :refer :all]))

;; tests
(deftest test-build
  (testing "should build a zipper data-structure from a vector and a focus"
    (let [vec' [1 2 3 4 5]
          expected [(2 1) 3 (4)]]
      (is (= (build vec' nil) vec'))
      (is (= (build vec' 3) expected)))))
