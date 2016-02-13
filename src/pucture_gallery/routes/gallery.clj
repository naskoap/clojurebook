(ns pucture-gallery.routes.gallery
  (:require [compojure.core :refer :all]
            [hiccup.element :refer :all]
            
            [pucture-gallery.views.layout :as layout]
            [pucture-gallery.util :refer [thumb-prefix image-uri thumb-uri]]
            
            [pucture-gallery.models.db :as db]
            [noir.session :as session]
            [noir.util.route :refer [restricted]]))

;;generates a div with our thumbnail link and add a thumbnail class to it
(defn thumbnail-link [{:keys [userid name]}]
  [:div.thumbnail
   [:a {:href (image-uri userid name)}
    (image (thumb-uri userid name))]])

;;reads the images for the user in the session and converts them to thumbnails by mapping
;;thumbnail-link accross them
(defn display-gallery [userid]
  (or 
    (not-empty (map thumbnail-link (db/images-by-user userid)))
    [:p "The user " userid " does not have any galleries."]))

;;generate gallery links
(defn gallery-link [{:keys [userid name]}]
  [:div.thumbnail
    [:a {:href (str "/gallery/" userid)}
     userid "'s gallery" [:br]
     (image (thumb-uri userid name))]])

(defn show-galleries []
  (map gallery-link (db/get-gallery-previews)))

(defroutes gallery-routes
  ;;display the gallery for a given userID
  (GET "/gallery/:userid" [userid] (restricted (layout/common (display-gallery userid)))))


