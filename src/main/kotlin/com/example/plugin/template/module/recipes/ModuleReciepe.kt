package com.example.plugin.template.module.recipes

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import org.jetbrains.kotlin.incremental.deleteRecursivelyOrThrow
import org.jetbrains.kotlin.konan.file.File

fun RecipeExecutor.createModuleFiles(
    moduleData: ModuleTemplateData,
    withDiFiles: Boolean,
    classPrefix: String,
    withDiSharedModule: Boolean,
) {
    val moduleName = moduleData.name.split(":").last()

    val packageName = moduleData.packageName
    val lastPackage = packageName.split(".").last()
    val apiPackage = packageName.replace(lastPackage, "api.$lastPackage")

    val apiRootPath = moduleData.rootDir.absolutePath
        .replaceFirst(moduleName, "$moduleName-api")
    val apiSrcPath = moduleData.srcDir.absolutePath.replaceFirst(moduleName, "$moduleName-api")
        .replace("feature${File.separator}$lastPackage", "feature${File.separator}api${File.separator}$lastPackage")
        .replace("java", "kotlin")

    val implRootPath = moduleData.rootDir.absolutePath
        .replaceFirst(moduleName, "$moduleName-impl")
    val implSrcPath = moduleData.srcDir.absolutePath
        .replace("java", "kotlin")
        .replaceFirst(moduleName, "$moduleName-impl")

    moduleData.removeFiles()

    println(moduleData.projectTemplateData)

    this.addIncludeToSettings("$moduleName-api")
    this.addIncludeToSettings("$moduleName-impl")

    createBuildGradle(
        implRootPath = implRootPath,
        apiRootPath = apiRootPath,
        lastPackage = lastPackage,
        hasDi = withDiFiles,
        moduleName = moduleName,
        packageName = packageName
    )

    if (withDiFiles) {
        createDiFiles(
            srcPath = implSrcPath,
            packageName = moduleData.packageName,
            classPrefix = classPrefix,
            withDiSharedModule = withDiSharedModule,
        )
    }
}

private fun ModuleTemplateData.removeFiles() {
    resDir.deleteRecursivelyOrThrow()
    manifestDir.deleteRecursivelyOrThrow()
    rootDir.resolve("build.gradle").delete()
    rootDir.resolve("build.gradle.kts").delete()
    rootDir.resolve("proguard-rules.pro").delete()
    rootDir.resolve("libs").delete()
    rootDir.deleteRecursivelyOrThrow()
}