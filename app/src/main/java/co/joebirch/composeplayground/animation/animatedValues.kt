package co.joebirch.composeplayground.animation

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
        val expandedState = remember { mutableStateOf(false) }
        val viewHeight = if (expandedState.value) {
            animateFloatAsState(140f)
        } else animateFloatAsState(40f)
        Box(modifier = Modifier.fillMaxWidth().height(viewHeight.value.dp).clickable(
            onClick = {
                expandedState.value = !expandedState.value
            }
        ).background(Color.Red))
    }

    @Composable
    fun AnimatedColor() {
        val expandedState = remember { mutableStateOf(false) }
        val viewHeight =
            if (expandedState.value) {
                animateColorAsState(Color.Red)
            } else animateColorAsState(Color.Green)
        Box(
            modifier = Modifier.fillMaxWidth().height(40.dp).clickable(onClick = {
                expandedState.value = !expandedState.value
            }).background(viewHeight.value)
        )
    }

}