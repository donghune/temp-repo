import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    `android-application`
    `kotlin-android`
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = BuildInfo.COMPILE_SDK

    defaultConfig {
        applicationId = BuildInfo.PACKAGE_NAME
        minSdk = BuildInfo.MIN_SDK
        targetSdk = BuildInfo.TARGET_SDK
        versionCode = BuildInfo.versionCode()
        versionName = BuildInfo.versionName()
        setProperty("archivesBaseName", "${rootProject.name}-${BuildInfo.versionName()}(${BuildInfo.versionCode()})")

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            versionNameSuffix = "release"
        }
        debug {
            versionNameSuffix = "debug"
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(Dependency.Android.core)
    implementation(Dependency.Android.appcompat)
    implementation(Dependency.Android.material)
    implementation(Dependency.Android.constraintlayout)

    implementation(Dependency.Kotlin.coroutine)

    implementation(Dependency.DependencyInject.Hilt.runtime)
    kapt(Dependency.DependencyInject.Hilt.compiler)

    implementation(project(mapOf("path" to ":presenter")))
    implementation(project(mapOf("path" to ":data")))
    implementation(project(mapOf("path" to ":domain")))
}
