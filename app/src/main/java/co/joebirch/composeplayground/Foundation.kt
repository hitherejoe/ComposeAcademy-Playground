package co.joebirch.composeplayground

sealed class Foundation(override val label: String): Category(label, "SnackbarActivity") {

    object AndroidView: Foundation("AndroidView")

}