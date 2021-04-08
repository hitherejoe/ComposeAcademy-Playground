package co.joebirch.composeplayground.animation

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object TransitionDemoView : ComposableLayout {

    @Composable
    override fun build() {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

        }
    }
    /*
    val sizeState = FloatPropKey()

    enum class AnimationType {
        SNAP, TWEEN, PHYSICS, REPEATABLE, KEYFRAME
    }

    @Composable
    override fun build() {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val animationType = remember { mutableStateOf(AnimationType.SNAP) }
            val toState = remember { mutableStateOf(CircleStatus.Shrinking) }
            val transitionDef = sizeTransitionDefinition(animationType.value)

            Column {
                Row(
                    modifier = Modifier.selectable(selected =
                    animationType.value == AnimationType.SNAP, onClick = {
                        animationType.value = AnimationType.SNAP
                    })
                ) {
                    RadioButton(selected = animationType.value == AnimationType.SNAP, onClick = {
                        animationType.value = AnimationType.SNAP
                    })
                    Text(text = "Snap")
                }

                Row(
                    modifier = Modifier.selectable(selected =
                    animationType.value == AnimationType.TWEEN, onClick = {
                        animationType.value = AnimationType.TWEEN
                    })
                ) {
                    RadioButton(selected = animationType.value == AnimationType.TWEEN, onClick = {
                        animationType.value = AnimationType.TWEEN
                    })
                    Text(text = "Tween")
                }

                Row(
                    modifier = Modifier.selectable(selected =
                    animationType.value == AnimationType.PHYSICS, onClick = {
                        animationType.value = AnimationType.PHYSICS
                    })
                ) {
                    RadioButton(selected = animationType.value == AnimationType.PHYSICS, onClick = {
                        animationType.value = AnimationType.PHYSICS
                    })
                    Text(text = "Physics")
                }

                Row(
                    modifier = Modifier.selectable(selected =
                    animationType.value == AnimationType.REPEATABLE, onClick = {
                        animationType.value = AnimationType.REPEATABLE
                    })
                ) {
                    RadioButton(
                        selected = animationType.value == AnimationType.REPEATABLE,
                        onClick = {
                            animationType.value = AnimationType.REPEATABLE
                        })
                    Text(text = "Repeatable")
                }

                Row(
                    modifier = Modifier.selectable(selected =
                    animationType.value == AnimationType.KEYFRAME, onClick = {
                        animationType.value = AnimationType.KEYFRAME
                    })
                ) {
                    RadioButton(
                        selected = animationType.value == AnimationType.KEYFRAME,
                        onClick = {
                            animationType.value = AnimationType.KEYFRAME
                        })
                    Text(text = "Keyframe")
                }
            }

            Button(onClick = {
                if (toState.value == CircleStatus.Shrinking) {
                    toState.value = CircleStatus.Growing
                } else {
                    toState.value = CircleStatus.Shrinking
                }
            }, modifier = Modifier.padding(16.dp)) {
                Text("Animate!")
            }
            Box(
                modifier = Modifier.fillMaxSize()
                    .align(Alignment.CenterHorizontally)
            ) {
                val state = transition(
                    definition = transitionDef,
                    toState = toState.value
                )
                Canvas(modifier = Modifier.preferredSize(80.dp)) {
                    drawCircle(Color.Red, state[sizeState])
                }
            }
        }
    }

    enum class CircleStatus {
        Growing,
        Shrinking
    }

    private fun sizeTransitionDefinition(animationType: AnimationType): TransitionDefinition<CircleStatus> {
        return transitionDefinition {
            state(CircleStatus.Shrinking) { this[sizeState] = 50f }
            state(CircleStatus.Growing) { this[sizeState] = 175f }

            when (animationType) {
                AnimationType.SNAP -> {
                    snapTransition(CircleStatus.Shrinking to CircleStatus.Growing)
                    snapTransition(CircleStatus.Growing to CircleStatus.Shrinking)
                }
                AnimationType.REPEATABLE -> {
                    transition(fromState = CircleStatus.Shrinking, toState = CircleStatus.Growing) {
                        sizeState using repeatable(
                            iterations = Infinite,
                            animation = tween(
                                easing = LinearEasing,
                                durationMillis = 1000
                            )
                        )
                    }
                    transition(fromState = CircleStatus.Growing, toState = CircleStatus.Shrinking) {
                        sizeState using repeatable(
                            iterations = Infinite,
                            animation = tween(
                                easing = LinearEasing,
                                durationMillis = 1000
                            ),
                        )
                    }
                }
                AnimationType.PHYSICS -> {
                    transition(fromState = CircleStatus.Shrinking, toState = CircleStatus.Growing) {
                        sizeState using spring(
                            stiffness = 5f,
                            dampingRatio = 5f
                        )
                    }
                    transition(fromState = CircleStatus.Growing, toState = CircleStatus.Shrinking) {
                        sizeState using spring(
                            stiffness = 5f,
                            dampingRatio = 5f
                        )
                    }
                }
                AnimationType.TWEEN -> {
                    transition(fromState = CircleStatus.Shrinking, toState = CircleStatus.Growing) {
                        sizeState using tween(
                            durationMillis = 2000,
                            easing = FastOutLinearInEasing
                        )
                    }
                    transition(fromState = CircleStatus.Growing, toState = CircleStatus.Shrinking) {
                        sizeState using tween(
                            durationMillis = 2000,
                            easing = LinearOutSlowInEasing,
                            delayMillis = 200
                        )
                    }
                }
                AnimationType.KEYFRAME -> {
                    transition(fromState = CircleStatus.Shrinking, toState = CircleStatus.Growing) {
                        sizeState using keyframes {
                            50f at 200
                            60f at 2200
                            175f at 2500
                        }
                    }
                    transition(fromState = CircleStatus.Growing, toState = CircleStatus.Shrinking) {
                        sizeState using keyframes {
                            175f at 200
                            160f at 300
                            100f at 750
                            80f at 700
                            50f at 500
                        }
                    }
                }
            }
        }
    }

     */
}