plugins {
    kotlin("jvm") version "2.0.20"
}

group = "com.arjunjadeja"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    google()
}

dependencies {
    implementation("androidx.compose.foundation:foundation:1.7.2")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}