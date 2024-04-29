plugins {
  kotlin("jvm") version "1.9.23"
  application
}

group = "kr.mjc.jacob"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

dependencies {
  // kotlin, spring, database
  implementation("org.springframework:spring-context:6.+")
  implementation("org.springframework:spring-jdbc:6.+")
  implementation("org.springframework.data:spring-data-jpa:3.+")
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  testImplementation(kotlin("test"))
  implementation("org.mariadb.jdbc:mariadb-java-client:3.+")
  implementation("org.hibernate:hibernate-core:6.+")

  // lombok
  compileOnly("org.projectlombok:lombok:+")
  annotationProcessor("org.projectlombok:lombok:+")

  // others
  implementation("ch.qos.logback:logback-classic:+")
  implementation("de.svenkubiak:jBCrypt:+")
  implementation("com.google.code.gson:gson:+")
  implementation("org.json:json:+")

  // thymeleaf
  implementation("org.thymeleaf:thymeleaf:3.+")
}

tasks.test {
  useJUnitPlatform()
}

kotlin {
  jvmToolchain(21)
}

application {
  mainClass.set("kr.mjc.jacob.basicsyntax.HelloWorldKt")
}
