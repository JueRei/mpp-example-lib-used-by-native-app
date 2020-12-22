import org.jetbrains.kotlin.ir.backend.js.compile

plugins {
    kotlin("multiplatform") version "1.4.21"
    //application
}

group = "de.rdvsb"
version = "1.0-SNAPSHOT"

repositories {
    mavenLocal()
    mavenCentral()
}


kotlin {
    val hostOs = System.getProperty("os.name")
    val isMingwX64 = hostOs.startsWith("Windows")
    val nativeTarget = when {
        hostOs == "Mac OS X" -> macosX64("native")
        hostOs == "Linux" -> linuxX64("native")
        isMingwX64 -> mingwX64("native")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }

    nativeTarget.apply {
        binaries {
            executable {
                entryPoint = "main"
            }
        }
    }
    sourceSets {
        val nativeMain by getting {
            dependencies {
                api ("de.rdvsb:mpp-example-lib:1.0-SNAPSHOT")
            }
        }
        val nativeTest by getting {
            dependencies {
                api ("de.rdvsb:mpp-example-lib:1.0-SNAPSHOT")
            }
        }
    }
}
