import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "br.com.zup"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

plugins {
	kotlin("jvm") version "1.7.10"
	kotlin("plugin.spring") version "1.7.10" apply false
	id("org.springframework.boot") version "2.7.2" apply false
	id("io.spring.dependency-management") version "1.0.12.RELEASE" apply false
}

allprojects {
	configurations {
		all {
			exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
		}
	}
}

subprojects {
	apply {
		plugin("io.spring.dependency-management")
	}

	tasks.withType<KotlinCompile> {
		kotlinOptions {
			freeCompilerArgs = listOf("-Xjsr305=strict")
			jvmTarget = "17"
		}
	}
}

dependencies {
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.3")
}
