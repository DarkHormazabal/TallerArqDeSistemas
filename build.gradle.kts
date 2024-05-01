plugins {
    id("java")
    id("io.freefair.lombok' version '6.2.0'")// Agrega el plugin de Lombok
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    compileOnly("org.projectlombok:lombok:1.18.20'")
}

tasks.test {
    useJUnitPlatform()
}