(ns hexagon.infra.driving.http.service
  (:require [hexagon.domain.cases.payment-anticipator :as payment-anticipator]
            [io.pedestal.http :as http]
            [io.pedestal.http.route :as route]
            [io.pedestal.http.body-params :as body-params]))



(defn anticipate-payment-case [{{account-id :id} :data}]
  {
   :status 200
   :body   (payment-anticipator/anticipate account-id)
   }
  )



;; Tabular routes
(def routes #{["/anticipate/:id" :get anticipate-payment-case
               :route-name :do-anticipate]
              })
