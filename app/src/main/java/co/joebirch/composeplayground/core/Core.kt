package co.joebirch.composeplayground.core

import co.joebirch.composeplayground.Category
import co.joebirch.composeplayground.ComposableLayout
import co.joebirch.composeplayground.core.GestureView

sealed class Core(
    override val label: String,
    override val intent: ComposableLayout? = null
) : Category(label, intent) {

    object Heading : Core("Core")
    object Gesture : Core("Gesture", GestureView)

}
