plugins {
    `android-library`
    `kotlin-android`
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = BuildInfo.COMPILE_SDK

    defaultConfig {
        minSdk = BuildInfo.MIN_SDK
        targetSdk = BuildInfo.TARGET_SDK
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
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
    implementation(Dependency.Kotlin.coroutine)

    implementation(Dependency.DependencyInject.Hilt.runtime)
    kapt(Dependency.DependencyInject.Hilt.compiler)
}
