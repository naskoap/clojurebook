(ns pucture-gallery.handler
  (:require [compojure.route :as route]
            [compojure.core :refer [defroutes]]
            [noir.util.middleware :as noir-middleware]
            [pucture-gallery.routes.auth :refer [auth-routes]]
            [pucture-gallery.routes.home :refer [home-routes]]
            [pucture-gallery.routes.upload :refer [upload-routes]]
            [pucture-gallery.routes.gallery :refer [gallery-routes]]
            [pucture-gallery.routes.chat :refer [chat-routes]]
            [noir.session :as session]
            [taoensso.timbre :as timbre]
            [com.postspectacular.rotor :as rotor]))

(defn info-appender [{:keys [level message]}]
  (println "level:" level "message:" message))

(defn init []
  (timbre/set-config! 
    ;;[:timestamp-pattern] "yyyy-MM-dd HH:mm:ss"
    [:appenders :rotor]
    {:min-level :info
     :enabled? true
     :asynch? false ; should always be false for rotor
     :max-message-per-msecs nil
     :fn rotor/append})
  
  ;;configuration for the rotor appender
  ;;(set-config!
  ;;  [:shared-appender-config :rotor]
  ;;  {:path "/var/log/error.log" :max-size (* 512 1024) :backlog 10})
  
  (timbre/set-config!
    [:shared-appender-config :rotor]
    {:path "error.log" :max-size (* 512 1024) :backlog 10})
  
  (timbre/info "pucture-gallery started successfully"))

(defn destroy []
  (timbre/info "pucture-gallery is shutting down"))

(defroutes app-routes
  (route/resources "/")
  (route/not-found "Not Found"))

;;checks whether a user is present in the session before granting access to restricted pages
(defn user-page [_]
  (session/get :user))

(def app (noir-middleware/app-handler 
           [auth-routes
            home-routes
            upload-routes
            gallery-routes
            chat-routes
            app-routes]
           ;;applies rules to restricted pages
           :access-rules [user-page]))
