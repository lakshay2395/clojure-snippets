;;;----------------------------------------------------------------------------------
;;; Generated by protoc-gen-clojure.  DO NOT EDIT
;;;
;;; Message Implementation of package com.example.addressbook
;;;----------------------------------------------------------------------------------
(ns com.example.addressbook
  (:require [protojure.protobuf.protocol :as pb]
            [protojure.protobuf.serdes.core :refer :all]
            [protojure.protobuf.serdes.complex :refer :all]
            [protojure.protobuf.serdes.utils :refer [tag-map]]
            [protojure.protobuf.serdes.stream :as stream]
            [clojure.set :as set]
            [clojure.spec.alpha :as s]))

;;----------------------------------------------------------------------------------
;;----------------------------------------------------------------------------------
;; Forward declarations
;;----------------------------------------------------------------------------------
;;----------------------------------------------------------------------------------

(declare cis->Person)
(declare ecis->Person)
(declare new-Person)
(declare cis->AddressBook)
(declare ecis->AddressBook)
(declare new-AddressBook)
(declare cis->HelloResponse)
(declare ecis->HelloResponse)
(declare new-HelloResponse)


;;----------------------------------------------------------------------------------
;;----------------------------------------------------------------------------------
;; Message Implementations
;;----------------------------------------------------------------------------------
;;----------------------------------------------------------------------------------

;-----------------------------------------------------------------------------
; Person
;-----------------------------------------------------------------------------
(defrecord Person [name]
  pb/Writer

  (serialize [this os]
    (write-String 1  {:optimize true} (:name this) os)))

(s/def :com.example.addressbook.messages.Person/name string?)
(s/def ::Person-spec (s/keys :opt-un [:com.example.addressbook.messages.Person/name ]))
(def Person-defaults {:name "" })

(defn cis->Person
  "CodedInputStream to Person"
  [is]
  (->> (tag-map Person-defaults
         (fn [tag index]
             (case index
               1 [:name (cis->String is)]

               [index (cis->undefined tag is)]))
         is)
        (map->Person)))

(defn ecis->Person
  "Embedded CodedInputStream to Person"
  [is]
  (cis->embedded cis->Person is))

(defn new-Person
  "Creates a new instance from a map, similar to map->Person except that
  it properly accounts for nested messages, when applicable.
  "
  [init]
  {:pre [(if (s/valid? ::Person-spec init) true (throw (ex-info "Invalid input" (s/explain-data ::Person-spec init))))]}
  (-> (merge Person-defaults init)
      (map->Person)))

(defn pb->Person
  "Protobuf to Person"
  [input]
  (cis->Person (stream/new-cis input)))

;-----------------------------------------------------------------------------
; AddressBook
;-----------------------------------------------------------------------------
(defrecord AddressBook [people]
  pb/Writer

  (serialize [this os]
    (write-repeated write-embedded 1 (:people this) os)))

(s/def ::AddressBook-spec (s/keys :opt-un []))
(def AddressBook-defaults {:people [] })

(defn cis->AddressBook
  "CodedInputStream to AddressBook"
  [is]
  (->> (tag-map AddressBook-defaults
         (fn [tag index]
             (case index
               1 [:people (cis->repeated ecis->Person is)]

               [index (cis->undefined tag is)]))
         is)
        (map->AddressBook)))

(defn ecis->AddressBook
  "Embedded CodedInputStream to AddressBook"
  [is]
  (cis->embedded cis->AddressBook is))

(defn new-AddressBook
  "Creates a new instance from a map, similar to map->AddressBook except that
  it properly accounts for nested messages, when applicable.
  "
  [init]
  {:pre [(if (s/valid? ::AddressBook-spec init) true (throw (ex-info "Invalid input" (s/explain-data ::AddressBook-spec init))))]}
  (-> (merge AddressBook-defaults init)
      (cond-> (contains? init :people) (update :people #(map new-Person %)))
      (map->AddressBook)))

(defn pb->AddressBook
  "Protobuf to AddressBook"
  [input]
  (cis->AddressBook (stream/new-cis input)))

;-----------------------------------------------------------------------------
; HelloResponse
;-----------------------------------------------------------------------------
(defrecord HelloResponse [message]
  pb/Writer

  (serialize [this os]
    (write-String 1  {:optimize true} (:message this) os)))

(s/def :com.example.addressbook.messages.HelloResponse/message string?)
(s/def ::HelloResponse-spec (s/keys :opt-un [:com.example.addressbook.messages.HelloResponse/message ]))
(def HelloResponse-defaults {:message "" })

(defn cis->HelloResponse
  "CodedInputStream to HelloResponse"
  [is]
  (->> (tag-map HelloResponse-defaults
         (fn [tag index]
             (case index
               1 [:message (cis->String is)]

               [index (cis->undefined tag is)]))
         is)
        (map->HelloResponse)))

(defn ecis->HelloResponse
  "Embedded CodedInputStream to HelloResponse"
  [is]
  (cis->embedded cis->HelloResponse is))

(defn new-HelloResponse
  "Creates a new instance from a map, similar to map->HelloResponse except that
  it properly accounts for nested messages, when applicable.
  "
  [init]
  {:pre [(if (s/valid? ::HelloResponse-spec init) true (throw (ex-info "Invalid input" (s/explain-data ::HelloResponse-spec init))))]}
  (-> (merge HelloResponse-defaults init)
      (map->HelloResponse)))

(defn pb->HelloResponse
  "Protobuf to HelloResponse"
  [input]
  (cis->HelloResponse (stream/new-cis input)))

