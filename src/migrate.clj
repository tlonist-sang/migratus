(ns migrate
  (:require [migratus.core :as migratus]))


;To run migrations against several different databases (in MySQL, or "schemas" in Postgres, etc.), with embedded use statements in your migrations, specify the database in your migration-table-name in the connections, i.e. database_name.table_name not table_name.



(def config {:store                :database
             :migration-dir        "migrations/"
             :init-script          "init.sql"
             ;script should be located in the :migration-dir path
             ;defaults to true, some databases do not support
             ;schema initialization in a transaction
             :init-in-transaction? false
             :db                   {:classname   "com.mysql.cj.jdbc.Driver"
                                    :subprotocol "mysql"
                                    :subname     "//localhost:3306/test5"
                                    :user        "root"
                                    :password    "1234"}})


; Migration reserved by another instance. Ignoring
; When above error breaks out, delete from schema_migrations where id = -1

(comment
  ;initialize the database using the 'init.sql' script
  (migratus/init config)

  ;apply pending migrations
  (migratus/migrate config)

  ;rollback the migration with the latest timestamp
  (migratus/rollback config)

  ;bring up migrations matching the ids
  (migratus/up config 20211230120025)

  ;bring down migrations matching the ids
  (migratus/down config 20111206154000)

  ;; minimal config needed to call create while specifying the destination path
  (migratus/create {:migration-dir "migrations"} "create-comments")
  (migratus/create {:migration-dir "migrations"} "update-comments")

  ;; bad practice. Two jobs at one up & down.
  (migratus/create {:migration-dir "migrations"} "add-indexes-comments")
  ,)
