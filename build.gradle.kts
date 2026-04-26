plugins {
    kotlin("jvm") version "2.2.21"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.netty:netty-all:4.1.110.Final")
}

kotlin {
    jvmToolchain(21)
}

tasks.test {
    useJUnitPlatform()
}