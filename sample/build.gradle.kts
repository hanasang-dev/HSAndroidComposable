plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "dev.hanasang.android.composable.sample"
    compileSdk = 34

    defaultConfig {
        applicationId = "dev.hanasang.android.composable.sample"
        minSdk = 24
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.5"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation("androidx.core:core-ktx:${rootProject.extra["androidx_core__core_ktx_version"]}")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:${rootProject.extra["android_lifecycle__lifecycle_viewmodel_compose_version"]}")
    implementation("androidx.activity:activity-compose:${rootProject.extra["androidx_activity__activity_compose_version"]}")

    // Compose BOM 적용
    val composeBom = platform("androidx.compose:compose-bom:${rootProject.extra["androidx_compose__compose_bom_version"]}")
    implementation(composeBom)
    androidTestImplementation(composeBom)

    // Compose 라이브러리
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")

    // 테스트 라이브러리
    testImplementation("junit:junit:${rootProject.extra["junit__junit_version"]}")
    androidTestImplementation("androidx.test:runner:${rootProject.extra["androidx_test__runner_version"]}")
    androidTestImplementation("androidx.test.espresso:espresso-core:${rootProject.extra["androidx_test_espresso__espresso_core_version"]}")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")

    // 디버그 의존성
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    // 프로젝트 모듈 의존성
    implementation(project(":composable"))
}