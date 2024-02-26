package com.example.plugin.template.module.templates.impl.di

fun getDiComponentTemplate(
    diPackageName: String,
    classPrefix: String,
): String {
    return """
    package $diPackageName
    
    import dagger.Component
    
    @Component(
        dependencies = [${classPrefix}ComponentDependencies::class], 
        modules = [${classPrefix}Module::class]
    )
    interface ${classPrefix}Component {
        
        @Component.Factory
        interface Factory {
            fun create(
                dependencies: ${classPrefix}ComponentDependencies,
            ): ${classPrefix}Component
        }
        
    }
""".trimIndent()
}