plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.example.relearning3"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.relearning3"
        minSdk = 29
        targetSdk = 34
        versionCode = 1
        versionName = "0.9-beta"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        kotlinCompilerExtensionVersion = "1.5.4" //154 with 1.9.20
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.1")
    implementation("androidx.work:work-runtime-ktx:2.9.0-rc01")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //compose
    implementation(platform("androidx.compose:compose-bom:2023.10.01"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.10.01"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    //Compose extras
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")
    implementation("androidx.compose.material:material-icons-extended")
    implementation("com.google.accompanist:accompanist-swiperefresh:0.28.0")
/*
    //Ktor for internet and maybe okhttp but all maybe doesn't work with moshi, idk
    implementation("io.ktor:ktor-client-core:2.3.6")
    //internet engine
    implementation("io.ktor:ktor-client-okhttp:2.3.6")
    //long ass serialization, idk why so many (ig this replaces moshi?)
    implementation("io.ktor:ktor-client-serialization:2.3.6")
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.6")
    //logging
    implementation("io.ktor:ktor-client-logging:2.3.6")
*/
    //Compose new destinations
    implementation("io.github.raamcosta.compose-destinations:core:1.9.55")
    ksp("io.github.raamcosta.compose-destinations:ksp:1.9.55")
/*
    //Moshi
    ksp("com.squareup.moshi:moshi-kotlin-codegen:1.15.0")
*/
    //Dagger-Hilt
    implementation("com.google.dagger:hilt-android:2.48.1")
    ksp("com.google.dagger:hilt-android-compiler:2.48.1")
    //Hilt-additional
    implementation("androidx.hilt:hilt-work:1.1.0") //notifs/services
    implementation("androidx.hilt:hilt-common:1.1.0") //idk
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0")
    ksp("androidx.hilt:hilt-compiler:1.1.0")
    ksp("com.google.dagger:hilt-compiler:2.48.1") //this exists too, using both makes moshi not whine
    //https://github.com/square/moshi/discussions/1752

    // Room
    implementation("androidx.room:room-runtime:2.6.0")
    ksp("androidx.room:room-compiler:2.6.0")

    // Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:2.6.0")
    // To use Kotlin Symbol Processing (KSP)
    ksp("androidx.room:room-compiler:2.6.0")
}