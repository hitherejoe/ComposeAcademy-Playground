package co.joebirch.composeplayground.material

import androidx.compose.foundation.layout.*
import androidx.compose.material.TriStateCheckbox
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object TriStateCheckboxView: ComposableLayout {

    @Composable
    override fun build() {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            TriStateCheckboxComponent()
        }
    }

}

class TriStateFormState(var optionChecked: ToggleableState? = ToggleableState.Indeterminate)

@Composable
fun TriStateCheckboxComponent() {
    val state = remember { mutableStateOf(ToggleableState.Off) }
    TriStateCheckbox(
        state = state.value,
        onClick = {
            when (state.value) {
                ToggleableState.Off -> {
                    state.value = ToggleableState.Indeterminate
                }
                ToggleableState.On -> {
                    state.value = ToggleableState.Off
                }
                ToggleableState.Indeterminate -> {
                    state.value = ToggleableState.On
                }
            }
        }
    )
}

@Composable
fun EnabledTriStateCheckboxComponent() {
    val state = remember { mutableStateOf(ToggleableState.Off) }
    TriStateCheckbox(
        state = state.value,
        onClick = {
            when (state.value) {
                ToggleableState.Off -> {
                    state.value = ToggleableState.Indeterminate
                }
                ToggleableState.On -> {
                    state.value = ToggleableState.Off
                }
                ToggleableState.Indeterminate -> {
                    state.value = ToggleableState.On
                }
            }
        },
        enabled = false
    )
}

@Composable
fun BoxColorTriStateCheckboxComponent() {
    val state = remember { mutableStateOf(ToggleableState.Off) }
    TriStateCheckbox(
        state = state.value,
        onClick = {
            when (state.value) {
                ToggleableState.Off -> {
                    state.value = ToggleableState.Indeterminate
                }
                ToggleableState.On -> {
                    state.value = ToggleableState.Off
                }
                ToggleableState.Indeterminate -> {
                    state.value = ToggleableState.On
                }
            }
        }
    )
}