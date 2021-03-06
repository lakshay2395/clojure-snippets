;;;----------------------------------------------------------------------------------
;;; Generated by protoc-gen-clojure.  DO NOT EDIT
;;;
;;; GRPC electionpb.Election Client Implementation
;;;----------------------------------------------------------------------------------
(ns electionpb.Election.client
  (:require [electionpb :refer :all]
            [mvccpb :as mvccpb]
            [etcdserverpb :as etcdserverpb]
            [clojure.core.async :as async]
            [protojure.grpc.client.utils :refer [send-unary-params invoke-unary]]
            [promesa.core :as p]
            [protojure.grpc.client.api :as grpc]))

;-----------------------------------------------------------------------------
; GRPC Client Implementation
;-----------------------------------------------------------------------------

(defn Campaign
  [client params]
  (let [input (async/chan 1)
        output (async/chan 1)
        desc {:service "electionpb.Election"
              :method  "Campaign"
              :input   {:f electionpb/new-CampaignRequest :ch input}
              :output  {:f electionpb/pb->CampaignResponse :ch output}}]
    (-> (send-unary-params input params)
        (p/then (fn [_] (invoke-unary client desc output))))))

(defn Proclaim
  [client params]
  (let [input (async/chan 1)
        output (async/chan 1)
        desc {:service "electionpb.Election"
              :method  "Proclaim"
              :input   {:f electionpb/new-ProclaimRequest :ch input}
              :output  {:f electionpb/pb->ProclaimResponse :ch output}}]
    (-> (send-unary-params input params)
        (p/then (fn [_] (invoke-unary client desc output))))))

(defn Leader
  [client params]
  (let [input (async/chan 1)
        output (async/chan 1)
        desc {:service "electionpb.Election"
              :method  "Leader"
              :input   {:f electionpb/new-LeaderRequest :ch input}
              :output  {:f electionpb/pb->LeaderResponse :ch output}}]
    (-> (send-unary-params input params)
        (p/then (fn [_] (invoke-unary client desc output))))))

(defn Observe
  [client params reply]
  (let [input (async/chan 1)
        desc {:service "electionpb.Election"
              :method  "Observe"
              :input   {:f electionpb/new-LeaderRequest :ch input}
              :output  {:f electionpb/pb->LeaderResponse :ch reply}}]
    (-> (send-unary-params input params)
        (p/then (fn [_] (grpc/invoke client desc))))))

(defn Resign
  [client params]
  (let [input (async/chan 1)
        output (async/chan 1)
        desc {:service "electionpb.Election"
              :method  "Resign"
              :input   {:f electionpb/new-ResignRequest :ch input}
              :output  {:f electionpb/pb->ResignResponse :ch output}}]
    (-> (send-unary-params input params)
        (p/then (fn [_] (invoke-unary client desc output))))))

