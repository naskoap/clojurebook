(ns pucture-gallery.routes.home
  (:require [compojure.core :refer :all]
            [pucture-gallery.views.layout :as layout]
            [noir.session :as session]
            [hiccup.page :refer [html5 include-css include-js]]))

(defn home []
  (cond 
    (session/get :user)
    (layout/common [:h1 "Welcome to Clojurebook, " (str (session/get :user) "!")])
    :else
    (layout/common [:h1 "Welcome to Clojurebook!"])))

(defroutes home-routes
  (GET "/" [] (home)))
