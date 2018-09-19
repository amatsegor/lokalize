import com.moowork.gradle.node.npm.NpmTask
import com.moowork.gradle.node.task.NodeTask
import org.jetbrains.kotlin.contracts.model.structure.UNKNOWN_COMPUTATION.type
import org.jetbrains.kotlin.gradle.dsl.Coroutines
import org.jetbrains.kotlin.gradle.tasks.Kotlin2JsCompile
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import kotlin.collections.listOf

buildscript {
    repositories {
        maven(url = "https://plugins.gradle.org/m2/")
    }
    dependencies {
        classpath("com.moowork.gradle:gradle-node-plugin:1.2.0")
    }
}

plugins {
    id("kotlin-platform-js") version ("1.2.61")
    id("kotlin2js") version ("1.2.61")
    id("com.moowork.node") version ("1.2.0")
}

dependencies {
    expectedBy(project(":lokalize-common"))

    compile("org.jetbrains.kotlin:kotlin-stdlib-js")

    compile("org.jetbrains.kotlinx:kotlinx-coroutines-core-js:0.26.0")
    testCompile("org.jetbrains.kotlin:kotlin-test-js")
}

kotlin {
    experimental {
        coroutines = Coroutines.ENABLE
    }
}

node {
    download = true
}

val compileKotlin2Js = tasks.getByName("compileKotlin2Js", Kotlin2JsCompile::class).apply {
    kotlinOptions.moduleKind = "commonjs"
}

val compileTestKotlin2Js = tasks.getByName("compileTestKotlin2Js", Kotlin2JsCompile::class).apply {
    kotlinOptions.moduleKind = "commonjs"
}

val populateNodeModules by tasks.creating(Copy::class) {
    dependsOn(compileKotlin2Js)

    from(compileKotlin2Js.destinationDir)

    configurations.testCompile.forEach {
        from(zipTree (it.absolutePath).matching { include("*.js") })
    }

    into("$buildDir/node_modules")
}

val installJest by tasks.creating(NpmTask::class) {
    setArgs(listOf("install", "jest"))
}

val runJest by tasks.creating(NodeTask::class) {
    setScript(file("node_modules/jest/bin/jest.js"))
    setArgs(listOf(projectDir.toURI().relativize(compileTestKotlin2Js.outputFile.toURI())))
}