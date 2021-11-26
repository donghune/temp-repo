object Dependency {

    object Kotlin {
        const val version = "1.5.31"
        const val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2"
    }

    object Amplify {
        const val core = "com.amplifyframework:core:1.28.3"
        const val coreKotlin = "com.amplifyframework:core-kotlin:0.12.3"
        const val api = "com.amplifyframework:aws-api:1.28.3"
        const val dateSource = "com.amplifyframework:aws-datastore:1.28.3"
        const val auth = "com.amplifyframework:aws-auth-cognito:1.28.3"
    }

    object Android {
        private const val coil_version = "1.3.2"
        private const val fragment_version = "1.3.6"
        private const val core_version = "1.6.0"
        private const val appcompat_version = "1.3.1"
        private const val material_version = "1.4.0"
        private const val constraintlayout_version = "2.1.0"
        private const val activity_version = "1.3.1"

        const val coil = "io.coil-kt:coil:$coil_version"
        const val fragment = "androidx.fragment:fragment-ktx:$fragment_version"
        const val core = "androidx.core:core-ktx:$core_version"
        const val appcompat = "androidx.appcompat:appcompat:$appcompat_version"
        const val material = "com.google.android.material:material:$material_version"
        const val constraintlayout = "androidx.constraintlayout:constraintlayout:$constraintlayout_version"
        const val activity = "androidx.activity:activity-ktx:$activity_version"
        const val activityCompose = "androidx.activity:activity-compose:1.4.0"

        object Compose {
            const val version = "1.0.5"
            const val runtime = "androidx.compose.runtime:runtime:$version"
            const val ui = "androidx.compose.ui:ui:$version"
            const val foundationLayout = "androidx.compose.foundation:foundation-layout:$version"
            const val material = "androidx.compose.material:material:$version"
            const val materialIcons = "androidx.compose.material:material-icons-extended:$version"
            const val foundation = "androidx.compose.foundation:foundation:$version"
            const val animation = "androidx.compose.animation:animation:$version"
            const val uiTooling = "androidx.compose.ui:ui-tooling:$version"
            const val uiViewBinding = "androidx.compose.ui:ui-viewbinding:$version"
            const val runtimeLiveData = "androidx.compose.runtime:runtime-livedata:$version"
        }

        object Room {
            private const val version = "2.3.0"
            const val runtime = "androidx.room:room-runtime:$version"
            const val compiler = "androidx.room:room-compiler:$version"
        }

        object Lifecycle {
            private const val version = "2.4.0-alpha03"
            const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
            const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:$version"
            const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
            const val compiler = "androidx.lifecycle:lifecycle-compiler:$version"
        }

        object Navigation {
            private const val version = "2.3.5"
            const val runtime = "androidx.navigation:navigation-runtime-ktx:$version"
            const val fragment = "androidx.navigation:navigation-fragment-ktx:$version"
            const val ui = "androidx.navigation:navigation-ui-ktx:$version"
        }
    }

    object DependencyInject {
        object Hilt {
            private const val version = "2.38.1"
            const val runtime = "com.google.dagger:hilt-android:$version"
            const val compiler = "com.google.dagger:hilt-android-compiler:$version"
        }
    }
}
