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
  // spring
  implementation("org.springframework:spring-context:6.+")
  implementation("org.springframework:spring-jdbc:6.+")
  implementation("org.springframework.data:spring-data-jdbc:3.+")

  // kotlin
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  testImplementation(kotlin("test"))

  // lombok
  compileOnly("org.projectlombok:lombok:+")
  annotationProcessor("org.projectlombok:lombok:+")

  // mariadb driver
  implementation("org.mariadb.jdbc:mariadb-java-client:3.+")

  // others
  implementation("ch.qos.logback:logback-classic:+")
  implementation("de.svenkubiak:jBCrypt:+")
  implementation("com.google.code.gson:gson:+")
  implementation("org.json:json:+")
}

tasks.test {
  useJUnitPlatform()
}

kotlin {
  jvmToolchain(21)
}

application {
  mainClass.set("kr.mjc.jacob.basics.HelloWorldKt")
}
