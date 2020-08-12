package co.joebirch.composeplayground.material

import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.ToggleableState
import androidx.compose.material.Checkbox
import androidx.compose.material.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.state
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object CheckboxView: ComposableLayout {

    @Composable
    override fun build() {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalGravity = Alignment.CenterHorizontally
        ) {
            val state = state { TriStateFormState() }
            TriStateCheckboxComponent(state)
        }
    }

}

class FormState(var optionChecked: Boolean = false)

@Composable
fun CheckboxComponent(formState: FormState) {
    Checkbox(
        checked = formState.optionChecked,
        onCheckedChange = { checked ->
            formState.optionChecked = checked
        }
    )
}

@Composable
fun CheckboxWithLabel(formState: FormState) {
    Row (modifier = Modifier.clickable(onClick = {
        formState.optionChecked = !formState.optionChecked
    })) {
        Checkbox(
            checked = formState.optionChecked,
            onCheckedChange = { checked ->
                formState.optionChecked = checked
            }
        )
        Text(
            text = "Notify me of updates",
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

class TriStateFormState(var optionChecked: ToggleableState? = ToggleableState.Indeterminate)


@Composable
fun TriStateCheckboxComponent(formState: MutableState<TriStateFormState>) {
    TriStateCheckbox(
        state = formState.value.optionChecked ?: ToggleableState.Indeterminate,
        onClick = {
            when (formState.value.optionChecked) {
                ToggleableState.Off -> {
                    formState.value.optionChecked = ToggleableState.Indeterminate
                }
                ToggleableState.On -> {
                    formState.value.optionChecked = ToggleableState.Off
                }
                ToggleableState.Indeterminate -> {
                    formState.value.optionChecked = ToggleableState.On
                }
            }
        }
    )
}