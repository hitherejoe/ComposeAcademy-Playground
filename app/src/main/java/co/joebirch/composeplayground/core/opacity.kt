package co.joebirch.composeplayground.core

import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.*
import androidx.ui.foundation.Box
import androidx.ui.foundation.Text
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.Button
import androidx.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object OpacityView : ComposableLayout {

    @Composable
    override fun build() {
        val showShadow = state { false }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalGravity = Alignment.CenterHorizontally
        ) {

            val modifier = if (showShadow.value) {
                Modifier.preferredSize(100.dp, 100.dp).drawOpacity(0.2f)
            } else {
                Modifier.preferredSize(100.dp, 100.dp)
            }
            Box(
                modifier = modifier,
                backgroundColor = Color.Green
            )

            Spacer(modifier = Modifier.preferredHeight(36.dp))

            Button(onClick = {
                showShadow.value = !showShadow.value
            }) {
                Text(
                    text = "Toggle Opacity",
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }

}