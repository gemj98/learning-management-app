plugins {
    java
    id("org.springframework.boot") version "3.2.3"
    id("io.spring.dependency-management") version "1.1.4"
    jacoco

}

springBoot {
    mainClass.set("org.example.cmpe202_final.Cmpe202FinalApplication")
}

group = "org.example"
version = "0.0.1-SNAPSHOT"


java {
    sourceCompatibility = JavaVersion.VERSION_17
}

tasks.jar {
    manifest {
        attributes("Main-Class" to "org.example.cmpe202_final.Cmpe202FinalApplication")
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation ("org.springframework.boot:spring-boot-starter-oauth2-resource-server")
    testImplementation("org.springframework.security:spring-security-test")

    // Add-on for MongoDB
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    // JUnit Jupiter for testing
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    // Spring Boot test starters
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    // Mocking framework
    testImplementation("org.mockito:mockito-core:4.0.0")

    // Lombok to reduce repetitive code such as getters and setters
    compileOnly("org.projectlombok:lombok:1.18.32")
    annotationProcessor("org.projectlombok:lombok:1.18.32")

    testCompileOnly("org.projectlombok:lombok:1.18.32")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.32")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.test {
    finalizedBy("jacocoTestReport") // generates the coverage report after tests run
}

tasks.jacocoTestCoverageVerification {
    dependsOn("test")
    violationRules {
        rule {
            limit {
                minimum = "0.80".toBigDecimal()  // 80% coverage
            }
        }
    }
}
tasks.build {
    dependsOn(tasks.jacocoTestCoverageVerification)
}
