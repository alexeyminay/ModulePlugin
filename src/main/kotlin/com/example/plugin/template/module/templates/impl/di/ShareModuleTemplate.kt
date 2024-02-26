package com.example.plugin.template.module.templates.impl.di

fun getDISharedModuleTemplate(
    packageName: String,
    classPrefix: String
): String {
    return """
        package $packageName

        import dagger.Module

        @Module
        interface ${classPrefix}SharedModule {

        }
    """.trimIndent()
}