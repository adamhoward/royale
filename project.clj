(defproject royale "0.0.1-SNAPSHOT"
  :description "Experimental dashboard in Clojure"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [org.clojure/math.numeric-tower "0.0.1"]
                 [ring/ring-core "1.1.6"]
                 [ring/ring-devel "1.1.6"]
                 [ring/ring-jetty-adapter "1.1.6"]
                 [compojure "1.1.3"]
                 [hiccup "1.0.1"]
                 [org.clojure/java.jmx "0.2.0"]
                 [clj-stacktrace "0.2.5"]]
  :min-lein-version "2.0.0"
  :main royale-demo.run)
