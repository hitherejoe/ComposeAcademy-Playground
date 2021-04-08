package co.joebirch.composeplayground.animation

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object CrossfadeAnimationView : ComposableLayout {

    @Composable
    override fun build() {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CrossfadeTextAnimation()
            CrossfadeColorAnimation()
        }
    }

    @Composable
    fun CrossfadeTextAnimation() {
        val strings = listOf("This the first text", "This is the second text")
        var currentString = remember { mutableStateOf(strings[0]) }

        Column(modifier = Modifier.fillMaxWidth()) {
            Crossfade(targetState = currentString) { color ->
                Text(
                    text = color.value, modifier = Modifier.fillMaxWidth().clickable(onClick = {
                        currentString.value = if (currentString.value == strings[0]) strings[1] else strings[0]
                    }),
                    style = TextStyle(textAlign = TextAlign.Center)
                )
            }
        }
    }

    @Composable
    fun CrossfadeColorAnimation() {
        val colors = listOf(Color.Red, Color.Green)
        val current = remember { mutableStateOf(colors[0]) }

        Column(modifier = Modifier.fillMaxWidth()) {
            Crossfade(targetState = current) { color ->
                Box(Modifier.fillMaxWidth().height(120.dp).clickable(onClick = {
                    current.value = if (current.value == colors[0]) colors[1] else colors[0]
                }).background(current.value))
            }
        }
    }

}