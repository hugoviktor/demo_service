(ns hexagon.domain.cases.payment-anticipator
  (:require [hexagon.infra.driven.loans.loans-manager :as loan-manager]
            [hexagon.infra.driven.debts.debts-manager :as debts-manager]
            [hexagon.infra.driven.loans.counter :as word-counter]
            [clojure.data.json :as json]
            ))

(defn normalize-loans [loans-resp]
  (-> loans-resp
      :body
      (json/read-str :key-fn keyword)
      :loans
      ))

(defn anticipate [account-id]
  (->> (loan-manager/all-loans account-id)
       (normalize-loans)
       (map #(debts-manager/anticipate-loan  account-id (:id %)))))
