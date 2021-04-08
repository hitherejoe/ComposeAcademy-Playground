package co.joebirch.composeplayground.animation

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.repeatable
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object RotatingShapeAnimationView : ComposableLayout {
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
        val rotation: Float by animateFloatAsState(
            targetValue = 360f,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = 3000),
                repeatMode = RepeatMode.Restart
            )
        )
        Box(modifier = Modifier.fillMaxSize()) {
            Canvas(modifier = Modifier.size(80.dp).align(Alignment.Center)) {
                rotate(rotation) {
                    drawRect(Color.Black, size = size)
                }
            }
        }
    }
}