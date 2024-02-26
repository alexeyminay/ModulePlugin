package com.example.plugin.template.module.templates.api

fun getApiBuildGradleTemplate(
    packageName: String
): String {
    return """
        plugins {
            id("com.android.application")
            id("org.jetbrains.kotlin.android")
        }
        
        android {
            compileSdk = 34

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
        
        }
    """.trimIndent()
}