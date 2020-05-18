package co.joebirch.composeplayground.foundation

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.Border
import androidx.ui.foundation.Text
import androidx.ui.graphics.Color
import androidx.ui.graphics.SolidColor
import androidx.ui.layout.*
import androidx.ui.material.Card
import androidx.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object BorderView: ComposableLayout {

    @Composable
    override fun build() {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalGravity = Alignment.CenterHorizontally
        ) {
            BorderComponent()
            BorderBrushComponent()
        }
    }

}

@Composable
fun BorderComponent() {
    Card(
        border = Border(2.dp, Color.Black)
    ) {
        Text(
            text = "Jetpack Compose",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun BorderBrushComponent() {
    Card(
        border = Border(2.dp, SolidColor(Color.Red))
    ) {
        Text(
            text = "Jetpack Compose",
            modifier = Modifier.padding(16.dp)
        )
    }
}