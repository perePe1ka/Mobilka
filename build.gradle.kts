buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath (libs.gradle.v814)
        classpath (libs.androidx.navigation.safe.args.gradle.plugin)
        classpath (libs.kotlin.gradle.plugin)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}
