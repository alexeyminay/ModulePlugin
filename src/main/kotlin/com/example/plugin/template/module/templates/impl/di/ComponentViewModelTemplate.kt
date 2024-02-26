package com.example.plugin.template.module.templates.impl.di

fun getComponentViewModelTemplate(
    packageName: String,
    classPrefix: String
): String {
    return """
        package $packageName

        import androidx.lifecycle.ViewModel

        class ${classPrefix}ComponentViewModel : ViewModel() {

            val component: ${classPrefix}Component by lazy {
                Dagger${classPrefix}Component.factory().create(
                    requireNotNull(${classPrefix}ComponentDependenciesProvider.componentDependencies),
                )
            }

            override fun onCleared() {
                ${classPrefix}ComponentDependenciesProvider.componentDependencies = null
            }
        }

        object ${classPrefix}ComponentDependenciesProvider {
            var componentDependencies: ${classPrefix}ComponentDependencies? = null
        }
    """.trimIndent()
}