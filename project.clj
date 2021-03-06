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
                 [yogthos/config "1.1.7"]
                 [clj-http "3.12.3"]
                 [org.clojure/tools.reader "1.3.6"]
                 [cheshire "5.10.1"]
                 [org.clojure/data.json "2.4.0"]]
  :resource-paths ["config", "resources"]
  :profiles {:dev     {:aliases      {"run-dev" ["trampoline" "run" "-m" "hexagon.server/main"]}
                       :dependencies [[io.pedestal/pedestal.service-tools "0.5.8"]]}
             :uberjar {:aot [hexagon.server]}}
  :main ^{:skip-aot true} hexagon.server
  :java-cmd "/Users/victor.julio/Library/Java/JavaVirtualMachines/corretto-1.8.0_302/Contents/Home/bin/java"
  ;:javac-options ["-parameters"]
  ;:jvm-opts ["-agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=6789" "-javaagent:/Users/victor.julio/Documents/nu/pocdebug/rook.jar.src/target/rook.jar.src-1.0-SNAPSHOT-jar-with-dependencies.jar"]
  :repl-options {:init-ns hexagon.server})
