package co.joebirch.composeplayground.animation

import androidx.compose.animation.animate
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
import androidx.compose.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object SingleAnimationColorView : ComposableLayout {

    @Composable
    override fun build() {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SingleValueAnimationColor()
        }
    }

    @Composable
    fun SingleValueAnimationColor() {
        val enabled = remember { mutableStateOf(true) }
        Box {
            Box(
                Modifier.fillMaxSize().clickable(onClick = {
                    enabled.value = !enabled.value
                }).background(animate(if (enabled.value) Color.Green else Color.Red)),
            )
            Text(
                text = "Click me to change color!",
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}