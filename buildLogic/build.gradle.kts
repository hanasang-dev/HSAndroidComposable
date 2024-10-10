plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation("com.android.tools.build:gradle:${rootProject.extra["com_android_tools_build__gradle_version"]}")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${rootProject.extra["org_jetbrains_kotlin__kotlin_gradle_plugin"]}")
}