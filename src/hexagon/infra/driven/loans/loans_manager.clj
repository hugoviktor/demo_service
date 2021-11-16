(ns hexagon.infra.driven.loans.loans-manager
  (:require [clj-http.client :as client]
            [clojure.data.json :as json]))

(defn all-loans [account-id]
  ;; Get All Loans
  (client/get (str "http://localhost:3000/loans/" account-id)   {:as "UTF-8"}))

#_(println
  (-> (all-loans "1234")
      :body
      (json/read-str :key-fn keyword)
      :loans
      ))


