plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "dev.hanasang.android.composable"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        kotlinCompilerExtensionVersion = "1.5.5"
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:${rootProject.extra["androidx_appcompat__appcompat_version"]}")
    testImplementation("junit:junit:${rootProject.extra["junit__junit_version"]}")
    androidTestImplementation("androidx.test:runner:${rootProject.extra["androidx_test__runner_version"]}")
    androidTestImplementation("androidx.test.espresso:espresso-core:${rootProject.extra["androidx_test_espresso__espresso_core_version"]}")

    //compose
    val composeBom = platform("androidx.compose:compose-bom:${rootProject.extra["androidx_compose__compose_bom_version"]}")
    implementation(composeBom)
    androidTestImplementation(composeBom)

    implementation("androidx.compose.material3:material3")
    // Android Studio Preview support
    implementation("androidx.compose.ui:ui-tooling-preview")
    debugImplementation("androidx.compose.ui:ui-tooling")
    // UI Tests
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    // Optional - Integration with activities
    implementation("androidx.activity:activity-compose:${rootProject.extra["androidx_activity__activity_compose_version"]}")
    // Optional - Integration with ViewModels
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:${rootProject.extra["android_lifecycle__lifecycle_viewmodel_compose_version"]}")
}