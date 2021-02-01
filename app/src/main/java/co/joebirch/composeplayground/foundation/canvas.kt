package co.joebirch.composeplayground.foundation

import androidx.compose.foundation.Canvas
import androidx.compose.material.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object CanvasView : ComposableLayout {

    @Composable
    override fun build() {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CanvasComponent()
        }
    }

}

@Composable
fun CanvasComponent() {
    Text(
        text = "Clickable",
        modifier = Modifier.padding(16.dp).clickable(onClick = {

        }, onClickLabel = "Click to open document")
    )
}
