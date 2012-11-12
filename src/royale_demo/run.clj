(ns royale-demo.run
  (:require [ring.adapter.jetty :as ring]
            [royale-demo.web :as royale]))

(defn start [port]
  (ring/run-jetty #'royale/web-app {:port (or port 8000) :join? false}))

(defn -main
  ([port]
     (start port))
  ([] (start 8000)))
