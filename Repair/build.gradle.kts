plugins {
    kotlin("jvm") version "1.9.24"
    application
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "com.semihakin685.repair"
version = "0.1"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
    maven("https://repo.opencollab.dev/maven-releases")
    maven("https://repo.opencollab.dev/maven-snapshots")
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.24")
    compileOnly("com.github.PowerNukkitX:PowerNukkitX:master-SNAPSHOT")
    implementation("io.ktor:ktor-client-core:2.3.0")
    implementation("io.ktor:ktor-client-cio:2.3.0")
    implementation("io.ktor:ktor-client-content-negotiation:2.3.0")
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1")
}

application {
    mainClass.set("com.semihakin685.repair.Main")
}

tasks.named<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar>("shadowJar") {
    archiveFileName.set("Repair.jar")
    destinationDirectory.set(layout.buildDirectory.dir("libs"))
    mergeServiceFiles()
    manifest {
        attributes(mapOf("Main-Class" to "com.semihakin685.repair.Main"))
    }
}

tasks.build {
    dependsOn("shadowJar")
}