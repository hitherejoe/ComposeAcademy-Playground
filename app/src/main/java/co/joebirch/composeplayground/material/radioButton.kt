package co.joebirch.composeplayground.material

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.RadioButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.state
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object RadioButtonView: ComposableLayout {

    @Composable
    override fun build() {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            RadioButtonWithLabel("Test")
        }
    }

}

class RadioState(var selectedOption: String? = null)

@Composable
fun RadioButtonWithLabel(
    text: String
) {
    val formState = state { "" }
    Row(modifier = Modifier.padding(10.dp)) {
        RadioButton(
            selected = formState.value == text,
            onClick = {
                formState.value = text
            }
        )
        Text(
            text = text,
            modifier = Modifier.padding(start = 18.dp)
        )
    }
}