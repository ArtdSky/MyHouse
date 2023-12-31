plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("io.realm.kotlin")
    id("kotlinx-serialization")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.myhouse"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.myhouse"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

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
    kotlin {
        jvmToolchain {
            (this as JavaToolchainSpec).languageVersion.set(JavaLanguageVersion.of(8))
        }
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    //material2
    implementation("com.google.accompanist:accompanist-swiperefresh:0.27.0")
    //Coil
    implementation("io.coil-kt:coil-compose:2.2.2")
    //LiveData
    implementation("androidx.compose.runtime:runtime-livedata:1.5.0")
    //Koin
    val koin_version= "3.3.3"
    implementation ("io.insert-koin:koin-androidx-compose:3.4.1")
    implementation ("io.insert-koin:koin-core:$koin_version")
    //Ktor
    val ktor_version="2.3.3"
    implementation ("io.ktor:ktor-client-android:$ktor_version")
    implementation ("io.ktor:ktor-client-core:$ktor_version")
    implementation ("io.ktor:ktor-client-logging:$ktor_version")
    implementation ("io.ktor:ktor-client-json:$ktor_version")
    implementation ("io.ktor:ktor-client-serialization:$ktor_version")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")
    implementation("io.ktor:ktor-client-content-negotiation:$ktor_version")

    //Realm
    implementation ("io.realm.kotlin:library-base:1.10.0")
    implementation ("io.realm.kotlin:library-sync:1.10.0")// If using Device Sync

    //Coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    //ViewModel & Lifecycle
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")
    //Navigation
    val nav_version = "2.6.0"
    implementation ("androidx.navigation:navigation-compose:$nav_version")

    //Default
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.activity:activity-compose:1.7.0")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}