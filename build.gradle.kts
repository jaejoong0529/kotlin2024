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
  implementation("ch.qos.logback:logback-classic:+")
  implementation("org.mariadb.jdbc:mariadb-java-client:+")
  implementation("org.springframework:spring-context:+")
  implementation("org.springframework:spring-jdbc:+")
  testImplementation(kotlin("test"))

  // bcrypt
  implementation("de.svenkubiak:jBCrypt:+")

  // reflect
  implementation("org.jetbrains.kotlin:kotlin-reflect")
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