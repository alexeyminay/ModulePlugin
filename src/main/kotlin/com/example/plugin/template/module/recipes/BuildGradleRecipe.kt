package com.example.plugin.template.module.recipes

import com.android.tools.idea.wizard.template.RecipeExecutor
import com.example.plugin.common.saveFile
import com.example.plugin.template.module.templates.api.getApiBuildGradleTemplate
import com.example.plugin.template.module.templates.impl.getBuildGradleTemplate

fun RecipeExecutor.createBuildGradle(
    implRootPath: String,
    apiRootPath: String,
    lastPackage: String,
    moduleName: String,
    hasDi: Boolean,
    packageName: String
) {
    saveFile(
        absolutePath = implRootPath,
        relative = "build.gradle.kts",
        content = getBuildGradleTemplate(
            lastPackage = lastPackage,
            hasDi = hasDi,
            moduleName = moduleName,
            packageName = packageName
        )
    )

    saveFile(
        absolutePath = apiRootPath,
        relative = "build.gradle.kts",
        content = getApiBuildGradleTemplate(
            packageName = packageName
        )
    )
}