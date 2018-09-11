external fun require(module: String): dynamic

val Process by lazy { require("process") }

val Fs by lazy { require("fs") }

val Q by lazy { require("q") }