package dependencies

/**
 * Created at Mahmoud Gamal on 3/13/19
 *
 * Dependencies that will be used in build.gradle file for each module.
 */

object Dependencies {

    const val AppCompact =
        "androidx.appcompat:appcompat:${Versions.AndroidX.main}"
    const val AndroidGradlePlugin =
        "com.android.tools.build:gradle:${Versions.androidGradlePlugin}"

    val AndroidXCore = arrayOf(
        "androidx.core:core:${Versions.AndroidX.main}",
        "androidx.core:core-ktx:${Versions.AndroidX.main}"
    )

    val AndroidXLibs = arrayOf(
        // Android Annotation
        "androidx.annotation:annotation:${Versions.AndroidX.main}",

        // MultiDex
        "androidx.multidex:multidex:${Versions.AndroidX.multiDex}",

        // ConstraintLayout
        "androidx.constraintlayout:constraintlayout:${Versions.AndroidX.constraintLayout}",

        // Android Material
        "com.google.android.material:material:${Versions.AndroidX.material}"
    )

    val AndroidArchComponent = arrayOf(
        "androidx.lifecycle:lifecycle-extensions:${Versions.AndroidX.lifeCycle}",
        "androidx.lifecycle:lifecycle-reactivestreams:${Versions.AndroidX.lifeCycle}"
    )

    const val LifeCycleAnnotations =
        "androidx.lifecycle:lifecycle-compiler:${Versions.AndroidX.lifeCycle}"

    val Testing = arrayOf(
        // Android Unit Testing
        "androidx.test:runner:${Versions.Testing.runner}",
        "androidx.test.espresso:espresso-core:${Versions.Testing.espresso}",

        // Mockito
        "org.mockito:mockito-core:${Versions.Testing.mockito}",

        // JUnit
        "junit:junit:${Versions.Testing.junit}"
    )

    const val Kotlin =
        "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.Kotlin.std}"
    const val KotlinPlugin =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.Kotlin.std}"


    val RxJava = arrayOf(
        "io.reactivex.rxjava3:rxkotlin:${Versions.RX.rxKotlin}",
        "io.reactivex.rxjava3:rxjava:${Versions.RX.rxJava}"
    )
    val RxAndroid = arrayOf(
        "io.reactivex.rxjava3:rxandroid:${Versions.RX.rxAndroid}"
    )

    val Retrofit = arrayOf(
        "com.squareup.okhttp3:okhttp:${Versions.Retrofit.okHttp}",
        "com.squareup.okhttp3:logging-interceptor:${Versions.Retrofit.okHttp}",
        "com.squareup.okhttp3:okhttp-urlconnection:${Versions.Retrofit.okHttp}",
        "com.squareup.retrofit2:retrofit:${Versions.Retrofit.retrofit}",
        "com.squareup.retrofit2:adapter-rxjava3:${Versions.Retrofit.retrofit}",
        "com.squareup.retrofit2:converter-gson:${Versions.Retrofit.retrofit}"
    )


    val Picasso = arrayOf(
        "com.squareup.picasso:picasso:${Versions.PICASSO}"
    )

    val Room = arrayOf(
        "androidx.room:room-runtime:${Versions.AndroidX.lifeCycle}",
        "androidx.room:room-rxjava2:${Versions.AndroidX.lifeCycle}"
    )

    const val RoomKapt =
        "androidx.room:room-compiler:${Versions.AndroidX.lifeCycle}"

    const val Koin =
        "org.koin:koin-androidx-scope:${Versions.KOIN}"

    val KoinAndroid = arrayOf(
        Koin,
        "org.koin:koin-androidx-viewmodel:${Versions.KOIN}",
        "org.koin:koin-androidx-ext:${Versions.KOIN}"
    )

   const val Gson = "com.google.code.gson:gson:${Versions.GSON}"

    const val Ktlint = "com.pinterest:ktlint:${Versions.KTLINT}"
}