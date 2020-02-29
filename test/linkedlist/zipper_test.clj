(ns linkedlist.zipper-test
  (:require [clojure.test :refer :all]
            [linkedlist.zipper :refer :all]))

;; tests
(deftest test-build
  (testing "should build a zipper data-structure from a vector and a focus"
    (let [vec' [1 2 3 4 5]
          expected ['(3 2 1) 4 '(5)]]
      (is (= (build vec') vec'))
      (is (= (build vec' (count vec')) nil))
      (is (= (build vec' 3) expected)))))

(deftest test-remove
  (testing "should remove focus element if-exists from the zipper and move to the right"
    (let [vec' [1 2 3 4 5]
          z (build vec' 3)
          expected ['(3 2 1) 5 '()]]
      (is (= (remove vec')) vec')
      (is (= (remove z) expected)))))
