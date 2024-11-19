buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        // Updated classpaths for Gradle, Kotlin, and Safe Args plugins
        classpath("com.android.tools.build:gradle:8.1.4") // Match with the latest Gradle version
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.5.3")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.10")
    }
}

allprojects {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
