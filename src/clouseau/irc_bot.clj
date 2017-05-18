;
;  (C) Copyright 2017  Pavel Tisnovsky
;
;  All rights reserved. This program and the accompanying materials
;  are made available under the terms of the Eclipse Public License v1.0
;  which accompanies this distribution, and is available at
;  http://www.eclipse.org/legal/epl-v10.html
;
;  Contributors:
;      Pavel Tisnovsky
;

(ns clouseau.irc-bot)

(require '[irclj.core :as irc])

(require '[clouseau.core         :as core])
(require '[clouseau.dyncfg       :as dyncfg])
(require '[clouseau.db-interface :as db-interface])

(defn message-to-channel?
    [message]
    (.startsWith (:target message) "#"))

(defn message-for-me?
    [my-name message]
    (or (.startsWith (:target message) my-name)        ; private message
        (.startsWith (:text message) (str my-name ":")); direct message
        (.startsWith (:text message) (str my-name ",")))); direct message

(defn create-reply
    [incoming-message]
    (if (message-to-channel? incoming-message)
        incoming-message
        (assoc incoming-message :target (:nick incoming-message))))

(defn package-status
    []
    (str "Number of packages with description: " (db-interface/read-ccs-description-count)))

(defn package-found?
    [input]
    (seq (db-interface/read-first-ccs-description input)))

(defn return-package-description
    [input]
    (db-interface/read-first-ccs-description input))

(defn prepare-reply-text
    [incomming-message nick input-text]
    (try
    (let [in-channel? (message-to-channel? incomming-message)
          input       (if in-channel?
                          (subs input-text (+ 2 (count @dyncfg/bot-nick)))
                          input-text)
          prefix      (if in-channel? (str nick ": "))
          response    (condp = input
                          "help"     "clouseau: package name | status | help"
                          "status"   (package-status)
                          "die"      "thanks for your feedback, I appreciate it"
                          "Good bot" "I know"
                          "Good bot." "I know"
                          "rainbow"   (apply str (for [color (range 16)]
                                                     (str (char 3) (format "%02d" color) (format "test%02d " color) (char 3) "99")))
                          (cond
                              (package-found? input) (return-package-description input)
                              :else                  "Command not understood or package not found"))]
        {:prefix prefix
         :response response})
        (catch Exception e
            (println (.getMessage e))
            {:prefix ""
             :response ""})))

(defn on-incoming-message
    [connection incoming-message]
    (let [{text    :text
           target  :target
           nick    :nick
           host    :host
           command :command} incoming-message]
           (println "Received message from" nick "to" target ":" text "(" host command ")")
           (println incoming-message)
           (if (message-for-me? @dyncfg/bot-nick incoming-message)
               (let [reply  (create-reply incoming-message)
                     output (prepare-reply-text incoming-message nick text)]
                     (irc/reply connection reply
                         (str (:prefix output) (:response output)))))))

(defn send-message
    [recipients target message-text]
    (let [message {:target target :command "PRIVMSG"}]
        (irc/reply @dyncfg/connection message (str recipients " " message-text))))

(defn start-irc-bot
    [configuration]
    (println configuration)
    (let [server   (:name configuration)
          port     (:port configuration)
          channels (:channels configuration)
          chanlist (clojure.string/split channels #" ")
          nick     (:nick configuration)]
        (let [conn (irc/connect server port nick
                                :callbacks {:privmsg on-incoming-message})]
            (println "Connected, joining to channels" channels)
            (reset! dyncfg/connection conn)
            (reset! dyncfg/bot-nick nick)
            (doseq [channel chanlist]
                (println channel)
                (irc/join @dyncfg/connection (clojure.string/trim channel)))
            (println "Connected..."))))

