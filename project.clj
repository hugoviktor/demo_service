(defproject hexagon "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [com.stuartsierra/component "1.0.0"]
                 [com.stuartsierra/component.repl "0.2.0"]
                 [prismatic/schema "1.1.12"]
                 [io.pedestal/pedestal.service "0.5.8"]
                 [io.pedestal/pedestal.route "0.5.8"]
                 [io.pedestal/pedestal.jetty "0.5.8"]
                 [com.taoensso/timbre "4.10.0"]
                 [yogthos/config "1.1.7"]]
  :resource-paths ["config", "resources"]
  :profiles {:dev     {:aliases      {"run-dev" ["trampoline" "run" "-m" "github-jobs.server/main"]}
                       :dependencies [[io.pedestal/pedestal.service-tools "0.5.8"]]}
             :uberjar {:aot [github-jobs.server]}}
  :main ^{:skip-aot true} hexagon.server
  :repl-options {:init-ns hexagon.server})
