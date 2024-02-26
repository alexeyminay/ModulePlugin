package com.example.plugin.common

import com.android.tools.idea.wizard.template.RecipeExecutor
import java.io.File

fun RecipeExecutor.saveFile(absolutePath: String, relative: String, content: String) {
    val path = absolutePath.replace("/java/", "/kotlin/")
    val file = File(path).resolve(relative)
    save(content, file)
}
