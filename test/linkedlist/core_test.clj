(ns linkedlist.core-test
  (:require [clojure.test :refer :all]
            [linkedlist.core :refer :all])
  (:use linkedlist.core))


;; utils
(defn head-v [l]
  (-> l
      (:head)
      (:v)))

;; tests
(deftest test-create
  (testing "creation of an empty list"
    (let [l (create)]
      (is (= (:head l) nil))
      (is (= (:size l) 0)))))

(deftest test-add
  (testing "adds value to front of list"
    (let [l1 (add (create) 1)
          l2 (add l1 2)]
      (is (= (head-v l1)) 1)
      (is (= (head-v l2) 2)))))
