(defproject polispeech "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                [generator "0.1.2"]
                [marshmacros "0.2.1"]
                [garden "1.1.3"]
                [hiccups "0.3.0"]
                [org.clojure/clojurescript "0.0-1934"]
                [prismatic/dommy "0.1.1"]]

  :plugins [[lein-cljsbuild "0.3.4"]
            [lein-garden "0.1.0"]]

  :cljsbuild {:builds
              {
                :dev
                  {:source-paths ["src/"]
                    :compiler {:output-to "resources/public/js/speeches.js"
                               :optimizations :whitespace
                               :pretty-print true}}
                :prod
                  {:source-paths ["src/"]
                    :compiler {:output-to "resources/public/js/speeches.js"
                               :optimizations :advanced
                               :pretty-print false}}
              }}



  :garden {:builds[{
            :id "screen"
            :stylesheet style.core/main
            :compiler {
              :output-to "resources/public/css/main.css"
              :pretty-print? true
            }

    }]}
  )
