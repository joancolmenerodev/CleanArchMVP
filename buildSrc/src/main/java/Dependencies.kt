object Android {
    const val applicationId = "com.joancolmenerodev.cleanarch"
    const val minSdkVersion = 19
    const val targetSdkVersion = 28
    const val compileSdkVersion = 28
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
}

object Kotlin {
    const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlinVersion}"
}

object Modules {
    const val data = ":data"
    const val domain = ":domain"
    const val app = ":app"
}

object TestLibraries {
    const val jUnit = "junit:junit:${Versions.jUnitVersion}"
    const val mockitoCore = "org.mockito:mockito-core:${Versions.mockitoCoreVersion}"
    const val testRunner = "androidx.test:runner:${Versions.testRunnerVersion}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCoreVersion}"
}

object Libraries {
    const val lottie = "com.airbnb.android:lottie:${Versions.lottieVersion}"
    const val glide = "com.github.bumptech.glide:glide:${Versions.glideVersion}"


    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val retrofitGsonConverter =
        "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}"
    const val retrofitLoggingInterceptors =
        "com.squareup.okhttp3:logging-interceptor:${Versions.okHttpVersion}"

    const val gson = "com.google.code.gson:gson:${Versions.gsonVersion}"

    const val coroutines =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesCoreVersion}"

    const val kodeinGeneric = "org.kodein.di:kodein-di-generic-jvm:${Versions.kodeinVersion}"
    const val kodeinAndroidSupport =
        "org.kodein.di:kodein-di-framework-android-support:${Versions.kodeinCoreVersion}"
}

object SupportLibraries {
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appCompatLibraryVersion}"
    const val design = "com.google.android.material:material:${Versions.materialDesignVersion}"
    const val cardview = "androidx.cardview:cardview:${Versions.cardViewVersion}"
    const val recyclerview = "androidx.recyclerview:recyclerview:${Versions.recyclerViewVersion}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}"
}

object Versions {
    const val kotlinVersion = "1.3.50"
    const val gradleVersion = "3.4.2"
    const val buildToolsVersion = "28.0.3"
    const val androidSupportLibVersion = "1.1.0"
    const val constraintLayoutVersion = "1.1.3"
    const val jUnitVersion = "4.12"
    const val okHttpVersion = "4.2.1"
    const val appCompatLibraryVersion = "1.1.0"
    const val materialDesignVersion = "1.0.0"
    const val cardViewVersion = "1.0.0"
    const val recyclerViewVersion = "1.0.0"
    const val coroutinesCoreVersion = "1.3.2"
    const val supportLibraryVersion = "28.0.0"
    const val espressoCoreVersion = "3.2.0"
    const val retrofitVersion = "2.6.0"
    const val gsonVersion = "2.8.5"
    const val testRunnerVersion = "1.2.0"
    const val testRulesVersion = "1.0.2"
    const val glideVersion = "4.9.0"
    const val kodeinVersion = "6.2.1"
    const val kodeinCoreVersion = "6.2.1"
    const val lottieVersion = "2.8.0"
    const val mockitoCoreVersion = "2.22.0"
    const val mockitoInlineVersion = "2.22.0"
}



