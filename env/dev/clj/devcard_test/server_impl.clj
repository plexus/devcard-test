(ns devcard-test.server-impl
  (:require [environ.core :refer [env]]
            [net.cgrand.enlive-html :refer [set-attr prepend append html]]
            [net.cgrand.reload :refer [auto-reload]]
            [figwheel-sidecar.repl-api :as figwheel]))

(def is-dev? (env :is-dev))

(def inject-devmode-html
  (comp
     (set-attr :class "is-dev")
     (prepend (html [:script {:type "text/javascript" :src "/js/out/goog/base.js"}]))
     (append  (html [:script {:type "text/javascript"} "goog.require('devcard_test.main')"]))))


(def browser-repl figwheel/cljs-repl)


(defn run []
  (auto-reload (find-ns 'devcard-test.server))
  (figwheel/start-figwheel!))
