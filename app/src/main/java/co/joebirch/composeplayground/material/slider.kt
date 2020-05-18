package co.joebirch.composeplayground.material

import androidx.compose.Composable
import androidx.compose.Model
import androidx.compose.state
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.Box
import androidx.ui.foundation.Text
import androidx.ui.graphics.Color
import androidx.ui.layout.Arrangement
import androidx.ui.layout.Column
import androidx.ui.layout.fillMaxSize
import androidx.ui.layout.padding
import androidx.ui.material.Slider
import androidx.ui.material.Switch
import androidx.ui.unit.dp
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
                horizontalGravity = Alignment.CenterHorizontally
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
        Column(horizontalGravity = Alignment.CenterHorizontally) {
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
        Column(horizontalGravity = Alignment.CenterHorizontally) {
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
        Column(horizontalGravity = Alignment.CenterHorizontally) {
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
        Column(horizontalGravity = Alignment.CenterHorizontally) {
            Text(text = state.value.toString())
            Slider(
                value = state.value,
                onValueChange = {
                    state.value = it
                },
                color = Color.Red
            )
        }
    }

    @Composable
    fun EndListenerSliderComponent() {
        val state = state { 0f }
        val endState = state { 0f }
        Column(horizontalGravity = Alignment.CenterHorizontally) {
            Text(text = endState.value.toString())
            Slider(
                value = state.value,
                onValueChange = {
                    state.value = it
                },
                onValueChangeEnd = {
                    endState.value = state.value
                },
                color = Color.Red
            )
        }
    }
}