package co.joebirch.composeplayground.material

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults.colors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object SwitchView : ComposableLayout {

    @Composable
    override fun build() {
        Box(
            modifier = Modifier.fillMaxSize()
                .background(Color.LightGray)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                MinimalSwitchComponent()
            }
        }
    }

    @Composable
    fun MinimalSwitchComponent() {
        val isChecked = remember { mutableStateOf(false) }
        Switch(
            checked = isChecked.value,
            onCheckedChange = { checked ->
                isChecked.value = checked
            }
        )
    }




}

@Preview(showBackground = true)
@Composable
fun DisabledSwitchComponent() {
    val isChecked = remember { mutableStateOf(false) }
    Switch(
        modifier = Modifier.padding(16.dp),
        checked = isChecked.value,
        onCheckedChange = { checked ->
            isChecked.value = checked
        },
        enabled = false
    )
}

@Preview(showBackground = true)
@Composable
fun CheckedThumbColorSwitchComponent() {
    val isChecked = remember { mutableStateOf(true) }
    Switch(
        modifier = Modifier.padding(16.dp),
        checked = isChecked.value,
        onCheckedChange = { checked ->
            isChecked.value = checked
        },
        colors = colors(
            checkedThumbColor = Color.Red
        )
    )
}

@Preview(showBackground = true)
@Composable
fun CheckedTrackColorSwitchComponent() {
    val isChecked = remember { mutableStateOf(true) }
    Switch(
        modifier = Modifier.padding(16.dp),
        checked = isChecked.value,
        onCheckedChange = { checked ->
            isChecked.value = checked
        },
        colors = colors(
            checkedTrackColor = Color.Red
        )
    )
}

@Preview(showBackground = true)
@Composable
fun CheckedTrackAlphaSwitchComponent() {
    val isChecked = remember { mutableStateOf(true) }
    Switch(
        modifier = Modifier.padding(16.dp),
        checked = isChecked.value,
        onCheckedChange = { checked ->
            isChecked.value = checked
        },
        colors = colors(
            checkedTrackColor = Color.Red,
            checkedTrackAlpha = 0.1f
        )
    )
}

@Preview(showBackground = true)
@Composable
fun UncheckedThumbColorSwitchComponent() {
    val isChecked = remember { mutableStateOf(true) }
    Switch(
        modifier = Modifier.padding(16.dp),
        checked = isChecked.value,
        onCheckedChange = { checked ->
            isChecked.value = checked
        },
        colors = colors(
            uncheckedThumbColor = Color.Gray
        )
    )
}

@Preview(showBackground = true)
@Composable
fun UncheckedTrackColorSwitchComponent() {
    val isChecked = remember { mutableStateOf(true) }
    Switch(
        modifier = Modifier.padding(16.dp),
        checked = isChecked.value,
        onCheckedChange = { checked ->
            isChecked.value = checked
        },
        colors = colors(
            uncheckedTrackColor = Color.LightGray
        )
    )
}

@Preview(showBackground = true)
@Composable
fun UncheckedTrackAlphaSwitchComponent() {
    val isChecked = remember { mutableStateOf(true) }
    Switch(
        modifier = Modifier.padding(16.dp),
        checked = isChecked.value,
        onCheckedChange = { checked ->
            isChecked.value = checked
        },
        colors = colors(
            uncheckedTrackColor = Color.LightGray,
            uncheckedTrackAlpha = 0.1f
        )
    )
}

@Preview(showBackground = true)
@Composable
fun DisabledCheckedThumbColorSwitchComponent() {
    val isChecked = remember { mutableStateOf(true) }
    Switch(
        modifier = Modifier.padding(16.dp),
        checked = isChecked.value,
        onCheckedChange = { checked ->
            isChecked.value = checked
        },
        colors = colors(
            disabledCheckedThumbColor = Color.Green
        )
    )
}

@Preview(showBackground = true)
@Composable
fun DisabledCheckedTrackColorSwitchComponent() {
    val isChecked = remember { mutableStateOf(true) }
    Switch(
        modifier = Modifier.padding(16.dp),
        checked = isChecked.value,
        onCheckedChange = { checked ->
            isChecked.value = checked
        },
        colors = colors(
            disabledCheckedTrackColor = Color.DarkGray
        )
    )
}

@Preview(showBackground = true)
@Composable
fun DisabledUncheckedThumbColorSwitchComponent() {
    val isChecked = remember { mutableStateOf(false) }
    Switch(
        modifier = Modifier.padding(16.dp),
        checked = isChecked.value,
        onCheckedChange = { checked ->
            isChecked.value = checked
        },
        colors = colors(
            disabledUncheckedThumbColor = Color.Gray
        )
    )
}

@Preview(showBackground = true)
@Composable
fun DisabledUncheckedTrackColorSwitchComponent() {
    val isChecked = remember { mutableStateOf(false) }
    Switch(
        modifier = Modifier.padding(16.dp),
        checked = isChecked.value,
        onCheckedChange = { checked ->
            isChecked.value = checked
        },
        colors = colors(
            disabledUncheckedTrackColor = Color.LightGray
        )
    )
}