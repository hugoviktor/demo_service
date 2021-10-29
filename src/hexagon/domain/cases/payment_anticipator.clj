(ns hexagon.domain.cases.payment-anticipator
  (:require [hexagon.infra.driven.loans.loans-manager :as loan-manager]
            [hexagon.infra.driven.debts.debts-manager :as debts-manager]
            ))

(defn anticipate [account-id]
  (->> (loan-manager/all-loans account-id)
       (map #(debts-manager/anticipate-loan (:id %) account-id))))
