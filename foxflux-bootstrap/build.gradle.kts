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
    implementation(project(":foxflux-infra"))
    implementation(project(":foxflux-core"))
    implementation("com.google.inject:guice:7.0.0")
}

kotlin {
    jvmToolchain(21)
}

tasks.test {
    useJUnitPlatform()
}