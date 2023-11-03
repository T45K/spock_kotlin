plugins {
    id("org.jetbrains.kotlin.jvm") version "1.9.20"
    id("groovy")

    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")

    implementation(platform("org.apache.groovy:groovy-bom:4.0.15"))
    implementation("org.apache.groovy:groovy")
    testImplementation(platform("org.spockframework:spock-bom:2.3-groovy-4.0"))
    testImplementation("org.spockframework:spock-core")
//    implementation("com.google.guava:guava:31.1-jre")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

application {
    mainClass.set("io.github.t45k.spock_kotlin.AppKt")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
