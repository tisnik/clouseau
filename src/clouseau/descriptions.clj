;;;
;;;   Clouseau
;;; 
;;;    Copyright (C) 2017, 2018  Pavel Tisnovsky <ptisnovs@redhat.com>
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


(ns clouseau.descriptions)

(require '[clojure.tools.logging  :as log])

(require '[clouseau.db-interface  :as db-interface])

(defn read-description
    "Read description from the database for specified product and package."
    [product package]
    (try
        (let [result (db-interface/read-description product package)
              desc   (:description (first result))]
            (if (not desc)
                ""  ; special value that will be handled later
                (.replaceAll desc "\n" "<br />")))
        (catch Exception e
            ; print error message in case of any DB-related exception
            (log/error "read-description(): error accessing database '" (:subname (second product)) "'!")
            (log/error e)
            (.printStackTrace e)
            (log/error "package" package)
            nil)))  ; special value that will be handled later

(defn try-to-read-description
    "Read package description, but only when package is specified."
    [product package]
    (if package
        (read-description product package)
        ""))

