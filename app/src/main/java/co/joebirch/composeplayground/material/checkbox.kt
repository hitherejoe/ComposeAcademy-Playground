package co.joebirch.composeplayground.material

import androidx.compose.Composable
import androidx.compose.MutableState
import androidx.compose.state
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.Text
import androidx.ui.foundation.clickable
import androidx.ui.foundation.selection.ToggleableState
import androidx.ui.layout.*
import androidx.ui.material.Checkbox
import androidx.ui.material.TriStateCheckbox
import androidx.ui.unit.dp
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