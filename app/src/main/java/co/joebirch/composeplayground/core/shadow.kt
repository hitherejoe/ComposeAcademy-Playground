package co.joebirch.composeplayground.core

import androidx.compose.foundation.Box
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.state
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object ShadowView : ComposableLayout {

    @Composable
    override fun build() {
        val showShadow = state { false }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalGravity = Alignment.CenterHorizontally
        ) {

            val modifier = if (showShadow.value) {
                Modifier.preferredSize(100.dp, 100.dp).drawShadow(12.dp, RectangleShape)
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
                    text = "Toggle Shadow",
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }

}