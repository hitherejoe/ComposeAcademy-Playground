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

object SingleAnimationFloatView : ComposableLayout {

    @Composable
    override fun build() {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalGravity = Alignment.CenterHorizontally
        ) {
            SingleValueAnimationFloat()
        }
    }

    @Composable
    fun SingleValueAnimationFloat() {
        val enabled = state { true }
        Clickable({ enabled.value = !enabled.value }) {
            Stack(modifier = Modifier.padding(animate(if (enabled.value) 0f else 100f).dp)) {
                Box(Modifier.fillMaxSize(), backgroundColor = Color.Green)
                Text(text = "Click me to change padding!",
                    modifier = Modifier.gravity(Alignment.Center))
            }
        }
    }
}