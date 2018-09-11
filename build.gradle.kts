import org.jetbrains.kotlin.gradle.tasks.Kotlin2JsCompile
import kotlin.collections.listOf

group = "ua.amatsehor.lokalize"
version = "1.0.0"

buildscript {
    repositories {
        jcenter()
        mavenCentral()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.Kotlin}")
    }
}

repositories {
    jcenter()
}

plugins {
    id("kotlin2js") version Versions.Kotlin
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-js:${Versions.Kotlin}")
}

val mainSourceSet = sourceSets["main"]

tasks {
    "compileKotlin2Js"(Kotlin2JsCompile::class) {
        kotlinOptions {
            moduleKind = "commonjs"
            outputFile = "src/main/out/lokalize.js"
        }
    }
}