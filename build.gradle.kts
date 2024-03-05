plugins {
  kotlin("jvm") version "1.9.22"
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
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:+")
  testImplementation(kotlin("test"))

  // apache
  implementation("org.apache.httpcomponents.client5:httpclient5:5.3")
  implementation("org.apache.httpcomponents.client5:httpclient5-fluent:5.3")
  implementation("commons-io:commons-io:2.+")

  // others
  implementation("ch.qos.logback:logback-classic:+")
  implementation("org.mariadb.jdbc:mariadb-java-client:+")
  implementation("de.svenkubiak:jBCrypt:+")
  implementation("com.fasterxml.jackson.core:jackson-databind:+")
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

