package co.joebirch.composeplayground.material

import co.joebirch.composeplayground.Category
import co.joebirch.composeplayground.ComposableLayout
import co.joebirch.composeplayground.foundation.BorderView

sealed class Material(
    override val label: String,
    override val intent: ComposableLayout? = null
): Category(label, intent) {

    object Heading: Material("Material")
    object AlertDialog: Material("Alert Dialog", AlertDialogView)
    object Border: Material("Border", BorderView)
    object BottomAppBar: Material("BottomAppBar", BottomAppBarView)
    object Button: Material("Button", ButtonView)
    object Divider: Material("Divider", DividerView)
    object Fab: Material("Floating Action Button", FloatingActionButtonView)
    object Card: Material("Card", CardView)
    object Checkbox: Material("Checkbox", CheckboxView)
    object Progress: Material("Progress Bar", ProgressView)
    object RadioButton: Material("Radio Button", RadioButtonView)
    object Scaffold: Material("Scaffold", ScaffoldView)
    object Slider: Material("Slider", SliderView)
    object Snackbar: Material("Snackbar", SnackbarView)
    object Switch: Material("Switch", SwitchView)
    object TabRow: Material("Tab Row", TabBarView)
    object TopAppBar: Material("Top App Bar", TopAppBarView)
    object TriStateRadioButton: Material("Tri-state Radio Button", TriStateRadioButtonView)

}
