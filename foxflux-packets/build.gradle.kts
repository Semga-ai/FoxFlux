plugins {
    kotlin("jvm")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(project(":foxflux-app"))
    implementation(project(":foxflux-core"))
    implementation(project(":foxflux-protocol"))
    implementation("io.netty:netty-all:4.1.110.Final")
    implementation("com.google.inject:guice:7.0.0")
}

kotlin {
    jvmToolchain(21)
}

tasks.test {
    useJUnitPlatform()
}