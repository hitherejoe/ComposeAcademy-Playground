package co.joebirch.composeplayground.foundation

import androidx.compose.foundation.BorderStroke
import androidx.compose.material.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object BackgroundView: ComposableLayout {

    @Composable
    override fun build() {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BackgroundColorComponent()
            BackgroundBrushComponent()
        }
    }

}

@Composable
fun BackgroundColorComponent() {
    Card(
        border = BorderStroke(2.dp, Color.Black)
    ) {
        Text(
            text = "Jetpack Compose",
            modifier = Modifier.padding(16.dp)
                .background(Color.Red, shape = RoundedCornerShape(4.dp))
        )
    }
}

@Composable
fun BackgroundBrushComponent() {
    Card(
        border = BorderStroke(2.dp, SolidColor(Color.Red))
    ) {
        Text(
            text = "Jetpack Compose",
            modifier = Modifier.padding(16.dp)
                .background(SolidColor(Color.Blue), alpha = 0.6f)
        )
    }
}