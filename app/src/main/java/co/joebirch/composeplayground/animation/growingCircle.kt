package co.joebirch.composeplayground.animation

import androidx.compose.animation.core.*
import androidx.compose.animation.transition
import androidx.compose.foundation.Box
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ContentGravity
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object GrowingCircleAnimationView : ComposableLayout {

    private val shapeSize = FloatPropKey()

    private val sizeTransitionDefinition = transitionDefinition<String> {
        state("A") { this[shapeSize] = 50f }
        state("B") { this[shapeSize] = 175f }
        state("C") { this[shapeSize] = 50f }

        transition(fromState = "A", toState = "B") {
            shapeSize using tween(
                durationMillis = 900,
                easing = FastOutLinearInEasing
            )
            nextState = "C"
        }
        transition(fromState = "B", toState = "C") {
            shapeSize using tween(
                durationMillis = 900,
                easing = LinearOutSlowInEasing
            )
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
            val state = transition(
                definition = sizeTransitionDefinition,
                initState = "A",
                toState = "B"
            )
            Canvas(modifier = Modifier.preferredSize(80.dp)) {
                drawCircle(Color.Black, state[shapeSize])
            }
        })
    }
}