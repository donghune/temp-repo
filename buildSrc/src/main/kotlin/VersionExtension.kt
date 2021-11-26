import java.io.File
import java.io.FileInputStream
import java.util.Properties

private const val MAJOR_VALUE = 100000000
private const val MINOR_VALUE = 10000
private const val PATCH_VALUE = 1

private fun getVersionProperty(): Properties {
    val versionProperty = Properties()
    val inputStream = FileInputStream(File("./", "version.properties"))
    versionProperty.load(inputStream)
    return versionProperty
}

fun buildVersionName(): String {
    val versionProperty = getVersionProperty()
    val appVersion = versionProperty["AppVersion"]
    return "$appVersion"
}

fun buildVersionCode(): Int {
    val versionProperty = getVersionProperty()
    val appVersion = versionProperty["AppVersion"].toString().split(".")

    val major = (appVersion[0].toInt()) * MAJOR_VALUE
    val minor = (appVersion[1].toInt()) * MINOR_VALUE
    val patch = (appVersion[2].toInt()) * PATCH_VALUE

    return major + minor + patch
}
