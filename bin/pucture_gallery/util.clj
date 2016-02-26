(ns pucture-gallery.util
  (:require [noir.session :as session]
            [hiccup.util  :refer [url-encode]])
  (:import java.io.File))

   (def thumb-prefix "thumb_")

   ;;extract base path in order to be used when viewing galleries from others
   (def galleries "galleries")
   
   ;;generate a unique path in the galleries folder based on the user currently in session
   (defn gallery-path []
     (str galleries File/separator (session/get :user)))
   
   (defn image-uri [user-id file-name]
     (str "/img/" user-id "/" (url-encode file-name)))
   
   (defn thumb-uri [user-id file-name]
     (image-uri user-id (str thumb-prefix file-name)))

