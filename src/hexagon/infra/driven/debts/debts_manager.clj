(ns hexagon.infra.driven.debts.debts-manager)

(defn anticipate-loan [account-id loan-id]
  ;; Mark a loan as anticipated
  {:anticipated true :loan-id loan-id :account-id account-id}
  )
