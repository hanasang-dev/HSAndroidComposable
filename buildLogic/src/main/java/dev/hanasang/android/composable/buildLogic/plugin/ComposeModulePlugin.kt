package dev.hanasang.android.composable.buildLogic.plugin

import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.extra

class ComposeModulePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        // 루트 프로젝트의 ext에서 값을 가져옴
        val composeCompilerVersion =
            target.rootProject.extra["androidx_compose__compose_bom_version"] as String

        // Compose 관련 설정만 적용
        target.extensions.configure<LibraryExtension> {
            buildFeatures {
                compose = true
            }

            composeOptions {
                kotlinCompilerExtensionVersion = composeCompilerVersion // 루트 프로젝트의 ext 값을 사용
            }
        }
    }
}