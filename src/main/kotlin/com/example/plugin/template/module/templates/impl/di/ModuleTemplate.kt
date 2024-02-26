package com.example.plugin.template.module.templates.impl.di

fun getDIModuleTemplate(
    diPackageName: String,
    classPrefix: String,
): String {
    return """
        package $diPackageName

        import dagger.Binds
        import dagger.Module
        
        @Module
        interface ${classPrefix}Module {

        }
    """.trimIndent()
}