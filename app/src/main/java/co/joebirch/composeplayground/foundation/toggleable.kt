package co.joebirch.composeplayground.foundation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.InteractionState
import androidx.compose.foundation.indication
import androidx.compose.material.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.Card
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object ToggleableView : ComposableLayout {

    @Composable
    override fun build() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ToggleableComponent()
            DisabledToggleableComponent()
            IndicationToggleableComponent()
        }
    }

}

@Composable
fun ToggleableComponent() {
    val state = remember { mutableStateOf(false) }
    Text(
        text = "Jetpack Compose",
        modifier = Modifier.toggleable(
            value = state.value,
            onValueChange = { value ->
                state.value = value
            }
        )
    )
}

@Composable
fun DisabledToggleableComponent() {
    val state = remember { mutableStateOf(false) }
    Text(
        text = "Jetpack Compose",
        modifier = Modifier.toggleable(
            value = state.value,
            onValueChange = { value ->
                state.value = value
            },
            enabled = false
        )
    )
}

@Composable
fun IndicationToggleableComponent() {
    val state = remember { mutableStateOf(false) }
    Text(
        text = "Jetpack Compose",
        modifier = Modifier
            .toggleable(
                value = state.value,
                onValueChange = { value ->
                    state.value = value
                }
            )
            .indication(
                indication = rememberRipple(),
                interactionState = InteractionState()
            )
    )
}