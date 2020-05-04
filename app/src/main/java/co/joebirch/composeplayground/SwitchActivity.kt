package co.joebirch.composeplayground

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.Model
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.foundation.selection.ToggleableState
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.Checkbox
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Switch
import androidx.ui.material.TriStateCheckbox
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp

class SwitchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Column(modifier = Modifier.wrapContentSize(align = Alignment.Center)) {
                    MinimalSwitchComponent()
                    Spacer(modifier = Modifier.preferredHeight(120.dp))
                    ColoredSwitchComponent()
                    Spacer(modifier = Modifier.preferredHeight(120.dp))
                    DisabledSwitchComponent()
                }
            }
        }
    }

    @Model
    class FormState(var optionChecked: Boolean = false)

    @Composable
    fun MinimalSwitchComponent(formState: FormState = FormState()) {
        Switch(
            checked = formState.optionChecked,
            onCheckedChange = { checked ->
                formState.optionChecked = checked
            }
        )
    }

    @Composable
    fun ColoredSwitchComponent(formState: FormState = FormState(optionChecked = true)) {
        Switch(
            checked = formState.optionChecked,
            onCheckedChange = { checked ->
                formState.optionChecked = checked
            },
            color = Color.Red
        )
    }

    @Composable
    fun DisabledSwitchComponent(formState: FormState = FormState()) {
        Switch(
            checked = formState.optionChecked,
            onCheckedChange = { checked ->
                formState.optionChecked = checked
            },
            enabled = false
        )
    }

    @Preview
    @Composable
    fun DefaultPreview() {
        MaterialTheme {
            MinimalSwitchComponent(FormState())
        }
    }
}