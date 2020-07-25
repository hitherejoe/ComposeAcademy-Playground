package co.joebirch.composeplayground.animation

import androidx.animation.*
import androidx.animation.AnimationConstants.Infinite
import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.animation.Transition
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.Box
import androidx.ui.foundation.Canvas
import androidx.ui.foundation.ContentGravity
import androidx.ui.foundation.Text
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.Button
import androidx.ui.material.RadioGroup
import androidx.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object TransitionDemoView : ComposableLayout {

    val sizeState = FloatPropKey()

    enum class AnimationType {
        SNAP, TWEEN, PHYSICS, REPEATABLE, KEYFRAME
    }

    @Composable
    override fun build() {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalGravity = Alignment.CenterHorizontally
        ) {
            val animationType = state { AnimationType.SNAP }
            val toState = state { CircleStatus.Shrinking }
            val transitionDef = sizeTransitionDefinition(animationType.value)

            RadioGroup {
                RadioGroupTextItem(selected = animationType.value == AnimationType.SNAP, onSelect = {
                    animationType.value = AnimationType.SNAP
                }, text = "Snap")
                RadioGroupTextItem(selected = animationType.value == AnimationType.TWEEN, onSelect = {
                    animationType.value = AnimationType.TWEEN
                }, text = "Tween")
                RadioGroupTextItem(selected = animationType.value == AnimationType.PHYSICS, onSelect = {
                    animationType.value = AnimationType.PHYSICS
                }, text = "Physics")
                RadioGroupTextItem(selected = animationType.value == AnimationType.REPEATABLE, onSelect = {
                    animationType.value = AnimationType.REPEATABLE
                }, text = "Repeatable")
                RadioGroupTextItem(selected = animationType.value == AnimationType.KEYFRAME, onSelect = {
                    animationType.value = AnimationType.KEYFRAME
                }, text = "Keyframe")
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
            Box(modifier = Modifier.fillMaxSize(), gravity = ContentGravity.Center, children = {
                Transition(
                    definition = transitionDef,
                    toState = toState.value
                ) { state ->
                    Canvas(modifier = Modifier.preferredSize(80.dp)) {
                        drawCircle(Color.Red, state[sizeState])
                    }
                }
            })
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
                            )
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
                        sizeState using keyframes<Float> {
                            50f at 200
                            60f at 2200
                            175f at 2500
                        }
                    }
                    transition(fromState = CircleStatus.Growing, toState = CircleStatus.Shrinking) {
                        sizeState using keyframes<Float> {
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
}