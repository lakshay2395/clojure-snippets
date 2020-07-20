(defproject etcd3-clojure "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.clojure/core.async "0.4.490"]
                 [protojure "1.2.0"]
                 [protojure/google.protobuf "0.9.1"]
                 [org.eclipse.jetty.http2/http2-client "9.4.25.v20191220"]
                 [io.undertow/undertow-core "2.0.28.Final"]
                 [io.undertow/undertow-servlet "2.0.28.Final"]
                 [com.google.protobuf/protobuf-java "3.11.1"]]
  :repl-options {:init-ns etcd3-clojure.core})
