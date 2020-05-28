package co.joebirch.composeplayground.foundation

import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.*
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.ripple.ripple
import androidx.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object ClickableView : ComposableLayout {

    @Composable
    override fun build() {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalGravity = Alignment.CenterHorizontally
        ) {
            ClickableComponent()
            ClickableComponentWithListeners()
        }
    }

}

@Composable
fun ClickableComponent() {
    val clicked = state { false }
    Text(
        text = "Clickable",
        color = if (clicked.value) Color.Red else Color.Black,
        modifier = Modifier.padding(16.dp).clickable(onClick = {

        })
    )
}

@Composable
fun ClickableComponentWithListeners() {
    Text(
        text = "Clickable with ripple",
        modifier = Modifier.padding(16.dp).clickable(onClick = {

        }, onLongClick = {

        }, onDoubleClick = {

        })
    )
}