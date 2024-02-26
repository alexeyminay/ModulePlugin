package com.example.plugin

import com.android.tools.idea.wizard.template.Template
import com.android.tools.idea.wizard.template.WizardTemplateProvider
import com.example.plugin.template.module.moduleTemplate

class MyWizardTemplateProvider : WizardTemplateProvider() {
    override fun getTemplates(): List<Template> {
        return listOf(
            moduleTemplate
        )
    }
}
