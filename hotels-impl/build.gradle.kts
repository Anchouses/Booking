plugins {
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.silaeva.hotels_impl"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildFeatures {
        compose = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.4"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(project(":hotels-api"))
    implementation(project(":rooms-api"))
    implementation(project(":common-ui"))

    val composeBom = platform(libs.android.compose.bom)
    implementation(composeBom)
    androidTestImplementation(composeBom)
    implementation(libs.android.compose.material3)
    implementation(libs.android.compose.preview)

    implementation(libs.android.core)
    implementation(libs.android.appcompat)
    implementation(libs.android.material)
    implementation(libs.android.fragment)

    implementation ("androidx.room:room-coroutines:2.1.0-alpha04")

    implementation(libs.cicerone)

    implementation(libs.hilt)
    kapt(libs.hilt.compiler)

    implementation (libs.retrofit)
    implementation (libs.converter.scalars)
    implementation (libs.converter.gson)

    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)

    testImplementation(libs.test.junit)
    androidTestImplementation(libs.test.junit.android)
    androidTestImplementation(libs.test.espresso)
}

kapt {
    correctErrorTypes = true
}