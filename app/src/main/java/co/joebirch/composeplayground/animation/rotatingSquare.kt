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
import androidx.ui.graphics.painter.rotate
import androidx.ui.layout.*
import androidx.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object RotatingShapeAnimationView : ComposableLayout {

    private val rotation = FloatPropKey()

    private val rotationTransitionDefinition = transitionDefinition {
        state("A") { this[rotation] = 0f }
        state("B") { this[rotation] = 360f }

        transition(fromState = "A", toState = "B") {
            rotation using repeatable<Float> {
                animation = tween {
                    duration = 3000
                    easing = LinearEasing
                }
                iterations = Infinite
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
            RotatingSquareComponent()
        }
    }

    @Composable
    fun RotatingSquareComponent() {
        Box(modifier = Modifier.fillMaxSize(), gravity = ContentGravity.Center, children = {
            Transition(
                definition = rotationTransitionDefinition,
                initState = "A",
                toState = "B"
            ) { state ->
                Canvas(modifier = Modifier.preferredSize(80.dp)) {
                    rotate(state[rotation]) {
                        drawRect(Color.Black, size = size)
                    }
                }
            }
        })
    }
}