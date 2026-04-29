plugins {
    kotlin("jvm")
    kotlin("plugin.serialization") version "1.9.22"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("io.netty:netty-all:4.1.110.Final")
    implementation("com.google.inject:guice:7.0.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.6.2")
    implementation(project(":foxflux-app"))
    implementation(project(":foxflux-core"))
    implementation(project(":foxflux-protocol"))
    implementation("ch.qos.logback:logback-classic:1.5.6")
}

kotlin {
    jvmToolchain(21)
}

tasks.test {
    useJUnitPlatform()
}