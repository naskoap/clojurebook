(ns pucture-gallery.models.db
  (:require [clojure.java.jdbc :as sql]))

(def db 
  {:subprotocol "postgresql"
   :subname "//localhost/gallery"
   :user "admin"
   :password "admin"})

(defmacro with-db [f & body]
  `(sql/with-connection ~db (~f ~@body)))

(defn create-user [user]
  (with-db sql/insert-record :users user))

(defn get-user [id]
  (with-db sql/with-query-results
      res ["select * from users where id = ?" id] (first res)))

;;insert a record every time an image is uploaded
(defn add-image [userid name message]
  (with-db
    sql/transaction
    
    (if (sql/with-query-results
          res
          ["select userid from images where userid = ? and name = ? and description = ?" userid name message]
          (empty? res))
      (sql/insert-record :images {:userid userid :name name :description message})
      (throw
        (Exception. "You have already uploaded an image with the same name.")))))

(defn images-by-user [userid]
  (with-db
    sql/with-query-results
    res ["select * from images where userid = ?" userid] (doall res)))

 ;;pulls a single image for each user
(defn get-gallery-previews []
  (filter #(:name %)
  (with-db
    sql/with-query-results
    res
    ["select * from 
     (select *, row_number() over (partition by userid) as row_number from images)
     as rows where row_number = 1"]
    (doall res))))

;;deletes an image from the database
(defn delete-image [userid name]
  (with-db
    sql/delete-rows :images ["userid=? and name=?" userid name]))

(defn delete-user [userid]
  (with-db sql/delete-rows :users ["id=?" userid]))


