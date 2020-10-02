package co.joebirch.composeplayground.material

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object DividerView: ComposableLayout {

    @Composable
    override fun build() {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MinimalDividerComponent()
            ColoredDividerComponent()
            IndentDividerComponent()
            ThickDividerComponent()
        }
    }

}


@Composable
fun MinimalDividerComponent() {
    Divider()
}

@Composable
fun ColoredDividerComponent() {
    Divider(color = Color.Red)
}

@Composable
fun ThickDividerComponent() {
    Divider(thickness = 12.dp)
}

@Composable
fun IndentDividerComponent() {
    Divider(startIndent = 12.dp)
}