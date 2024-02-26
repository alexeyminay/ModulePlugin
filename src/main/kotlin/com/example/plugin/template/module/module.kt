package com.example.plugin.template.module

import com.android.tools.idea.wizard.template.*
import com.example.plugin.template.module.recipes.createModuleFiles

val moduleTemplate
    get() = template {
        name = "Фиче модули -api и -impl"
        minApi = 21
        description = "Создание фичемодулей"

        category = Category.Folder
        formFactor = FormFactor.Mobile
        useGenericAndroidTests = false
        useGenericLocalTests = false

        screens = listOf(
            WizardUiContext.ActivityGallery,
            WizardUiContext.MenuEntry,
            WizardUiContext.NewProject,
            WizardUiContext.NewModule
        )

        val classPrefix = stringParameter {
            name = "Введите префикс для классов модуля"
            default = ""
        }

        val withDiFilesParam = booleanParameter {
            name = "Добавить классы di"
            default = true
        }

        val withDiSharedModuleParam = booleanParameter {
            name = "Создать SharedModule di"
            default = true
            enabled = { withDiFilesParam.value }
        }

        val withMediatorParam = booleanParameter {
            name = "Содать медиатор"
            default = true
        }

        val withFragmentFlow = booleanParameter {
            name = "Добавить фрагмент флоу"
            default = true
        }

        val withNavigation = booleanParameter {
            name = "Добавить файлы навигации"
            default = true
        }

        val withDataLayer = booleanParameter {
            name = "Создать классы репозитория и api"
            default = true
        }

        widgets(
            TextFieldWidget(classPrefix),
            Separator,
            CheckBoxWidget(withDiFilesParam),
            CheckBoxWidget(withDiSharedModuleParam),
            CheckBoxWidget(withFragmentFlow),
            CheckBoxWidget(withMediatorParam),
            CheckBoxWidget(withNavigation),
            CheckBoxWidget(withDataLayer),
        )

        recipe = { data: TemplateData ->
            createModuleFiles(
                moduleData = data as ModuleTemplateData,
                withDiFiles = withDiFilesParam.value,
                classPrefix = classPrefix.value,
                withDiSharedModule = withDiSharedModuleParam.value,
            )
        }
    }