plugins {
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.silaeva.booking"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.silaeva.booking"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(project(":hotels-api"))
    implementation(project(":hotels-impl"))

    implementation(project(":rooms-api"))
    implementation(project(":rooms-impl"))

    implementation(libs.android.core)
    implementation(libs.android.appcompat)
    implementation(libs.android.material)
    implementation(libs.android.activity)

    implementation(libs.cicerone)

    implementation(libs.hilt)
    kapt(libs.hilt.compiler)

    testImplementation(libs.test.junit)
    androidTestImplementation(libs.test.junit.android)
    androidTestImplementation(libs.test.espresso)
}

kapt {
    correctErrorTypes = true
}