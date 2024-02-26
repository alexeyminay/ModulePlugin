package com.example.plugin.template.module.recipes

import com.android.tools.idea.wizard.template.RecipeExecutor
import com.example.plugin.common.saveFile
import com.example.plugin.template.module.templates.impl.di.*

fun RecipeExecutor.createDiFiles(
    srcPath: String,
    packageName: String,
    classPrefix: String,
    withDiSharedModule: Boolean,
) {
    val diDir = "${srcPath}/di"
    val diPackageName = "${packageName}.di"

    val componentContent = getDiComponentTemplate(
        diPackageName = diPackageName,
        classPrefix = classPrefix,
    )

    saveFile(
        absolutePath = diDir,
        relative = "${classPrefix}Component.kt",
        content = componentContent
    )

    val dependenciesContent = getDiDependenciesTemplate(
        packageName = diPackageName,
        classPrefix = classPrefix
    )

    saveFile(
        absolutePath = diDir,
        relative = "${classPrefix}ComponentDependencies.kt",
        content = dependenciesContent
    )

    val moduleContent = getDIModuleTemplate(
        diPackageName = diPackageName,
        classPrefix = classPrefix,
    )

    saveFile(
        absolutePath = diDir,
        relative = "${classPrefix}Module.kt",
        content = moduleContent
    )

    val componentViewModelContent = getComponentViewModelTemplate(
        packageName = diPackageName,
        classPrefix = classPrefix
    )

    saveFile(
        absolutePath = diDir,
        relative = "${classPrefix}ComponentViewModel.kt",
        content = componentViewModelContent
    )

    if (withDiSharedModule) {
        val sharedModuleContent = getDISharedModuleTemplate(
            packageName = diPackageName,
            classPrefix = classPrefix
        )

        saveFile(
            absolutePath = diDir,
            relative = "${classPrefix}SharedModule.kt",
            content = sharedModuleContent
        )
    }

}