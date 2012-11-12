(ns royale.layout
  (:use [hiccup.page :only [html5 include-css]]))

(defn dashboard [title & body]
  (html5
   [:head
    [:title title]
    [:meta {:charset "utf-8"}]
    (include-css "/css/bootstrap.min.css"
                 "/css/royale.css")]
   [:body
    [:div {:class "container"}
     body]]))
