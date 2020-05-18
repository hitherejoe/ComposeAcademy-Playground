package co.joebirch.composeplayground.resource

import co.joebirch.composeplayground.Category
import co.joebirch.composeplayground.ComposableLayout

sealed class Resource(
    override val label: String,
    override val intent: ComposableLayout? = null
) : Category(label, intent) {

    object Heading : Resource("Resource")
    object StringResource : Resource("String Resource", StringResourceView)
    object Primitive : Resource("Primitive Resource", PrimitiveResourceView)
    object Color : Resource("Color", ColorResourceView)
    object ImageResource : Resource("Image Resource", ImageResourceView)

}
