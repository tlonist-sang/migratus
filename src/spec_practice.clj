(ns spec-practice
  (:require [clojure.spec.alpha :as s]
            [clojure.pprint :as pp]
            [clojure.spec.test.alpha :as stest]
            [clojure.spec.gen.alpha :as gen]))

(s/def ::username string?)
(s/def ::password string?)

(s/def ::last-login number?)
(s/def ::comment string?)

;; map validation
(s/def ::user
  (s/keys
    :req [::username ::password]
    :opt [::comment ::last-login]))

;; sequence validation
(s/def ::function (s/cat :defn #{'defn}
                         :name symbol?
                         :doc (s/? string?) ;zero or one
                         :args vector?
                         :body (s/+ list?))) ;one or more
;; s/* for zero or more
(s/def ::ingredient (s/cat :quantity number? :unit keyword?))

;; About generating data => https://www.youtube.com/watch?v=F4VZPxLZUdA


(comment
  (println
    (s/valid? ::username "foo"))

  (s/explain
    ::user
    {::username   "rich"
     ::comment    "this is a user"})

  (s/conform ::ingredient [10 :a])

  (def function-code1
    '(defn my-function
       "this is a test function"
       [x y]
       (+ x y)))

  (pp/pprint
      (s/conform ::function function-code1))

  (gen/sample (s/gen ::user) 5)
  ,)