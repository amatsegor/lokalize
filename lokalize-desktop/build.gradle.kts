import org.jetbrains.kotlin.gradle.dsl.Coroutines
import org.jetbrains.kotlin.gradle.dsl.KotlinCompile
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmCompile
import kotlin.collections.mapOf

buildscript {
    repositories {
        flatDir { dir("$projectDir/lib") }
    }
    dependencies {
        classpath(":proguard:")
    }
}

plugins {
    id("kotlin-platform-jvm") version ("1.2.61")
    id("org.jetbrains.kotlin.jvm") version ("1.2.61")
}

dependencies {
    expectedBy(project(":lokalize-common"))

    compile("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    compile("org.jetbrains.kotlinx:kotlinx-coroutines-core:0.26.0")

    compile("com.google.api-client:google-api-client:1.25.0")
    compile("com.google.oauth-client:google-oauth-client-jetty:1.25.0")
    compile("com.google.apis:google-api-services-sheets:v4-rev542-1.25.0")
    compile("com.google.code.gson:gson:2.8.5")

    compile("io.github.microutils:kotlin-logging:1.6.10")
    compile("org.slf4j:slf4j-simple:1.7.25")

    testCompile("junit:junit:4.12")
    testCompile("org.jetbrains.kotlin:kotlin-test")
    testCompile("org.jetbrains.kotlin:kotlin-test-junit")
}

val jar = tasks.named<Jar>("jar") {
    manifest { attributes(mapOf("Main-Class" to "lokalize.MainKt")) }

    from(configurations.compile.files.map { if (it.isDirectory) it else zipTree(it) })

    baseName = "lokalizegs-desktop"
}

val proguardJar by tasks.creating(proguard.gradle.ProGuardTask::class.java) {
    dependsOn(jar)
    configuration(file("proguard-rules.pro"))
}

java.sourceCompatibility = JavaVersion.VERSION_1_8

kotlin {
    experimental {
        coroutines = Coroutines.ENABLE
    }
}