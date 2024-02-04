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

  compileOnly("org.projectlombok:lombok:+")
  annotationProcessor("org.projectlombok:lombok:+")
  testImplementation(kotlin("test"))
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