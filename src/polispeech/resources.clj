(ns polispeech.resources
    (:use
        [polispeech.pages :only [main-page]]
        [polispeech.speeches :only [get-political-speech htmlize-newlines]]
        [liberator.core :refer [resource defresource]]
        [liberator.dev :refer [wrap-trace]]))

(def DEFAULT_THEME "mainstream")
(defn- get-params [context]
    (get-in context [:request :params]))
(defn- get-theme [ctx]
    (or (:theme (get-params ctx)) DEFAULT_THEME))

(defresource render-main
    :available-media-types ["text/html"]
    :allowed-methods [:get]
    :handle-ok (fn [context]
        (let [theme (get-theme context)]
            (main-page theme)))
)

(defresource get-speech
    :available-media-types ["text/plain"]
    :allowed-methods [:get]
    :handle-ok (fn [context]
        (let [theme (get-theme context)
              make-result (comp htmlize-newlines get-political-speech)
              n (println theme)]
            (make-result theme)))
)
