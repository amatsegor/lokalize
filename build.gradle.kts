buildscript {
    repositories {
        maven(url = "https://plugins.gradle.org/m2/")
    }

    allprojects {
        repositories {
            mavenCentral()
        }
    }
}

val sonar by tasks.creating(Exec::class) {
    commandLine("sonar-scanner")
}