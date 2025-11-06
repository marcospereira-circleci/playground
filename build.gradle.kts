import com.adarshr.gradle.testlogger.theme.ThemeType

plugins {
    application
    kotlin("jvm") version "2.2.20"
    id("io.kotest") version "6.0.4"
    id("com.adarshr.test-logger") version "4.0.0"
}

group = "com.circleci"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("io.kotest:kotest-framework-engine:6.0.4")
    testImplementation("io.kotest:kotest-runner-junit5:6.0.4")
    testImplementation("io.kotest:kotest-assertions-core:6.0.4")
    testImplementation("io.kotest:kotest-property:6.0.4")
}

tasks.test {
    useJUnitPlatform()
}

testlogger {
    theme = ThemeType.MOCHA
    showExceptions = true
    showStackTraces = true
}

kotlin {
    jvmToolchain(21)
}

application {
    mainClass = "com.circleci.MainKt"
}