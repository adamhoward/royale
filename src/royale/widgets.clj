(ns royale.widgets)

(defn dashboard-widget [data & [title col-size]]
  (let [data-size (count data)]
    [:div {:class (str "widget block span" (+ (dec data-size) (* data-size (or col-size 4))))}
     [:h3 title]
     [:div {:class "main"}
      (for [[key val] data]
        [:div {:class (str "main-text" (when (> data-size 1) (str " span" (or col-size 4))))}
         [:span val] [:span {:class "main-text-label"} (name key)]])]
     [:h4
      (when-let [subtitle (:subtitle (meta data))]
        (if-let [link (:link (meta data))]
          [:a {:href link} subtitle]
          subtitle))]]))

(defn table-widget [data & title]
  [:div {:class "widget"}
   [:h3 title]
   [:div {:class "main table"}
    [:table
     [:tr {:class "widget-table-header"}
      (for [key (keys (first data))]
        [:td key])]
     (for [row data]
       [:tr
        (for [field row]
          [:td field])])]]])