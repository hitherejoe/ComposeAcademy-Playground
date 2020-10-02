package co.joebirch.composeplayground.animation

import androidx.compose.animation.animate
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.state
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object SingleAnimationFloatView : ComposableLayout {

    @Composable
    override fun build() {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SingleValueAnimationFloat()
        }
    }

    @Composable
    fun SingleValueAnimationFloat() {
        val enabled = state { true }
        Box(modifier = Modifier.padding(animate(if (enabled.value) 0f else 100f).dp).clickable(
            onClick = {
                enabled.value = !enabled.value
            }
        )) {
            Box(Modifier.fillMaxSize().background(Color.Green))
            Text(
                text = "Click me to change padding!",
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}