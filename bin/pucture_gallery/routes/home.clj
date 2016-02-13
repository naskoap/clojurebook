(ns pucture-gallery.routes.home
  (:require [compojure.core :refer :all]
            [pucture-gallery.views.layout :as layout]
            [noir.session :as session]
            [pucture-gallery.routes.gallery :refer [show-galleries]]))

(defn home []
  (cond 
    (session/get :user)
    ;;(layout/common [:h1 "Welcome to Clojurebook, " (str (session/get :user) "!")])
    (layout/common (show-galleries))
    :else
    (layout/common [:h1 "Welcome to Clojurebook!"])))

(defroutes home-routes
  (GET "/" [] (home)))
