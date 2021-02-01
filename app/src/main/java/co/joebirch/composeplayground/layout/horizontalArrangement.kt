package co.joebirch.composeplayground.layout

import androidx.compose.material.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object HorizontalArrangementView : ComposableLayout {

    private val options = listOf(
        Arrangement.Center, Arrangement.Start, Arrangement.End,
        Arrangement.SpaceEvenly, Arrangement.SpaceAround, Arrangement.SpaceBetween
    )

    @Composable
    override fun build() {
        val state = remember { mutableStateOf(0) }

        Row(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            horizontalArrangement = options[state.value]
        ) {
            Text(text = options[state.value].javaClass.simpleName)
            Button(
                onClick = {
                    if (state.value < options.size - 1) {
                        state.value = state.value + 1
                    } else {
                        state.value = 0
                    }
                },
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = "Change")
            }
        }
    }
}