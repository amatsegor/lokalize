import org.jetbrains.kotlin.gradle.dsl.Coroutines

buildscript {
    repositories {
        mavenCentral()
    }
}

plugins {
    id("kotlin-platform-common") version (Versions.Kotlin)
}

repositories {
    mavenCentral()
}

dependencies {
    compile( "org.jetbrains.kotlin:kotlin-stdlib-common")
    compile("org.jetbrains.kotlinx:kotlinx-coroutines-core:0.26.0")

    testCompile( "org.jetbrains.kotlin:kotlin-test-annotations-common")
    testCompile("org.jetbrains.kotlin:kotlin-test-common")
}

kotlin {
    experimental {
        coroutines = Coroutines.ENABLE
    }
}