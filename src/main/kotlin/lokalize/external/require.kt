external fun require(module: String): dynamic

val Process by lazy { require("process") }

val Fs by lazy { require("fs") }

val Path by lazy { require("path") }

val Mkpath by lazy { require("mkpath") }