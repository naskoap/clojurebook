(ns pucture-gallery.routes.gallery
  (:require [compojure.core :refer :all]
            [hiccup.element :refer :all]
            [hiccup.page :refer :all]
            [hiccup.form :refer [check-box]]
            
            [pucture-gallery.views.layout :as layout]
            [pucture-gallery.util :refer [thumb-prefix image-uri thumb-uri]]
            
            [pucture-gallery.models.db :as db]
            [noir.session :as session]
            [noir.util.route :refer [restricted]]))

;;generates a div with our thumbnail link and add a thumbnail class to it
(defn thumbnail-link [{:keys [userid name]}]
  [:div.thumbnail
   [:a {:class name :href (image-uri userid name)}
    (image (thumb-uri userid name))]
    (if (= userid (session/get :user))
      (check-box name))])

;;reads the images for the user in the session and converts them to thumbnails by mapping
;;thumbnail-link accross them
(defn display-gallery [userid]
  (if-let [gallery (not-empty (map thumbnail-link (db/images-by-user userid)))]
    [:div
     [:div#error]
     gallery
     (if (= userid (session/get :user))
       [:input#delete {:type "submit" :value "delete images"}])]
    [:p "The user " userid " does not have any galleries."]))

;;(defn format-time [timestamp]
;;  (-> "MM/dd/yyyy"
;;    (java.text.SimpleDateFormat.)
;;    (.format timestamp)))

;;generate gallery links
(defn gallery-link [{:keys [userid name]}]
  [:div.thumbnail
    [:a {:href (str "/gallery/" userid)}
     (if (= userid (session/get :user))
       (list (str "my gallery")
             [:br])
       (list (str userid "'s gallery")
             [:br]))
     (image (thumb-uri userid name))]])

(defn show-galleries []
  (map gallery-link (db/get-gallery-previews)))

(defroutes gallery-routes
  (GET "/gallery" []
      (restricted (layout/common (show-galleries))))
  ;;display the gallery for a given userID
  (GET "/gallery/:userid" [userid] 
       ;;restrict access for non-logged-in users
       (restricted 
        (layout/common 
          (include-js "/js/gallery.js")
          (display-gallery userid)))))


