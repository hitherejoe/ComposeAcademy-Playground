package co.joebirch.composeplayground.foundation

import co.joebirch.composeplayground.Category
import co.joebirch.composeplayground.ComposableLayout

sealed class Foundation(
    override val label: String,
    override val intent: ComposableLayout? = null
): Category(label) {

    object Heading: Foundation("Foundation")
    object Border: Foundation("Border", BorderView)
    object Clickable: Foundation("Clickable", ClickableView)
    object Text: Foundation("Text", TextView)
    object TextStyle: Foundation("Text Style", TextStyleView)
    object Shape: Foundation("Shape", ShapeView)

}