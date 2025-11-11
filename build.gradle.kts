plugins {
    kotlin("jvm") version "2.2.21"
}

group = "com.ginsberg"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.assertj:assertj-core:3.27.6") {
        because("I prefer these assertions over JUnit or Hamcrest matchers")
    }
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(21)
}