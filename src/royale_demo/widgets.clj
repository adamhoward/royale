(ns royale-demo.widgets)

(defn custom-memory-widget [data & title]
  (let [used (:used data)
        total (:total data)
        max (:max data)]
    [:div {:class "span5 widget"}
     [:h3 (or title "Memory")]
     [:div {:class "main"}
      [:div {:class "main-text"} used]
      [:div [:span {:class "main-text-label" :style "padding-left:20px;"}  (str "/ " total)]]
      [:div {:class "sub-text"} (str "max " max)]]
     [:h4
      (when-let [subtitle (:subtitle (meta data))]
        (if-let [link (:link (meta data))]
          [:a {:href link} subtitle]
          subtitle))]]))