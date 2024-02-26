package com.example.plugin.common

fun String.appendIf(condition: Boolean): String = takeIf { condition }.orEmpty()