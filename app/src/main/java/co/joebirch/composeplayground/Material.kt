package co.joebirch.composeplayground

import androidx.compose.Composable

sealed class Material(override val label: String, @Composable override val intent: String): Category(label, intent) {

    object Snackbar: Material("Snackbar", "SnackbarActivity")

    object AlertDialog: Material("Alert Dialog", "SnackbarActivity")

}

class MaterialHeading : Category("Material", "SnackbarActivity", isHeading = true)