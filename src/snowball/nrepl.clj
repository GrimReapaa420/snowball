(ns snowball.nrepl
  (:require [clojure.tools.nrepl.server :as nrepl]
            [taoensso.timbre :as log]
            [cider.nrepl]
            [snowball.config :as config]))

(defn init! []
  (let [port (config/get :nrepl :port)]
    (log/info "Starting nREPL server on port" port)
    (nrepl/start-server :port port :handler (ns-resolve 'cider.nrepl 'cider-nrepl-handler))))
