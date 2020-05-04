package co.joebirch.composeplayground

import android.content.Intent

private const val PACKAGE_NAME = "co.joebirch.composeplayground"

fun intentTo(className: String): Intent {
    return Intent(Intent.ACTION_VIEW).setClassName(
        PACKAGE_NAME, className)
}