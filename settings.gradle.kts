plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "Engine"
include("foxflux-core")
include("foxflux-app")
include("foxflux-infra")
include("foxflux-bootstrap")