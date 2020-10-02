package co.joebirch.composeplayground.animation

import androidx.compose.animation.core.*
import androidx.compose.animation.core.AnimationConstants.Infinite
import androidx.compose.animation.transition
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object RotatingShapeAnimationView : ComposableLayout {

    private val rotation = FloatPropKey()

    private val rotationTransitionDefinition = transitionDefinition<String> {
        state("A") { this[rotation] = 0f }
        state("B") { this[rotation] = 360f }

        transition(fromState = "A", toState = "B") {
            rotation using repeatable(
                iterations = Infinite,
                animation = tween(
                    durationMillis = 3000,
                    easing = LinearEasing
                )
            )
        }
    }

    @Composable
    override fun build() {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            RotatingSquareComponent()
        }
    }

    @Composable
    fun RotatingSquareComponent() {
        Box(modifier = Modifier.fillMaxSize()) {
            val state = transition(
                definition = rotationTransitionDefinition,
                initState = "A",
                toState = "B"
            )
            Canvas(modifier = Modifier.preferredSize(80.dp).align(Alignment.Center)) {
                rotate(state[rotation]) {
                    drawRect(Color.Black, size = size)
                }
            }
        }
    }
}