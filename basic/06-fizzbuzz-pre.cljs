
(ns basic.p06-pre)

;; -----------------------------------------------------------------------------------------
;; There is another data type called sets (like ES7 sets)
;; Collection of unique elements

(set [1 2 3])

(def account-types #{:facebook :twitter :github})

;; When you ask a set it gives you what you asked, or nil if it
;; is not there.

(get account-types :facebook)
(get account-types :google)

(account-types :facebook)
(account-types :google)

;; Sets are very useful where you would do a complex OR if

(def account :google)

(if (or (= account :facebook)
        (= account :twitter)
        (= account :github))
  "Account valid"
  "Account invalid")

(if (account-types account)
  "Account valid"
  "Account invalid")

;; -----------------------------------------------------------------------------------------
;; Another way of taming branching is with conditions (cond, condp, case)

;; Case is like the JS switch, but without fallthrough
(case account
  :google "Google account"
  :facebook "Facebook account"
  :twitter "Twitter account"
  :github "Github account"
  "Unknown")

;; Cond is for using expressions in the tests
;; Very useful to avoid chains of if/else

(cond
 (= account :google) "Google account"
 (= account :facebook) "Facebook account"
 :else "Invalid")

;; Condp is like cond, but with a fixed predicate (function + argument)

(condp = account
 :google "Google account"
 :facebook "Facebook account"
 :else "Invalid")

