package co.joebirch.composeplayground.layout

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.state
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object VerticalArrangementView : ComposableLayout {

    private val options = listOf(
        Arrangement.Center, Arrangement.Top, Arrangement.Bottom,
        Arrangement.SpaceEvenly, Arrangement.SpaceAround, Arrangement.SpaceBetween
    )

    @Composable
    override fun build() {
        val state = state { 0 }

        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = options[state.value],
            horizontalGravity = Alignment.CenterHorizontally
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