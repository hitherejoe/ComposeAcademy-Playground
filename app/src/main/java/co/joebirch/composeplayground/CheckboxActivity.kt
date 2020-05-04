package co.joebirch.composeplayground

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.Model
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.Text
import androidx.ui.foundation.selection.ToggleableState
import androidx.ui.layout.Row
import androidx.ui.layout.padding
import androidx.ui.material.Checkbox
import androidx.ui.material.MaterialTheme
import androidx.ui.material.TriStateCheckbox
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp

class CheckboxActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                TriStateCheckboxComponent(TriStateFormState())
            }
        }
    }
}

@Model
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
    Clickable(onClick = {
        formState.optionChecked = !formState.optionChecked
    }) {
        Row {
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
}

@Model
class TriStateFormState(var optionChecked: ToggleableState? = ToggleableState.Indeterminate)


@Composable
fun TriStateCheckboxComponent(formState: TriStateFormState) {
    TriStateCheckbox(
        state = formState.optionChecked ?: ToggleableState.Indeterminate,
        onClick = {
            when (formState.optionChecked) {
                ToggleableState.Off -> {
                    formState.optionChecked = ToggleableState.Indeterminate
                }
                ToggleableState.On -> {
                    formState.optionChecked = ToggleableState.Off
                }
                ToggleableState.Indeterminate -> {
                    formState.optionChecked = ToggleableState.On
                }
            }
        }
    )
}

@Preview
@Composable
fun DefaultPreview() {
    MaterialTheme {
        CheckboxWithLabel(FormState())
    }
}