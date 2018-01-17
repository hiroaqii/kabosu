(ns kabosu.core-test
  (:require [clojure.test :refer :all]
            [kabosu.core :refer :all]))

(deftest test-tokenize
  (is (= (map first (tokenize "医薬品安全管理責任者")) ["医薬品安全管理責任者"]))
  (is (= (map first (tokenize "医薬品安全管理責任者" :mode "A")) ["医薬" "品" "安全" "管理" "責任" "者"]))
  (is (= (map first (tokenize "医薬品安全管理責任者" :mode "B")) ["医薬品" "安全" "管理" "責任者"]))
  (is (= (map first (tokenize "医薬品安全管理責任者" :mode "C")) ["医薬品安全管理責任者"])))
