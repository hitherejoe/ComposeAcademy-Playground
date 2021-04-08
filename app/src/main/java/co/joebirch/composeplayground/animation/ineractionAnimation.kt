package co.joebirch.composeplayground.animation

import android.graphics.PointF
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object InteractionAnimationView : ComposableLayout {

    //private val shapeRadius = FloatPropKey()
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
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //TouchCircleComponent()
        }
    }
/*

    @Composable
    fun TouchCircleComponent() {
        val toState = remember { mutableStateOf(CircleStatus.Idle) }
        val rippleTransDef = remember { createTransDef() }

        val onPress: (Offset) -> Unit = { offset ->
            down.x = offset.x
            down.y = offset.y
            toState.value = CircleStatus.Pressed
        }
        val onRelease: () -> Unit = {
            toState.value = CircleStatus.Released
        }

        Box(modifier = Modifier.fillMaxSize().pressIndicatorGestureFilter(
            onStart = onPress, onStop = onRelease)) {
            val state = transition(
                definition = rippleTransDef,
                toState = toState.value
            )
            Canvas(modifier = Modifier.preferredSize(80.dp)) {
                drawCircle(Color.Black, state[shapeRadius])
            }
        }
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
                shapeRadius using tween(
                    durationMillis = 225
                )
                interruptionHandling = InterruptionHandling.UNINTERRUPTIBLE
            }
            transition(fromState = CircleStatus.Pressed, toState = CircleStatus.Released) {
                shapeRadius using tween(
                    durationMillis = 225
                )
                interruptionHandling = InterruptionHandling.UNINTERRUPTIBLE
                nextState = CircleStatus.Idle
            }
            snapTransition(CircleStatus.Released to CircleStatus.Idle)
        }
    }

 */
}
