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

(ns clouseau.db-spec
    "Namespace that contains configuration of all JDBC sources.")

(require '[clojure.tools.logging  :as log])


;
; This database file contains table named 'ccs-description'.
;
; Table 'ccs-description' should have the following format:
;    create table packages (
;        name        text not null,
;        description text not null
;    );
;
(def ccs-db
    {:classname   "org.sqlite.JDBC"
     :subprotocol "sqlite"
     :subname     "ccs_descriptions.db"
    })

;
; This database file contains table named 'changes'.
;
; Table 'changes' should have the following format:
;     create table changes (
;         id          integer primary key asc,
;         date_time   text,
;         user_name   text,
;         package     text,
;         description text
;     );
;
(def changes-db
    {:classname   "org.sqlite.JDBC"
     :subprotocol "sqlite"
     :subname     "changes.db"
    })

