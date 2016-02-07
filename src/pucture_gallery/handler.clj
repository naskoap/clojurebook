(ns pucture-gallery.handler
  (:require [compojure.route :as route]
            [compojure.core :refer [defroutes]]
            [noir.util.middleware :as noir-middleware]
            [pucture-gallery.routes.auth :refer [auth-routes]]
            [pucture-gallery.routes.home :refer [home-routes]]))

(defn init []
  (println "pucture-gallery is starting"))

(defn destroy []
  (println "pucture-gallery is shutting down"))

(defroutes app-routes
  (route/resources "/")
  (route/not-found "Not Found"))

(def app (noir-middleware/app-handler 
           [auth-routes
            home-routes
            app-routes]))
