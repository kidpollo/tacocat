(ns tacocat.core
  (:require [cljs.nodejs :as nodejs]))

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
          #(.send % (str "You said: " (.. % -message -text)))))
 
; define server
(def server (.createServer restify))
(do
  (.post server "/api/messages" (.listen connector)))

(defn main [& args]
  (.listen server 3978 (println " localhost listening port 3978" )))

(set! *main-cli-fn* main)

