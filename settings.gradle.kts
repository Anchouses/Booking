pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Booking"
include(":app")

include(":common-ui")

include(":hotels-impl")
include(":hotels-api")

include(":rooms-api")
include(":rooms-impl")

include(":rooms-api")
include(":rooms-impl")

include(":rooms-api")
include(":rooms-impl")
