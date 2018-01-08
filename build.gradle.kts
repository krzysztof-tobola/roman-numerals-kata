import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.gradle.api.tasks.scala.ScalaCompile

buildscript {
    repositories {
        mavenCentral()
    }
}

plugins {
    kotlin("jvm") version "1.2.10"

}

apply {
    plugin("scala")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    mavenCentral()
}

dependencies {
    compile("io.vavr:vavr:0.9.0")
    compile("org.scala-lang:scala-library:2.11.1")
    compile("com.google.guava:guava:19.0")
    compile(kotlin("stdlib"))

    testCompile("org.scalatest:scalatest_2.11:3.0.0")
    testCompile("junit:junit:4.11")
    testCompile("org.hamcrest:hamcrest-all:1.3")
    testRuntime("org.pegdown:pegdown:1.1.0")
    testCompile("junit:junit:4.12")
}


tasks.withType<ScalaCompile> {
    scalaCompileOptions.forkOptions.memoryMaximumSize = "1g"
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}