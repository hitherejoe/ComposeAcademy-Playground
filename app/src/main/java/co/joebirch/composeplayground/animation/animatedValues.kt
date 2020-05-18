package co.joebirch.composeplayground.animation

import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.animation.animatedColor
import androidx.ui.animation.animatedFloat
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.*
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object AnimatedValuesView : ComposableLayout {

    @Composable
    override fun build() {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalGravity = Alignment.CenterHorizontally
        ) {
            AnimatedFloat()
            AnimatedColor()
        }
    }

    @Composable
    fun AnimatedFloat() {
        val expandedState = state { false }
        val viewHeight = if (expandedState.value) animatedFloat(140f) else animatedFloat(40f)
        Clickable(onClick = { expandedState.value = !expandedState.value }) {
            Box(modifier = Modifier.fillMaxWidth().preferredHeight(viewHeight.value.dp),
                backgroundColor = Color.Red)
        }
    }

    @Composable
    fun AnimatedColor() {
        val expandedState = state { false }
        val viewHeight = if (expandedState.value) animatedColor(Color.Red) else animatedColor(Color.Green)
        Clickable(onClick = { expandedState.value = !expandedState.value }) {
            Box(modifier = Modifier.fillMaxWidth().preferredHeight(40.dp),
                backgroundColor = viewHeight.value)
        }
    }

}