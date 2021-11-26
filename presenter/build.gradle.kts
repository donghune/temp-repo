import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

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

    kotlinOptions {
        jvmTarget = "1.8"
        useIR = true
    }

    buildFeatures {
        compose = true
        viewBinding = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Dependency.Android.Compose.version
        kotlinCompilerVersion = Dependency.Kotlin.version
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(Dependency.Android.core)
    implementation(Dependency.Android.appcompat)
    implementation(Dependency.Android.material)
    implementation(Dependency.Android.constraintlayout)

    implementation(Dependency.Android.activityCompose)
    implementation(Dependency.Android.Compose.runtime)
    implementation(Dependency.Android.Compose.ui)
    implementation(Dependency.Android.Compose.foundationLayout)
    implementation(Dependency.Android.Compose.material)
    implementation(Dependency.Android.Compose.materialIcons)
    implementation(Dependency.Android.Compose.foundation)
    implementation(Dependency.Android.Compose.animation)
    implementation(Dependency.Android.Compose.uiViewBinding)
    implementation(Dependency.Android.Compose.uiTooling)
    implementation(Dependency.Android.Compose.runtimeLiveData)

    implementation(Dependency.Kotlin.coroutine)

    implementation(Dependency.DependencyInject.Hilt.runtime)
    kapt(Dependency.DependencyInject.Hilt.compiler)

    implementation(project(mapOf("path" to ":domain")))
}
