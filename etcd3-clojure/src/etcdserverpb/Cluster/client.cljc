;;;----------------------------------------------------------------------------------
;;; Generated by protoc-gen-clojure.  DO NOT EDIT
;;;
;;; GRPC etcdserverpb.Cluster Client Implementation
;;;----------------------------------------------------------------------------------
(ns etcdserverpb.Cluster.client
  (:require [etcdserverpb :refer :all]
            [authpb :as authpb]
            [mvccpb :as mvccpb]
            [clojure.core.async :as async]
            [protojure.grpc.client.utils :refer [send-unary-params invoke-unary]]
            [promesa.core :as p]
            [protojure.grpc.client.api :as grpc]))

;-----------------------------------------------------------------------------
; GRPC Client Implementation
;-----------------------------------------------------------------------------

(defn MemberAdd
  [client params]
  (let [input (async/chan 1)
        output (async/chan 1)
        desc {:service "etcdserverpb.Cluster"
              :method  "MemberAdd"
              :input   {:f etcdserverpb/new-MemberAddRequest :ch input}
              :output  {:f etcdserverpb/pb->MemberAddResponse :ch output}}]
    (-> (send-unary-params input params)
        (p/then (fn [_] (invoke-unary client desc output))))))

(defn MemberRemove
  [client params]
  (let [input (async/chan 1)
        output (async/chan 1)
        desc {:service "etcdserverpb.Cluster"
              :method  "MemberRemove"
              :input   {:f etcdserverpb/new-MemberRemoveRequest :ch input}
              :output  {:f etcdserverpb/pb->MemberRemoveResponse :ch output}}]
    (-> (send-unary-params input params)
        (p/then (fn [_] (invoke-unary client desc output))))))

(defn MemberUpdate
  [client params]
  (let [input (async/chan 1)
        output (async/chan 1)
        desc {:service "etcdserverpb.Cluster"
              :method  "MemberUpdate"
              :input   {:f etcdserverpb/new-MemberUpdateRequest :ch input}
              :output  {:f etcdserverpb/pb->MemberUpdateResponse :ch output}}]
    (-> (send-unary-params input params)
        (p/then (fn [_] (invoke-unary client desc output))))))

(defn MemberList
  [client params]
  (let [input (async/chan 1)
        output (async/chan 1)
        desc {:service "etcdserverpb.Cluster"
              :method  "MemberList"
              :input   {:f etcdserverpb/new-MemberListRequest :ch input}
              :output  {:f etcdserverpb/pb->MemberListResponse :ch output}}]
    (-> (send-unary-params input params)
        (p/then (fn [_] (invoke-unary client desc output))))))
