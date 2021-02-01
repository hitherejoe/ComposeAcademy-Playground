package co.joebirch.composeplayground.foundation

import androidx.compose.foundation.Indication
import androidx.compose.foundation.InteractionState
import androidx.compose.material.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object ClickableView : ComposableLayout {

    @Composable
    override fun build() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
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
        modifier = Modifier
            .padding(16.dp)
            .clickable(onClick = {
                // handle click event
            }, onClickLabel = "Click to open document")
    )
}

@Composable
fun Indication() {
    Text(
        text = "Clickable",
        modifier = Modifier
            .padding(16.dp)
            .clickable(
                onClick = {
                    // handle click event
                }
            )
            .indication(
                indication = rememberRipple(),
                interactionState = InteractionState()
            )
    )
}

@Composable
fun ClickableComponentWithListeners() {
    Text(
        text = "Clickable",
        modifier = Modifier
            .padding(16.dp)
            .clickable(onClick = {

            }, onLongClick = {

            }, onDoubleClick = {

            })
    )
}
