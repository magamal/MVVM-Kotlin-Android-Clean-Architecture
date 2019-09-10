package dependencies

/**
 * Created at Mahmoud Gamal on 3/13/19
 *
 * Version that will be used in Dependencies kotlin file.
 */

@Suppress("unused")
object Versions {

    const val versionName = "1.0"
    const val versionCode = 1

    const val compileSdkVersion = 28
    const val minSdkVersion = 21
    const val targetSdkVersion = 28

    const val androidGradlePlugin = "3.5.0"

    object AndroidX {
        const val main = "1.1.0"
        const val material = "1.0.0"
        const val multiDex = "2.0.0"
        const val constraintLayout = "1.1.3"
        const val lifeCycle = "2.1.0"
    }

    object Testing {
        const val mockito = "2.10.0"
        const val espresso = "3.1.2-alpha01"
        const val runner = "1.1.2-alpha01"
        const val junit = "4.12"
        const val junitPlatform = "1.0.0"
    }

    object Kotlin {
        const val std = "1.3.50"
    }

    const val KOIN = "2.0.1"

    object Google {

    }

    object RX {
        const val rxAndroid = "2.0.1"
        const val rxKotlin = "2.1.0"
        const val rxJava = "2.2.12"
    }

    object Retrofit {
        const val retrofit = "2.6.1"
        const val okHttp = "4.1.1"
    }

    const val PICASSO = "2.5.0"

    const val GSON = "2.8.0"

    const val KTLINT = "0.34.2"
}