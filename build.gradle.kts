plugins {
    id("java")
}

group = "org.slashdash"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // JOOQ
    implementation("org.jooq:jooq:3.18.6")
    runtimeOnly("org.postgresql:postgresql:42.7.1")

    // Picocli (CLI)
    implementation("info.picocli:picocli:4.7.5")
    annotationProcessor("info.picocli:picocli-codegen:4.7.5")

    // Logging
    implementation("org.slf4j:slf4j-api:2.0.7")
    implementation("ch.qos.logback:logback-classic:1.4.7")

    // Config
    implementation("com.typesafe:config:1.4.2")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
