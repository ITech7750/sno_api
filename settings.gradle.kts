plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "sno-rest-api-microservice"

includeBuild("eureka-server")
includeBuild("gateway")
includeBuild("user-service")
includeBuild("video-stream-service")
includeBuild("lecture-service")
includeBuild("auth-service")
