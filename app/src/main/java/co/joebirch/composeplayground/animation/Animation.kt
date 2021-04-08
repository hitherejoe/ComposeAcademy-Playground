package co.joebirch.composeplayground.animation

import co.joebirch.composeplayground.Category
import co.joebirch.composeplayground.ComposableLayout

sealed class Animation(
    override val label: String,
    override val intent: ComposableLayout? = null
) : Category(label, intent) {

    object Heading : Animation("Animation")
    object Crossfade : Animation("Crossfade", CrossfadeAnimationView)
    object SingleColor : Animation("Single Color Value", SingleAnimationColorView)
    object SingleFloat : Animation("Single Float Value", SingleAnimationFloatView)
    object Transitions : Animation("Transitions demos", TransitionDemoView)
    object AnimatedValues : Animation("Animated Values", AnimatedValuesView)
    object RotatingShape : Animation("Rotating shape", RotatingShapeAnimationView)
    object PulsingShape : Animation("Pulsing shape", GrowingCircleAnimationView)
    object InterationAnimation : Animation("Interaction animation", InteractionAnimationView)

}
