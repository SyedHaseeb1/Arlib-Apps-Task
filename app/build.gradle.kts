plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt") // For Hilt and annotation processing
    id("dagger.hilt.android.plugin") // Hilt plugin
}

android {
    namespace = "com.hsb.composesplash"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.hsb.composesplash"
        minSdk = 24
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.15" // Check for the latest version
    }
}

dependencies {
    // Core dependencies
    implementation("org.jetbrains.kotlin:kotlin-stdlib:2.0.10") // Kotlin standard library
    implementation("androidx.core:core-ktx:1.13.1") // Core KTX

    // Compose UI
    implementation("androidx.compose.ui:ui:1.7.3") // Compose UI
    implementation("androidx.compose.material3:material3:1.3.0") // Material3
    implementation("androidx.compose.ui:ui-tooling-preview:1.7.3") // Tooling for preview
    debugImplementation("androidx.compose.ui:ui-tooling:1.7.3") // Debug tooling

    // Lifecycle & ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.6") // ViewModel for Compose
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.6") // Lifecycle runtime
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.6") // LiveData KTX

    // Hilt
    implementation("com.google.dagger:hilt-android:2.49") // Hilt core
    kapt("com.google.dagger:hilt-android-compiler:2.48") // Hilt annotation processor
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0") // Hilt navigation

    // Retrofit (for networking)
    implementation("com.squareup.retrofit2:retrofit:2.9.0") // Retrofit
    implementation("com.squareup.retrofit2:converter-gson:2.9.0") // Gson converter

    // Coroutines (for background tasks)
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3") // Coroutines core
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3") // Coroutines Android

    // Coil (for image loading)
    implementation("io.coil-kt:coil-compose:2.4.0") // Coil for image loading

    // Compose Navigation
    implementation("androidx.navigation:navigation-compose:2.8.2") // Navigation for Compose

    // Testing (Optional)
    testImplementation("junit:junit:4.13.2") // JUnit for testing
    androidTestImplementation("androidx.test.ext:junit:1.2.1") // AndroidX JUnit
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1") // Espresso for UI testing
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.7.3") // Compose UI testing
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.7.3") // UI test manifest

    //Extensions Utils
    implementation("com.github.syedhaseeb1:extensions_hsb:1.2.2")

}
