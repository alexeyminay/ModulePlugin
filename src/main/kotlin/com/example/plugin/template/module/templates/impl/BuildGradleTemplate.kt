package com.example.plugin.template.module.templates.impl

import org.jetbrains.kotlin.lombok.utils.capitalize
import com.example.plugin.common.appendIf

fun getBuildGradleTemplate(
    packageName: String,
    lastPackage: String,
    hasDi: Boolean,
    moduleName: String
): String {
    val prefix = lastPackage.lowercase()

    return """
        plugins {
            id("com.android.application")
            id("org.jetbrains.kotlin.android")
            ${"id(\"kotlin-kapt\")".appendIf(hasDi)}
        }

        android {
            compileSdk = 34

            resourcePrefix = "${prefix}_"
            namespace = "$packageName"
            
            defaultConfig {
                minSdk = 24
                targetSdk = 34
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
            implementation(project(":${moduleName}-api"))
            ${"implementation(\"com.google.dagger:dagger:2.45\")".appendIf(hasDi)}
            ${"kapt(\"com.google.dagger:dagger-compiler:2.45\")".appendIf(hasDi)}
            implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
        }
    """.trimIndent()
}