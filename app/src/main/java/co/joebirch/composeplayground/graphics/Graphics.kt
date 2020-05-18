package co.joebirch.composeplayground.graphics

import co.joebirch.composeplayground.Category
import co.joebirch.composeplayground.ComposableLayout

sealed class Graphics(
    override val label: String,
    override val intent: ComposableLayout? = null
): Category(label) {

    object Heading: Graphics("Graphics")
    object Color: Graphics("Color", ColorView)

}