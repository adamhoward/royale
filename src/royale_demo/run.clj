(ns royale-demo.run
  (:require [ring.adapter.jetty :as ring]
            [royale-demo.web :as royale]))

(defn start [port]
  (ring/run-jetty #'royale/web-app {:port port :join? false}))

(defn -main
  ([port]
     (start (Integer/parseInt port)))
  ([] (start (Integer/parseInt (or (System/getenv "PORT") "8000")))))
