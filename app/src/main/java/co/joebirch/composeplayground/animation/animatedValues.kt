package co.joebirch.composeplayground.animation

import androidx.compose.animation.animatedColor
import androidx.compose.animation.animatedFloat
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.state
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object AnimatedValuesView : ComposableLayout {

    @Composable
    override fun build() {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AnimatedFloat()
            AnimatedColor()
        }
    }

    @Composable
    fun AnimatedFloat() {
        val expandedState = state { false }
        val viewHeight = if (expandedState.value) animatedFloat(140f) else animatedFloat(40f)
        Box(modifier = Modifier.fillMaxWidth().preferredHeight(viewHeight.value.dp).clickable(
            onClick = {
                expandedState.value = !expandedState.value
            }
        ).background(Color.Red))
    }

    @Composable
    fun AnimatedColor() {
        val expandedState = state { false }
        val viewHeight =
            if (expandedState.value) animatedColor(Color.Red) else animatedColor(Color.Green)
        Box(
            modifier = Modifier.fillMaxWidth().preferredHeight(40.dp).clickable(onClick = {
                expandedState.value = !expandedState.value
            }).background(viewHeight.value)
        )
    }

}