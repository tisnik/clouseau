;;;
;;;   Clouseau
;;; 
;;;    Copyright (C) 2015, 2016  Pavel Tisnovsky <ptisnovs@redhat.com>
;;; 
;;; Clouseau is free software; you can redistribute it and/or modify
;;; it under the terms of the GNU General Public License as published by
;;; the Free Software Foundation; either version 2, or (at your option)
;;; any later version.
;;; 
;;; Clouseau is distributed in the hope that it will be useful, but
;;; WITHOUT ANY WARRANTY; without even the implied warranty of
;;; MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
;;; General Public License for more details.
;;; 
;;; You should have received a copy of the GNU General Public License
;;; along with Clouseau; see the file COPYING.  If not, write to the
;;; Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
;;; 02110-1301 USA.
;;; 
;;; Linking this library statically or dynamically with other modules is
;;; making a combined work based on this library.  Thus, the terms and
;;; conditions of the GNU General Public License cover the whole
;;; combination.
;;; 
;;; As a special exception, the copyright holders of this library give you
;;; permission to link this library with independent modules to produce an
;;; executable, regardless of the license terms of these independent
;;; modules, and to copy and distribute the resulting executable under
;;; terms of your choice, provided that you also meet, for each linked
;;; independent module, the terms and conditions of the license of that
;;; module.  An independent module is a module which is not derived from
;;; or based on this library.  If you modify this library, you may extend
;;; this exception to your version of the library, but you are not
;;; obligated to do so. If you do not wish to do so, delete this
;;; exception statement from your version.
;;; 

(ns clouseau.test-utils
  (:require [clojure.test :refer :all]
            [clouseau.utils :refer :all]))

;
; Common functions used by tests.
;

(defn callable?
    "Test if given function-name is bound to the real function."
    [function-name]
    (clojure.test/function? function-name))

;
; Tests for various function definitions
;

(deftest test-third-existence
    "Check that the clouseau.utils/third definition exists."
    (testing "if the clouseau.utils/third definition exists."
        (is (callable? 'clouseau.utils/third))))


(deftest test-substring-existence
    "Check that the clouseau.utils/substring definition exists."
    (testing "if the clouseau.utils/substring definition exists."
        (is (callable? 'clouseau.utils/substring))))


(deftest test-startsWith-existence
    "Check that the clouseau.utils/startsWith definition exists."
    (testing "if the clouseau.utils/startsWith definition exists."
        (is (callable? 'clouseau.utils/startsWith))))


(deftest test-endsWith-existence
    "Check that the clouseau.utils/endsWith definition exists."
    (testing "if the clouseau.utils/endsWith definition exists."
        (is (callable? 'clouseau.utils/endsWith))))


(deftest test-contains-existence
    "Check that the clouseau.utils/contains definition exists."
    (testing "if the clouseau.utils/contains definition exists."
        (is (callable? 'clouseau.utils/contains))))


(deftest test-replaceAll-existence
    "Check that the clouseau.utils/replaceAll definition exists."
    (testing "if the clouseau.utils/replaceAll definition exists."
        (is (callable? 'clouseau.utils/replaceAll))))


(deftest test-get-exception-message-existence
    "Check that the clouseau.utils/get-exception-message definition exists."
    (testing "if the clouseau.utils/get-exception-message definition exists."
        (is (callable? 'clouseau.utils/get-exception-message))))

;
; Tests for behaviour of all functions
;

(deftest test-get-exception-message-1
    "Check the function clouseau.utils/get-exception-message."
    (testing "the function clouseau.utils/get-exception-message."
        (try
            (throw (new java.lang.Exception "Message text"))
            (is nil "Exception not thrown as expected!")
            (catch Exception e
                (is (= "Message text" (get-exception-message e)))))))

(deftest test-get-exception-message-2
    "Check the function clouseau.utils/get-exception-message."
    (testing "the function clouseau.utils/get-exception-message."
        (try
            (/ 1 0)
            (is nil "Exception not thrown as expected!")
            (catch Exception e
                (is (= "Divide by zero" (get-exception-message e)))))))

(deftest test-get-exception-message-3
    "Check the function clouseau.utils/get-exception-message."
    (testing "the function clouseau.utils/get-exception-message."
        (try
            (Integer/parseInt "unparseable")
            (is nil "Exception not thrown as expected!")
            (catch Exception e
                (is (.startsWith (get-exception-message e) "For input string:"))))))

(deftest test-get-exception-message-4
    "Check the function clouseau.utils/get-exception-message."
    (testing "the function clouseau.utils/get-exception-message."
        (try
            (throw (new java.lang.Exception ""))
            (is nil "Exception not thrown as expected!")
            (catch Exception e
                (is (= "" (get-exception-message e)))))))

(deftest test-get-exception-message-5
    "Check the function clouseau.utils/get-exception-message."
    (testing "the function clouseau.utils/get-exception-message."
        (try
            (throw (new java.lang.Exception))
            (is nil "Exception not thrown as expected!")
            (catch Exception e
                (is (nil? (get-exception-message e)))))))

(deftest test-get-exception-message-6
    "Check the function clouseau.utils/get-exception-message."
    (testing "the function clouseau.utils/get-exception-message."
        (try
            (println (nth [] 10)) ; realize the sequence and getter
            (is nil "Exception not thrown as expected!")
            (catch Exception e
                (is (nil? (get-exception-message e)))))))
