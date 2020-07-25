package co.joebirch.composeplayground.foundation

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.*
import androidx.ui.layout.*
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
    Text(
        text = "Clickable",
        modifier = Modifier.padding(16.dp).clickable(onClick = {

        }, onClickLabel = "Click to open document")
    )
}

@Composable
fun ClickableComponentWithListeners() {
    Text(
        text = "Clickable",
        modifier = Modifier.padding(16.dp).clickable(onClick = {

        }, onLongClick = {

        }, onDoubleClick = {

        })
    )
}
