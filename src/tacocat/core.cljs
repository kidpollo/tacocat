(ns tacocat.core
  (:require [cljs.nodejs :as nodejs]
            [clojure.string :as string]))

(nodejs/enable-util-print!)

; node includes
(def restify (nodejs/require "restify"))
(def builder (nodejs/require "botbuilder"))

(def connector (builder.ChatConnector.
                (clj->js
                 {:appId (.. nodejs/process -env -MICROSOFT_APP_ID)
                  :appPassword (.. nodejs/process -env -MICROSOFT_APP_PASSWORD)})))


(def bot (builder.UniversalBot.
          connector
          #(.send % (str "You said: " (string/reverse (.. % -message -text))))))
 
; define server
(def server (.createServer restify))
(do
  (.post server "/api/messages" (.listen connector)))

(defn main [& args]
  (let [port (or (.-PORT (.-env js/process)) 3978)] 
    (.listen server port (println (str "localhost listening port:" port) ))))

(set! *main-cli-fn* main)

