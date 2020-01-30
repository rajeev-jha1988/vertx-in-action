plugins {
  java
  application
}

repositories {
  mavenCentral()
}

dependencies {
  implementation("io.vertx:vertx-core:4.0.0-milestone4")
  implementation("io.vertx:vertx-codegen:4.0.0-milestone4")
  implementation("io.vertx:vertx-service-proxy:4.0.0-milestone4")

  annotationProcessor("io.vertx:vertx-service-proxy:4.0.0-milestone4")
  annotationProcessor("io.vertx:vertx-codegen:4.0.0-milestone4:processor")

  implementation("io.vertx:vertx-rx-java2:4.0.0-milestone4")
  annotationProcessor("io.vertx:vertx-rx-java2-gen:4.0.0-milestone4")

  testCompile("org.junit.jupiter:junit-jupiter-api:5.5.1")
  testCompile("io.vertx:vertx-junit5:4.0.0-milestone4")
  testCompile("org.assertj:assertj-core:3.11.1")

  testRuntime("org.junit.jupiter:junit-jupiter-engine:5.5.1")
}

tasks.named<Test>("test") {
  useJUnitPlatform()
}

tasks.getByName<JavaCompile>("compileJava") {
  options.annotationProcessorGeneratedSourcesDirectory = File("$projectDir/src/main/generated")
}

java {
  sourceCompatibility = JavaVersion.VERSION_1_8
}

application {
  mainClassName = "chapter6.RxProxyClient"
}

tasks.wrapper {
  gradleVersion = "5.5.1"
}
