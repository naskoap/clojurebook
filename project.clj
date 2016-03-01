(defproject pucture-gallery "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.1.5"]
                 [hiccup "1.0.4"]
                 [ring-server "0.3.1"]
                 [postgresql/postgresql "9.1-901.jdbc4"]
                 [org.clojure/java.jdbc "0.2.3"]
                 [lib-noir "0.8.2"]
                 [com.taoensso/timbre "2.6.1"]
                 [com.postspectacular/rotor "0.1.0"]]
                 ;;[environ "0.4.0"]
  :main pucture-gallery.core
  :plugins [[lein-ring "0.8.12"]
            [lein-environ "0.4.0"]]
  :ring {:handler pucture-gallery.handler/app
         :init pucture-gallery.handler/init
         :destroy pucture-gallery.handler/destroy}
  :profiles
  {:uberjar {:aot :all}
   :production
   {:ring
    {:open-browser? false, 
     :stacktraces? false, 
     :auto-reload? false}}
     ;;:env {:port 3000
     ;;      :db-url "//localhost/login"
     ;;      :db-user "admin"
     ;;      :db-pass "admin"
     ;;      :galleries-path "galleries"}
    :dev
   {:dependencies [[ring-mock "0.1.5"]
                   [ring/ring-devel "1.2.0"]]}})
    ;;:env {:port 3000
    ;;      :db-url "//localhost/gallery"
    ;;      :db-user "admin"
    ;;      :db-pass "secretProdPassword"
    ;;      :galleries-path "galleries"}
