(ns hexagon.infra.driving.http.service
  (:require [hexagon.domain.cases.payment-anticipator :as payment-anticipator]
            [io.pedestal.http :as http]
            [io.pedestal.http.route :as route]
            [io.pedestal.http.body-params :as body-params]
            [hexagon.infra.driven.tracing.tracer :as tracer]
            ))



(defn anticipate-payment-case [data]
  (tracer/trace "Entering anticipate case")
  (let [account-id (get-in data [:path-params :id])]
    {
     :status 200
     :body   (payment-anticipator/anticipate account-id)
     }
    ))



(def common-interceptors [(body-params/body-params) http/json-body])


;; Tabular routes
(def routes #{["/anticipate/:id" :get (conj common-interceptors anticipate-payment-case)
               :route-name :do-anticipate]
              })
