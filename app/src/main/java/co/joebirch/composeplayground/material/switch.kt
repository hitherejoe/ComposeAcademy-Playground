package co.joebirch.composeplayground.material

import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.Box
import androidx.ui.graphics.Color
import androidx.ui.layout.Arrangement
import androidx.ui.layout.Column
import androidx.ui.layout.fillMaxSize
import androidx.ui.layout.wrapContentSize
import androidx.ui.material.Switch
import co.joebirch.composeplayground.ComposableLayout

object SwitchView: ComposableLayout {

    @Composable
    override fun build() {
        Box(modifier = Modifier.fillMaxSize(),
        backgroundColor = Color.LightGray) {
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

    @Composable
    fun MinimalSwitchComponent() {
        val isChecked = state  { false }
        Switch(
            checked = isChecked.value,
            onCheckedChange = { checked ->
                isChecked.value = checked
            }, modifier = Modifier.wrapContentSize()
        )
    }

    @Composable
    fun ColoredSwitchComponent() {
        val isChecked = state  { true }
        Switch(
            checked = isChecked.value,
            onCheckedChange = { checked ->
                isChecked.value = checked
            },
            color = Color.Red
        )
    }

    @Composable
    fun DisabledSwitchComponent() {
        val isChecked = state  { true }
        Switch(
            checked = isChecked.value,
            onCheckedChange = { checked ->
                isChecked.value = checked
            },
            enabled = false
        )
    }
}