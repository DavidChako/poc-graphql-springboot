plugins {
    kotlin("jvm") version "2.1.10"
    kotlin("plugin.spring") version "2.1.10"

    id("org.springframework.boot") version "3.4.3"
    id("io.spring.dependency-management") version "1.1.7"

    groovy // Spock
}

group = "com.icosahedron"
version = "1.0.0"

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-graphql")
    implementation("org.springframework.boot:spring-boot-starter-web")

//    implementation("com.icosahedron:poc-datomic:1.0.0")
    implementation("ch.qos.logback:logback-classic:1.5.17")

//    implementation("com.datomic:peer:1.0.7277")

    val spockVersion = "2.4-M5-groovy-4.0"
    testImplementation(platform("org.spockframework:spock-bom:$spockVersion"))
    testImplementation("org.spockframework:spock-core:$spockVersion")
    testImplementation("org.spockframework:spock-spring:$spockVersion")
    testImplementation("org.springframework:spring-test:7.0.0-M3")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()

    testLogging {
        events("passed", "skipped", "failed")
    }
}

kotlin {
    jvmToolchain(19)

    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}
