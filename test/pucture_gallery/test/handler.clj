(ns pucture-gallery.test.handler
  (:use [clojure.test :refer :all]
        [ring.mock.request :refer :all]
        [noir.util.crypt :refer [encrypt]]
        [pucture-gallery.handler :refer :all]))

   (deftest test-app
     (testing "main route"
       (let [response (app (request :get "/"))]
         (is (= (:status response) 200))
         (is (.contains (:body response) "Hello World"))))

  (testing "not-found route"
    (let [response (app (request :get "/invalid"))]
      (is (= (:status response) 404)))))

   ;;returns a test user
   (defn mock-get-user [id]
     (if (= id "foo")
       {:id "foo" :pass (encrypt "12345")}))
   ;;unit tests for login portion
   (deftest test-login 
     (testing "login success"
        (with-redefs [pucture-gallery.models.db/get-user mock-get-user]
          (is
            (-> (request :post "/login" {:id "foo" :pass "12345"})
              app :headers (get "Set-Cookie") not-empty))))
     
     (testing "password mismatch"
        (with-redefs [pucture-gallery.models.db/get-user mock-get-user]
          (is 
            (-> (request :post "/login" {:id "foo" :pass "123456"})
              app :headers (get "Set-Cookie") empty?))))
     
     (testing "user not found"
        (with-redefs [pucture-gallery.models.db/get-user mock-get-user]
          (is 
            (-> (request :post "/login" {:id "bar" :pass "12345"})
              app :headers (get "Set-Cookie") empty?)))))
   
