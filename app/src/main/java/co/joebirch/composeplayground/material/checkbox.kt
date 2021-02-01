package co.joebirch.composeplayground.material

import androidx.compose.material.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults.colors
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import co.joebirch.composeplayground.ComposableLayout

object CheckboxView: ComposableLayout {

    @Composable
    override fun build() {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val state = remember { mutableStateOf(TriStateFormState()) }
           // TriStateCheckboxComponent(state)
        }
    }

}

class FormState(var optionChecked: Boolean = false)

@Composable
fun CheckboxComponent(formState: FormState) {
    val isChecked = remember { mutableStateOf(false) }
    Checkbox(
        checked = isChecked.value,
        onCheckedChange = { checked ->
            isChecked.value = checked
        }
    )
}

@Preview
@Composable
fun CheckedColorCheckboxComponent() {
    val isChecked = remember { mutableStateOf(false) }
    Checkbox(
        checked = isChecked.value,
        onCheckedChange = { checked ->
            isChecked.value = checked
        },
        colors = colors(
            checkedColor = Color.Red
        )
    )
}

@Preview
@Composable
fun UncheckedColorCheckboxComponent() {
    val isChecked = remember { mutableStateOf(false) }
    Checkbox(
        checked = isChecked.value,
        onCheckedChange = { checked ->
            isChecked.value = checked
        },
        colors = colors(
            uncheckedColor = Color.Gray
        )
    )
}

@Preview
@Composable
fun CheckmarkColorCheckboxComponent() {
    val isChecked = remember { mutableStateOf(false) }
    Checkbox(
        checked = isChecked.value,
        onCheckedChange = { checked ->
            isChecked.value = checked
        },
        colors = colors(
            checkmarkColor = Color.White
        )
    )
}

@Preview
@Composable
fun DisabledColorCheckboxComponent() {
    val isChecked = remember { mutableStateOf(false) }
    Checkbox(
        enabled = false,
        checked = isChecked.value,
        onCheckedChange = { checked ->
            isChecked.value = checked
        },
        colors = colors(
            disabledColor = Color.LightGray
        )
    )
}

@Preview
@Composable
fun DisabledIndeterminateColorCheckboxComponent() {
    val isChecked = remember { mutableStateOf(false) }
    Checkbox(
        enabled = false,
        checked = isChecked.value,
        onCheckedChange = { checked ->
            isChecked.value = checked
        },
        colors = colors(
            disabledIndeterminateColor = Color.Gray
        )
    )
}

@Composable
fun DisabledCheckboxComponent(formState: FormState) {
    val isChecked = remember { mutableStateOf(false) }
    Checkbox(
        checked = isChecked.value,
        onCheckedChange = { checked ->
            isChecked.value = checked
        },
        enabled = false
    )
}

@Composable
fun CheckboxWithLabel(formState: FormState) {
    val isChecked = remember { mutableStateOf(false) }
    Row (modifier = Modifier.clickable(onClick = {
        isChecked.value = !isChecked.value
    })) {
        Checkbox(
            checked = formState.optionChecked,
            onCheckedChange = { checked ->
                isChecked.value = checked
            }
        )
        Text(
            text = "Notify me of updates",
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}