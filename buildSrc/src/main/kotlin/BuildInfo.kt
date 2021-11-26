object BuildInfo {
    const val COMPILE_SDK = 31
    const val TARGET_SDK = 31
    const val MIN_SDK = 21
    const val PACKAGE_NAME = "com.dragonsnest.nest0"

    fun versionCode(): Int = buildVersionCode()
    fun versionName(): String = buildVersionName()
}
