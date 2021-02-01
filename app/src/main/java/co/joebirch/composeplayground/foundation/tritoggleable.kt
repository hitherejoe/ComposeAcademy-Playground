package co.joebirch.composeplayground.foundation

import androidx.compose.foundation.InteractionState
import androidx.compose.foundation.indication
import androidx.compose.material.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.triStateToggleable
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object TriToggleableView : ComposableLayout {

    @Composable
    override fun build() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TriToggleableComponent()
            DisabledTriToggleableComponent()
            IndicationTriToggleableComponent()
        }
    }

}

@Composable
fun TriToggleableComponent() {
    val state = remember { mutableStateOf(ToggleableState(false)) }
    Text(
        text = "Jetpack Compose",
        modifier = Modifier.triStateToggleable(
            state = state.value,
            onClick = {
                when (state.value) {
                    ToggleableState.Off -> {
                        state.value = ToggleableState.Indeterminate
                    }
                    ToggleableState.Indeterminate -> {
                        state.value = ToggleableState.On
                    }
                    else -> {
                        state.value = ToggleableState.Off
                    }
                }
            }
        )
    )
}

@Composable
fun DisabledTriToggleableComponent() {
    val state = remember { mutableStateOf(ToggleableState(false)) }
    Text(
        text = "Jetpack Compose",
        modifier = Modifier.triStateToggleable(
            state = state.value,
            onClick = {
                when (state.value) {
                    ToggleableState.Off -> {
                        state.value = ToggleableState.Indeterminate
                    }
                    ToggleableState.Indeterminate -> {
                        state.value = ToggleableState.On
                    }
                    else -> {
                        state.value = ToggleableState.Off
                    }
                }
            },
            enabled = false
        )
    )
}

@Composable
fun IndicationTriToggleableComponent() {
    val state = remember { mutableStateOf(ToggleableState(false)) }
    Text(
        text = "Jetpack Compose",
        modifier = Modifier
            .triStateToggleable(
                state = state.value,
                onClick = {
                    when (state.value) {
                        ToggleableState.Off -> {
                            state.value = ToggleableState.Indeterminate
                        }
                        ToggleableState.Indeterminate -> {
                            state.value = ToggleableState.On
                        }
                        else -> {
                            state.value = ToggleableState.Off
                        }
                    }
                }
            )
            .indication(
                indication = rememberRipple(),
                interactionState = InteractionState()
            )
    )
}