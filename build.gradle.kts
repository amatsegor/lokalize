buildscript {
    repositories {
        maven(url = "https://plugins.gradle.org/m2/")
        maven(url = "https://dl.bintray.com/kotlin/kotlin-dev/")
    }

    allprojects {
        repositories {
            mavenCentral()
            maven(url = "https://dl.bintray.com/kotlin/kotlin-dev/")
        }
    }
}

val sonar by tasks.creating(Exec::class) {
    commandLine("sonar-scanner")
}