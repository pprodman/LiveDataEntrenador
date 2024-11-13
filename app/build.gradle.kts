plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.livedata"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.livedata"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation (libs.glide)
    implementation (libs.lifecycle.livedata)
    annotationProcessor(libs.compiler)
    implementation (libs.kotlin.stdlib)
    implementation(libs.appcompat)
    implementation (libs.material.v160)
    implementation (libs.androidx.navigation.navigation.fragment.v230.x3)
    implementation (libs.androidx.navigation.ui.v230)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}