plugins {
    kotlin("jvm") version "1.9.22"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("io.arrow-kt:arrow-stack:1.2.4"))
    implementation("io.arrow-kt:arrow-core")
    implementation("io.arrow-kt:arrow-fx-coroutines")
    testImplementation("io.kotest:kotest-runner-junit5:5.8.1")
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}