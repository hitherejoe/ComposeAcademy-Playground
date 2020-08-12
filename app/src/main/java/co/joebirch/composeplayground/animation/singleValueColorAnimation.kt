package co.joebirch.composeplayground.animation

import androidx.compose.animation.animate
import androidx.compose.foundation.Box
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.state
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

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
        Stack {
            Box(Modifier.fillMaxSize().clickable(onClick = {
                enabled.value = !enabled.value
            }), backgroundColor =
            animate(if (enabled.value) Color.Green else Color.Red))
            Text(text = "Click me to change color!",
                modifier = Modifier.gravity(Alignment.Center))
        }
    }
}