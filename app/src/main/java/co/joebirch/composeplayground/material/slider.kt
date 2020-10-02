package co.joebirch.composeplayground.material

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.Slider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.state
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object SliderView : ComposableLayout {

    @Composable
    override fun build() {
        Box(
            modifier = Modifier.fillMaxSize().padding(32.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                MinimalSliderComponent()
                ColoredSliderComponent()
                RangedSliderComponent()
                SteppedSliderComponent()
                EndListenerSliderComponent()
            }
        }
    }

    @Composable
    fun MinimalSliderComponent() {
        val state = state { 0f }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = state.value.toString())
            Slider(
                value = state.value,
                onValueChange = {
                    state.value = it
                }
            )
        }

    }

    @Composable
    fun RangedSliderComponent() {
        val state = state { 0f }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = state.value.toString())
            Slider(
                value = state.value,
                onValueChange = {
                    state.value = it
                },
                valueRange = 0f..5f
            )
        }
    }

    @Composable
    fun SteppedSliderComponent() {
        val state = state { 0f }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = state.value.toString())
            Slider(
                value = state.value,
                onValueChange = {
                    state.value = it
                },
                steps = 3
            )
        }
    }

    @Composable
    fun ColoredSliderComponent() {
        val state = state { 0f }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = state.value.toString())
            Slider(
                value = state.value,
                onValueChange = {
                    state.value = it
                },
                thumbColor = Color.Red
            )
        }
    }

    @Composable
    fun EndListenerSliderComponent() {
        val state = state { 0f }
        val endState = state { 0f }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = endState.value.toString())
            Slider(
                value = state.value,
                onValueChange = {
                    state.value = it
                },
                onValueChangeEnd = {
                    endState.value = state.value
                },
                thumbColor = Color.Red
            )
        }
    }
}