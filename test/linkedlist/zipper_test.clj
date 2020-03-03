(ns linkedlist.zipper-test
  (:require [clojure.test :refer :all]
            [linkedlist.zipper :refer :all]))

;; tests
(deftest test-build
  (testing "should build a zipper data-structure from a vector and a focus, 0 as default focus"
    (let [vec' [1 2 3 4 5]
          exp1 ['() 1 (rest vec')]
          exp2 ['(3 2 1) 4 '(5)]]
      (is (= (build vec') exp1))
      (is (= (build vec' (count vec')) nil))
      (is (= (build vec' 3) exp2)))))

(deftest test-traversal
  (testing "should move left/right from focus, nil if out-of-bounds")
  (let [z (build [1 2])
        expected ['(1) 2 '()]]
    (is (= (right z) expected))
    (is (= (right (right z)) nil))
    (is (= (left (right z)) z))
    (is (= (left z)) nil)))

(deftest test-insertion
  (testing "should insert element before/after focus"
    (let [z (build [1 2 3] 2)
          exp1 [1 2 3 4]
          exp2 [1 2 4 3]]
      (is (= (to-vec (insert-after z 4)) exp1))
      (is (= (to-vec (insert-after (left z) 4)) exp2))
      (is (= (to-vec (insert-before z 4))) exp2))))

(deftest test-remove
  (testing "should remove focus element if-exists from the zipper and move to the right"
    (let [z (build [1 2 3] 1)
          expected [1 3]]
      (is (= (to-vec (remove' z)) expected))
      (is (= (-> z (remove') (remove') (remove')) nil)))))
