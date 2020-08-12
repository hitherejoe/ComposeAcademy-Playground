package co.joebirch.composeplayground.animation

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Box
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.state
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
            Crossfade(current = currentString) { color ->
                Text(
                    color, modifier = Modifier.fillMaxWidth().clickable(onClick = {
                        currentString = if (currentString == strings[0]) strings[1] else strings[0]
                    }),
                    style = TextStyle(textAlign = TextAlign.Center)
                )
            }
        }
    }

    @Composable
    fun CrossfadeColorAnimation() {
        val colors = listOf(Color.Red, Color.Green)
        var current by state<Color> { colors[0] }

        Column(modifier = Modifier.fillMaxWidth()) {
            Crossfade(current = current) { color ->
                Box(Modifier.fillMaxWidth().preferredHeight(120.dp).clickable(onClick = {
                    current = if (current == colors[0]) colors[1] else colors[0]
                }), backgroundColor = color)
            }
        }
    }

}