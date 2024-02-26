package com.example.plugin.template.module.templates.impl.di

fun getDiDependenciesTemplate(
    packageName: String,
    classPrefix: String
): String {
    return """
        package $packageName

        interface ${classPrefix}ComponentDependencies {

        }
    """.trimIndent()
}