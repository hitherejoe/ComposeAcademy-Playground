package co.joebirch.composeplayground.animation

import android.graphics.PointF
import androidx.animation.*
import androidx.compose.Composable
import androidx.compose.remember
import androidx.compose.state
import androidx.ui.animation.Transition
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.core.gesture.pressIndicatorGestureFilter
import androidx.ui.foundation.Box
import androidx.ui.foundation.Canvas
import androidx.ui.foundation.ContentGravity
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.unit.PxPosition
import androidx.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object InteractionAnimationView : ComposableLayout {

    private val shapeRadius = FloatPropKey()
    private val down = PointF(0f, 0f)

    private enum class CircleStatus {
        Idle,
        Pressed,
        Released
    }

    @Composable
    override fun build() {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalGravity = Alignment.CenterHorizontally
        ) {
            TouchCircleComponent()
        }
    }


    @Composable
    fun TouchCircleComponent() {
        val toState = state { CircleStatus.Idle }
        val rippleTransDef = remember { createTransDef() }

        val onPress: (PxPosition) -> Unit = { position ->
            down.x = position.x.value
            down.y = position.y.value
            toState.value = CircleStatus.Pressed
        }
        val onRelease: () -> Unit = {
            toState.value = CircleStatus.Released
        }

        Box(modifier = Modifier.fillMaxSize().pressIndicatorGestureFilter(
            onStart = onPress, onStop = onRelease), gravity = ContentGravity.Center, children = {
            Transition(
                definition = rippleTransDef,
                toState = toState.value
            ) { state ->
                Canvas(modifier = Modifier.preferredSize(80.dp)) {
                    drawCircle(Color.Black, state[shapeRadius])
                }
            }
        })
    }


    private fun createTransDef(): TransitionDefinition<CircleStatus> {
        return transitionDefinition {
            state(CircleStatus.Idle) {
                this[shapeRadius] = 50f
            }
            state(CircleStatus.Pressed) {
                this[shapeRadius] = 150f
            }
            state(CircleStatus.Released) {
                this[shapeRadius] = 50f
            }
            transition(fromState = CircleStatus.Idle, toState = CircleStatus.Pressed) {
                shapeRadius using tween<Float> {
                    duration = 225
                }
                interruptionHandling = InterruptionHandling.UNINTERRUPTIBLE
            }
            transition(fromState = CircleStatus.Pressed, toState = CircleStatus.Released) {
                shapeRadius using tween<Float> {
                    duration = 225
                }
                interruptionHandling = InterruptionHandling.UNINTERRUPTIBLE
                nextState = CircleStatus.Idle
            }
            snapTransition(CircleStatus.Released to CircleStatus.Idle)
        }
    }
}