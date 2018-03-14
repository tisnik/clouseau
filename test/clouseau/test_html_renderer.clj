;;;
;;;   Clouseau
;;; 
;;;    Copyright (C) 2015, 2016, 2017, 2018  Pavel Tisnovsky <ptisnovs@redhat.com>
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

(ns clouseau.test-html-renderer
  (:require [clojure.test :refer :all]
            [clouseau.html-renderer :refer :all]))

;
; Common functions used by tests.
;

(defn callable?
    "Test if given function-name is bound to the real function."
    [function-name]
    (clojure.test/function? function-name))

;
; Tests for various defs and functions
;

(deftest test-render-html-header-existence
    "Check that the clouseau.html-renderer/render-html-header definition exists."
    (testing "if the clouseau.html-renderer/render-html-header definition exists."
        (is (callable? 'clouseau.html-renderer/render-html-header))))

(deftest test-render-html-footer-existence
    "Check that the clouseau.html-renderer/render-html-footer definition exists."
    (testing "if the clouseau.html-renderer/render-html-footer definition exists."
        (is (callable? 'clouseau.html-renderer/render-html-footer))))

(deftest test-render-search-field-existence
    "Check that the clouseau.html-renderer/render-search-field definition exists."
    (testing "if the clouseau.html-renderer/render-search-field definition exists."
        (is (callable? 'clouseau.html-renderer/render-search-field))))

(deftest test-render-name-field-existence
    "Check that the clouseau.html-renderer/render-name-field definition exists."
    (testing "if the clouseau.html-renderer/render-name-field definition exists."
        (is (callable? 'clouseau.html-renderer/render-name-field))))

(deftest test-render-navigation-bar-section-existence
    "Check that the clouseau.html-renderer/render-navigation-bar-section definition exists."
    (testing "if the clouseau.html-renderer/render-navigation-bar-section definition exists."
        (is (callable? 'clouseau.html-renderer/render-navigation-bar-section))))

(deftest test-render-description-existence
    "Check that the clouseau.html-renderer/render-description definition exists."
    (testing "if the clouseau.html-renderer/render-description definition exists."
        (is (callable? 'clouseau.html-renderer/render-description))))

(deftest test-render-error-page-existence
    "Check that the clouseau.html-renderer/render-error-page definition exists."
    (testing "if the clouseau.html-renderer/render-error-page definition exists."
        (is (callable? 'clouseau.html-renderer/render-error-page))))

(deftest test-render-front-page-existence
    "Check that the clouseau.html-renderer/render-front-page definition exists."
    (testing "if the clouseau.html-renderer/render-front-page definition exists."
        (is (callable? 'clouseau.html-renderer/render-front-page))))

(deftest test-render-descriptions-existence
    "Check that the clouseau.html-renderer/render-descriptions definition exists."
    (testing "if the clouseau.html-renderer/render-descriptions definition exists."
        (is (callable? 'clouseau.html-renderer/render-descriptions))))

(deftest test-render-user-existence
    "Check that the clouseau.html-renderer/render-user definition exists."
    (testing "if the clouseau.html-renderer/render-user definition exists."
        (is (callable? 'clouseau.html-renderer/render-user))))

(deftest test-render-users-existence
    "Check that the clouseau.html-renderer/render-users definition exists."
    (testing "if the clouseau.html-renderer/render-users definition exists."
        (is (callable? 'clouseau.html-renderer/render-users))))

(deftest test-render-admin-interface-existence
    "Check that the clouseau.html-renderer/render-admin-interface definition exists."
    (testing "if the clouseau.html-renderer/render-admin-interface definition exists."
        (is (callable? 'clouseau.html-renderer/render-admin-interface))))

;
; Tests for function behaviours
;

(deftest test-render-html-header
    "Check that the clouseau.html-renderer/render-html-header."
    (testing "if the clouseau.html-renderer/render-html-header."
        (is (seq (render-html-header "package")))))

(deftest test-render-html-footer
    "Check that the clouseau.html-renderer/render-html-footer."
    (testing "if the clouseau.html-renderer/render-html-footer."
        (is (seq (render-html-footer)))))

(deftest test-render-search-field
    "Check that the clouseau.html-renderer/render-search-field."
    (testing "if the clouseau.html-renderer/render-search-field."
        (is (seq (render-search-field "package")))))

(deftest test-render-name-field
    "Check that the clouseau.html-renderer/render-name-field."
    (testing "if the clouseau.html-renderer/render-name-field."
        (is (seq (render-name-field "user-name")))))

(deftest test-render-navigation-bar-section
    "Check that the clouseau.html-renderer/render-navigation-bar-section."
    (testing "if the clouseau.html-renderer/render-navigation-bar-section."
        (is (seq (render-navigation-bar-section "package" "user-name")))))

(deftest test-render-description
    "Check that the clouseau.html-renderer/render-description."
    (testing "if the clouseau.html-renderer/render-description."
        (is (seq (render-description "package description")))))

(deftest test-render-error-page
    "Check that the clouseau.html-renderer/render-error-page."
    (testing "if the clouseau.html-renderer/render-error-page."
        (is (seq (render-error-page "package" "user-name" "error message")))))

(deftest test-show-info-about-update
    "Check that the clouseau.html-renderer/show-info-about-update."
    (testing "if the clouseau.html-renderer/show-info-about-update."
        (is (seq (show-info-about-update "package")))))

(deftest test-render-front-page
    "Check that the clouseau.html-renderer/render-front-page."
    (testing "if the clouseau.html-renderer/render-front-page."
        (is (seq (render-front-page [] "package" "package-description" "ccs-description" [] [] "new description" "user-name")))))

(deftest test-render-descriptions
    "Check that the clouseau.html-renderer/render-descriptions."
    (testing "if the clouseau.html-renderer/render-descriptions."
        (is (seq (render-descriptions [] "user-name")))))

(deftest test-render-user
    "Check that the clouseau.html-renderer/render-user."
    (testing "if the clouseau.html-renderer/render-user."
        (is (seq (render-user [] "selected-user" "user-name")))))

(deftest test-render-users
    "Check that the clouseau.html-renderer/render-users."
    (testing "if the clouseau.html-renderer/render-users."
        (is (seq (render-users [] [] "user-name")))))

(deftest test-render-admin-interface
    "Check that the clouseau.html-renderer/render-admin-interface."
    (testing "if the clouseau.html-renderer/render-admin-interface."
        (is (seq (render-admin-interface [] "user-name")))))

