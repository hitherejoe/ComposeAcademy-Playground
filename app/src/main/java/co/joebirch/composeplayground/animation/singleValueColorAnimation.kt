package co.joebirch.composeplayground.animation

import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.animation.animate
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.Box
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.Text
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout
import androidx.ui.layout.Column
import androidx.ui.layout.padding

object SingleAnimationColorView : ComposableLayout {

    @Composable
    override fun build() {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalGravity = Alignment.CenterHorizontally
        ) {
            SingleValueAnimationColor()
        }
    }

    @Composable
    fun SingleValueAnimationColor() {
        val enabled = state { true }
        Clickable({ enabled.value = !enabled.value }) {
            Stack {
                Box(Modifier.fillMaxSize(), backgroundColor =
                animate(if (enabled.value) Color.Green else Color.Red))
                Text(text = "Click me to change color!",
                    modifier = Modifier.gravity(Alignment.Center))
            }
        }
    }
}