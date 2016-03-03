(ns pucture-gallery.routes.home
  (:require [compojure.core :refer :all]
            [pucture-gallery.views.layout :as layout]
            [noir.session :as session]
            [hiccup.page :refer [html5 include-css include-js]]))

(defn home []
  (cond 
    (session/get :user)
    (layout/common 
      (list
        [:h1 "Welcome to Clojurebook, " (str (session/get :user) "!")]
        [:h2#home "This page will be populated soon, no worries ;)"]))
    :else
    (layout/common 
      (list
        [:h1 "Welcome to Clojurebook!"]
        [:h2#home "Registration is free! And always will be."]))))

(defroutes home-routes
  (GET "/" [] (home)))
