(ns pucture-gallery.routes.chat
  (:require [compojure.core :refer :all]
            [pucture-gallery.views.layout :as layout]
            [noir.util.route :refer [restricted]]
            [noir.session :as session]
            [compojure.route :as route]))

(defn in-dev []
  (layout/common 
    [:h2#chat "Hang in there, " (str (session/get :user) "!") [:hr] "The chat room will be available soon." ]))

(defroutes chat-routes
  (GET "/chat" [] (restricted (in-dev))))



