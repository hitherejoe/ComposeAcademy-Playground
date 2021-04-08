package co.joebirch.composeplayground.animation

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
        val enabled = remember { mutableStateOf(true) }
        Box(modifier = Modifier.padding(animateFloatAsState(if (enabled.value) 0f else 100f).value.dp).clickable(
            onClick = {
                enabled.value = !enabled.value
            }
        )) {
            Box(Modifier.fillMaxSize().background(Color.Green))
        }
    }
}