package co.joebirch.composeplayground.animation

import androidx.animation.*
import androidx.compose.Composable
import androidx.compose.frames.restore
import androidx.compose.state
import androidx.ui.animation.Transition
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.Box
import androidx.ui.foundation.Canvas
import androidx.ui.foundation.ContentGravity
import androidx.ui.foundation.Text
import androidx.ui.geometry.Offset
import androidx.ui.graphics.Color
import androidx.ui.graphics.Paint
import androidx.ui.graphics.painter.translate
import androidx.ui.layout.*
import androidx.ui.material.Button
import androidx.ui.material.RadioGroup
import androidx.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object TransitionDemoView : ComposableLayout {

    val sizeS = FloatPropKey()

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
            val rippleTransDef = sizeTransitionDefinition(animationType.value)

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
                    definition = rippleTransDef,
                    toState = toState.value
                ) { state ->
                    Canvas(modifier = Modifier.preferredSize(80.dp)) {
                        drawCircle(Color.Red, state[sizeS])
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
            state(CircleStatus.Shrinking) { this[sizeS] = 50f }
            state(CircleStatus.Growing) { this[sizeS] = 175f }

            when (animationType) {
                AnimationType.SNAP -> {
                    snapTransition(CircleStatus.Shrinking to CircleStatus.Growing)
                    snapTransition(CircleStatus.Growing to CircleStatus.Shrinking)
                }
                AnimationType.REPEATABLE -> {
                    transition(fromState = CircleStatus.Shrinking, toState = CircleStatus.Growing) {
                        sizeS using repeatable<Float> {
                            iterations = Infinite
                            animation = tween {
                                easing = LinearEasing
                                duration = 1000
                            }
                        }
                    }
                    transition(fromState = CircleStatus.Growing, toState = CircleStatus.Shrinking) {
                        sizeS using repeatable<Float> {
                            iterations = Infinite
                            animation = tween {
                                easing = LinearEasing
                                duration = 1000
                            }
                        }
                    }
                }
                AnimationType.PHYSICS -> {
                    transition(fromState = CircleStatus.Shrinking, toState = CircleStatus.Growing) {
                        sizeS using physics<Float> {
                            stiffness = 5f
                            dampingRatio = 5f
                        }
                    }
                    transition(fromState = CircleStatus.Growing, toState = CircleStatus.Shrinking) {
                        sizeS using physics<Float> {
                            stiffness = 5f
                            dampingRatio = 5f
                        }
                    }
                }
                AnimationType.TWEEN -> {
                    transition(fromState = CircleStatus.Shrinking, toState = CircleStatus.Growing) {
                        sizeS using tween<Float> {
                            duration = 2000
                            easing = FastOutLinearInEasing
                        }
                    }
                    transition(fromState = CircleStatus.Growing, toState = CircleStatus.Shrinking) {
                        sizeS using tween<Float> {
                            duration = 2000
                            easing = LinearOutSlowInEasing
                        }
                    }
                }
                AnimationType.KEYFRAME -> {
                    transition(fromState = CircleStatus.Shrinking, toState = CircleStatus.Growing) {
                        sizeS using keyframes<Float> {
                            duration = 2500
                            50f at 200
                            60f at 2200
                            175f at 2500
                        }
                    }
                    transition(fromState = CircleStatus.Growing, toState = CircleStatus.Shrinking) {
                        sizeS using keyframes<Float> {
                            duration = 2500
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