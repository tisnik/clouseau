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

(ns clouseau.utils)

(defn third
    "Simple utility function - returns third item from a given sequence."
    [coll]
    (get coll 2))

(defn substring
    "Call method String.substring()."
    ([^String s from to]
     (.substring s from to))
    ([^String s from]
     (.substring s from)))

(defn startsWith
    "Call method String.startsWith()."
    [^String s pattern]
    (.startsWith s pattern))

(defn endsWith
    "Call method String.endsWith()."
    [^String s pattern]
    (.endsWith s pattern))

(defn contains
    "Call method String.contains()."
    [^String s pattern]
    (.contains s pattern))

(defn replaceAll
    "Call method String.replaceAll()."
    [^String s pattern replacement]
    (.replaceAll s pattern replacement))

(defn get-exception-message
    "Retrieve a message from given exception."
    [^java.lang.Exception exception]
    (.getMessage exception))

