(ns devcard-test.test-runner
  (:require
   [cljs.test :refer-macros [run-tests]]
   [devcard-test.core-test]))

(enable-console-print!)

(defn runner []
  (if (cljs.test/successful?
       (run-tests
        'devcard-test.core-test))
    0
    1))
