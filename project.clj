;;;
;;;   Clouseau
;;; 
;;;    Copyright (C) 2015, 2016, 2017, 2018  Pavel Tisnovsky <ptisnovs@redhat.com>
;;; 
;;; Bytecode synth is free software; you can redistribute it and/or modify
;;; it under the terms of the GNU General Public License as published by
;;; the Free Software Foundation; either version 2, or (at your option)
;;; any later version.
;;; 
;;; Bytecode synth is distributed in the hope that it will be useful, but
;;; WITHOUT ANY WARRANTY; without even the implied warranty of
;;; MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
;;; General Public License for more details.
;;; 
;;; You should have received a copy of the GNU General Public License
;;; along with Bytecode synth; see the file COPYING.  If not, write to the
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

(defproject clouseau "0.1.0-SNAPSHOT"
    :description "Package finder"
    :url "https://github.com/tisnik/clouseau"
    :license {:name "Eclipse Public License"
              :url "http://www.eclipse.org/legal/epl-v10.html"}
    :dependencies [[org.clojure/clojure "1.8.0"]
                   [irclj "0.5.0-alpha4"]
                   [org.clojure/java.jdbc "0.3.5"]
                   [org.clojure/tools.cli "0.3.1"]
                   [org.xerial/sqlite-jdbc "3.7.2"]
                   [clojure-ini "0.0.1"]
                   [ring/ring-core "1.3.2"]
                   [ring/ring-jetty-adapter "1.3.2"]
                   [hiccup "1.0.4"]
                   [org.clojure/tools.logging "0.3.1"]
                   [log4j/log4j "1.2.17" :exclusions [javax.mail/mail
                                                      javax.jms/jms
                                                      com.sun.jmdk/jmxtools
                                                      com.sun.jmx/jmxri]]
                   [org.slf4j/slf4j-log4j12 "1.6.6"]
                   [org.clojars.tisnik/clj-utils "0.1.0-SNAPSHOT"]
                   [org.clojars.tisnik/clj-middleware "0.1.0-SNAPSHOT"]
                   [org.clojars.tisnik/clj-config-loader "0.1.0-SNAPSHOT"]
                   [org.clojars.tisnik/clj-fileutils "0.4.0-SNAPSHOT"]]
    :dev-dependencies [[lein-ring "0.8.10"]]
    :plugins [[lein-ring "0.8.10"]
              [codox "0.8.11"]
              [test2junit "1.1.0"]
              [lein-cloverage "1.0.7-SNAPSHOT"]]
    :ring {:handler clouseau.core/app}
    :main clouseau.core)

