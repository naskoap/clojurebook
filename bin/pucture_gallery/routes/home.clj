(ns pucture-gallery.routes.home
  (:require [compojure.core :refer :all]
            [pucture-gallery.views.layout :as layout]
            [noir.session :as session]
            [hiccup.page :refer [html5 include-css include-js]]
            [cheshire.core :as json]
            [clj-http.client :as client])
  (:use [clojure.string :only [join]]
        [environ.core]))

(defn forecast
  "Retrieve the forecast for a given latitude and longitude"
  [lat lon & {:keys [params time]}]
  (let [base-url "https://api.forecast.io/forecast"
        api-key (env :forecast-key)
        url (join "/" [base-url api-key (join "," (filter #(not-empty %) (map str [lat lon time])))])
        response (client/get url {:query-params params :throw-exceptions false})]
    (cond (= 200 (:status response))
          (json/parse-string (:body response) true))))

(forecast "35.2011" "-85.9214")

(defn home []
  (cond 
    (session/get :user)
    (layout/common [:h1 "Welcome to Clojurebook, " (str (session/get :user) "!")])
    :else
    (layout/common 
      (list
        [:h1 "Welcome to Clojurebook!"]
        [:h2#home "Registration is free! And always will be."]))))

(defroutes home-routes
  (GET "/" [] (home)))
