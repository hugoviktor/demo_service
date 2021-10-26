(ns hexagon.server
  (:gen-class)
  (:require [com.stuartsierra.component :as component]
            [hexagon.di.component :as di-component]
            [schema.core :as s]
            [taoensso.timbre :as timbre]
            )
  )

(defn -main
  "The entry-point for 'lein run'"
  [& args]
  (timbre/info "Creating server...")
  (component/start (di-component/start-server :dev))
  (s/set-fn-validation! true)
  (timbre/info "Server started, have fun! ;)")
  @(promise))

