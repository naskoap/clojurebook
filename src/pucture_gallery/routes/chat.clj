(ns pucture-gallery.routes.chat
  (:require [compojure.core :refer :all]
            [pucture-gallery.views.layout :as layout]
            [noir.session :as session]
            [hiccup.page :refer [html5]]
            [noir.util.route :refer [restricted]]))

(defn in-dev []
  (layout/common 
    [:h2#chat "Hang in there, " (str (session/get :user) "!") [:hr] "The chat room will be available soon." ]))
    

(defroutes chat-routes
  (GET "/chat" [] (restricted (in-dev))))