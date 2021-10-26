(ns hexagon.di.component
  (:require [com.stuartsierra.component :as component]
            [hexagon.di.pedestal :as pedestal]
            [hexagon.di.http-config :as http-config]
            [hexagon.di.context-deps :as context-deps]))

(defn start-server [environment]
  (component/system-map
    :service-map (http-config/provides environment)
    :context-deps (component/using (context-deps/provides) [])
    :pedestal (component/using (pedestal/provides) [:service-map :context-deps])))
