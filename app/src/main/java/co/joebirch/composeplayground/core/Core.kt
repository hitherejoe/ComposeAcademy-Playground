package co.joebirch.composeplayground.core

import co.joebirch.composeplayground.Category
import co.joebirch.composeplayground.ComposableLayout
import co.joebirch.composeplayground.ui.draw.OpacityView
import co.joebirch.composeplayground.window.DialogView
import co.joebirch.composeplayground.window.PopupView

sealed class Core(
    override val label: String,
    override val intent: ComposableLayout? = null
) : Category(label, intent) {

    object Heading : Core("Core")
    object Gesture : Core("Gesture", GestureView)
    object Opacity : Core("Opacity", OpacityView)
    object Popup : Core("Popup", PopupView)
    object Dialog : Core("dialog", DialogView)
    object Shadow : Core("Shadow", ShadowView)

}
