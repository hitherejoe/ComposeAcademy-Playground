package co.joebirch.composeplayground.material

import androidx.compose.Composable
import androidx.compose.Model
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.Box
import androidx.ui.graphics.Color
import androidx.ui.layout.Arrangement
import androidx.ui.layout.Column
import androidx.ui.layout.fillMaxSize
import androidx.ui.material.Switch
import co.joebirch.composeplayground.ComposableLayout

object SwitchView: ComposableLayout {

    @Composable
    override fun build() {
        Box(
            modifier = Modifier.fillMaxSize(),
            backgroundColor = Color.LightGray
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalGravity = Alignment.CenterHorizontally
            ) {
                MinimalSwitchComponent()
                ColoredSwitchComponent()
                DisabledSwitchComponent()
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
    fun ColoredSwitchComponent(
        formState: FormState = FormState(
            optionChecked = true
        )
    ) {
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
}