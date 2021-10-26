(ns hexagon.di.http-config
  (:require [hexagon.infra.driving.http.service :as service]
            [io.pedestal.http :as http]
            [io.pedestal.http :as server]))

(defn provides
  [environment]
  (-> {:env                 environment
       ::http/routes        service/routes
       ::http/type          :jetty
       ::http/port          8890
       ::http/resource-path "/public"
       ::http/join?         false
       ::http/host          "0.0.0.0"}
      server/default-interceptors
      server/dev-interceptors))
