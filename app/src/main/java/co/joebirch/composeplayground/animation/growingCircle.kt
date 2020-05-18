package co.joebirch.composeplayground.animation

import androidx.animation.*
import androidx.compose.Composable
import androidx.ui.animation.Transition
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.Box
import androidx.ui.foundation.Canvas
import androidx.ui.foundation.ContentGravity
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object GrowingCircleAnimationView : ComposableLayout {

    private val shapeSize = FloatPropKey()

    private val sizeTransitionDefinition = transitionDefinition {
        state("A") { this[shapeSize] = 50f }
        state("B") { this[shapeSize] = 175f }
        state("C") { this[shapeSize] = 50f }

        transition(fromState = "A", toState = "B") {
            shapeSize using tween<Float> {
                duration = 900
                easing = FastOutLinearInEasing
            }
            nextState = "C"
        }
        transition(fromState = "B", toState = "C") {
            shapeSize using tween<Float> {
                duration = 900
                easing = LinearOutSlowInEasing
            }
        }
    }

    @Composable
    override fun build() {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalGravity = Alignment.CenterHorizontally
        ) {
            GrowingCircleComponent()
        }
    }

    @Composable
    fun GrowingCircleComponent() {
        Box(modifier = Modifier.fillMaxSize(), gravity = ContentGravity.Center, children = {
            Transition(
                definition = sizeTransitionDefinition,
                initState = "A",
                toState = "B"
            ) { state ->
                Canvas(modifier = Modifier.preferredSize(80.dp)) {
                    drawCircle(Color.Black, state[shapeSize])
                }
            }
        })
    }
}