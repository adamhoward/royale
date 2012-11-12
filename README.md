# royale

Because it's a metric system

An experimental dashboard in Clojure. I wanted a quick way to display
data from various sources in one place. Royale, itself, is just some
CSS and a pattern for generating HTML using Hiccup. The data can come
from anywhere. It's all based on simple maps.

I've included a few widget types, namely a "dashboard" widget that
displays keys and values from a map, and a table widget that does the
same thing but for a list of maps all containing the same keys.

In the small demo I'm using JMX calls to retireve data about the
current process, but I've also used clojure.java.jdbc to query
databases and display the results in the table widget and clj-http to
screen scrape data from a web page.


## Try it
* Clone repo
* `> lein run`
* Browse to http://localhost:8000/

## Sample
<img src="https://github.com/downloads/adamhoward/royale/royale-screenshot.png" alt="Screenshot" title="Screenshot" />
