rootProject.name = "kafka-producer"
include("client", "domain", "service")

rootProject.children.forEach {
    it.projectDir = File("modules/${it.name}")
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
    }
}
