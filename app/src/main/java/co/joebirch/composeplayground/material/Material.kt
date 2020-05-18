package co.joebirch.composeplayground.material

import co.joebirch.composeplayground.Category
import co.joebirch.composeplayground.ComposableLayout
import co.joebirch.composeplayground.foundation.BorderView

sealed class Material(
    override val label: String,
    override val intent: ComposableLayout? = null
): Category(label, intent) {

    object Heading: Material("Material")
    object Border: Material("Border", BorderView)
    object Fab: Material("Floating Action Button", FloatingActionButtonView)
    object Card: Material("Card", CardView)
    object Progress: Material("Progress Bar", ProgressView)
    object Slider: Material("Slider", SliderView)
    object Snackbar: Material("Snackbar", SnackbarView)
    object Switch: Material("Switch", SwitchView)
    object Checkbox: Material("Checkbox", CheckboxView)

}
