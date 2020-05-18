package co.joebirch.composeplayground.animation

import androidx.compose.*
import androidx.ui.animation.Crossfade
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.Box
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.Text
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.text.TextStyle
import androidx.ui.text.style.TextAlign
import androidx.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object CrossfadeAnimationView : ComposableLayout {

    @Composable
    override fun build() {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalGravity = Alignment.CenterHorizontally
        ) {
            CrossfadeTextAnimation()
            CrossfadeColorAnimation()
        }
    }

    @Composable
    fun CrossfadeTextAnimation() {
        val strings = listOf("This the first text", "This is the second text")
        var currentString by state { strings[0] }

        Column(modifier = Modifier.fillMaxWidth()) {
            Clickable(onClick = {
                currentString = if (currentString == strings[0]) strings[1] else strings[0]
            }) {
                Crossfade(current = currentString) { color ->
                    Text(color, modifier = Modifier.fillMaxWidth(),
                        style = TextStyle(textAlign = TextAlign.Center))
                }
            }
        }
    }

    @Composable
    fun CrossfadeColorAnimation() {
        val colors = listOf(Color.Red, Color.Green)
        var current by state { colors[0] }

        Column(modifier = Modifier.fillMaxWidth()) {
            Clickable(onClick = {
                current = if (current == colors[0]) colors[1] else colors[0]
            }) {
                Crossfade(current = current) { color ->
                    Box(Modifier.fillMaxWidth().preferredHeight(120.dp), backgroundColor = color)
                }
            }
        }
    }

}