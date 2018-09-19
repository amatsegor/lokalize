import org.jetbrains.kotlin.gradle.dsl.Coroutines

buildscript {
    repositories {
        mavenCentral()
    }
}

plugins {
    id("kotlin-platform-common") version ("1.2.61")
}

repositories {
    mavenCentral()
}

dependencies {
    compile( "org.jetbrains.kotlin:kotlin-stdlib-common")
    compile(group = "org.jetbrains.kotlinx", name = "kotlinx-coroutines-core", version = "0.26.0")

    testCompile( "org.jetbrains.kotlin:kotlin-test-annotations-common")
    testCompile("org.jetbrains.kotlin:kotlin-test-common")
}

kotlin {
    experimental {
        coroutines = Coroutines.ENABLE
    }
}