plugins {
    `kotlin-dsl`
}

kotlinDslPluginOptions.experimentalWarning.set(false)

repositories {
    google()
    maven("https://plugins.gradle.org/m2/")
    mavenCentral()
}

object Plugins {
    const val AGP = "7.0.0"
    const val KOTLIN = "1.5.31"
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${Plugins.KOTLIN}")
    implementation("com.android.tools.build:gradle:${Plugins.AGP}")
    implementation("com.amplifyframework:amplify-tools-gradle-plugin:1.0.2")
    implementation("com.amazonaws:aws-android-sdk-appsync-gradle-plugin:2.6.28")
}
