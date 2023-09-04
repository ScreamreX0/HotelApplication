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

rootProject.name = "HotelApplication"
include(":app")
include(":features")
include(":features:hotel")
include(":features:room")
include(":features:booking")
include(":features:paid")
include(":core")
include(":data")
