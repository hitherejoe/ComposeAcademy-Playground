package co.joebirch.composeplayground.core

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object ShadowView : ComposableLayout {

    @Composable
    override fun build() {
        val showShadow = remember { mutableStateOf(false) }
        Box(modifier = Modifier.size(200.dp)) {

            clip()
        }
    }

}

@Preview
@Composable
private fun shadow() {
    Box(
        modifier = Modifier.size(100.dp, 100.dp)
            .background(Color.White)
            .padding(16.dp)
            .shadow(elevation = 4.dp)
    )
}

@Preview
@Composable
private fun shape() {
    Box(
        modifier = Modifier.size(100.dp, 100.dp)
            .background(Color.Green)
            .shadow(elevation = 4.dp, shape = RectangleShape)
    )
}

@Preview
@Composable
private fun clip() {
    Box(
        modifier = Modifier.size(40.dp, 40.dp)
            .background(Color.Green)
            .padding(16.dp)
            .shadow(elevation = 6.dp, shape = RectangleShape, clip = false)
    )
}