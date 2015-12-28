(ns devcard-test.core
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true])
  (:require-macros [devcards.core :refer [defcard]]))

(enable-console-print!)

(def app-state (atom {:text "Hello !"}))

(defn main []
  (om/root
    (fn [app owner]
      (reify
        om/IRender
        (render [_]
          (dom/h1 nil (:text app)))))
    app-state
    {:target (. js/document (getElementById "app"))}))

(defcard my-first-card
  (dom/h1 nil "My amazing card!"))

(defcard another-card
  "Hello world")
