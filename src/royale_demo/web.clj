(ns royale-demo.web
  (:use [royale.middleware]
        [compojure.core :only [defroutes GET]]
        [ring.middleware.reload :only [wrap-reload]]
        [ring.middleware.stacktrace :only [wrap-stacktrace]])
  (:require [compojure.route :as route]
            [royale.layout :as layout]
            [royale.widgets :as royale]
            [royale-demo.data :as data]
            [royale-demo.widgets :as demo]))

(def production?
  (= "production" (get (System/getenv) "APP_ENV")))

(def development?
  (not production?))

(defroutes handler
  (GET "/" []
       (layout/dashboard "ROYALE"
                         (list
                          [:div {:class "row"}
                           (royale/dashboard-widget {:sales "$48" :items 12} "Past Hour" 3)
                           (demo/custom-memory-widget (with-meta (data/my-memory) {:subtitle "Local" :link "http://www.google.com"}) "Heap")
                           (royale/dashboard-widget (data/my-classes-loaded) "Classes Loaded")]
                          (royale/table-widget (data/my-generations) "Generations"))))
  (route/resources "/"))

(def web-app
  (-> #'handler
      (wrap-request-logging)
      (wrap-if development? wrap-reload '[royale.layout royale.widgets royale-demo.web royale-demo.widgets royale-demo.data])
      (wrap-exception-logging)
      (wrap-if production? wrap-failsafe)
      (wrap-if development? wrap-stacktrace)))
