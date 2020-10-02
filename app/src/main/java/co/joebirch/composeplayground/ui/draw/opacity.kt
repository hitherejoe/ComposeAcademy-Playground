package co.joebirch.composeplayground.ui.draw

import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.state
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawOpacity
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object OpacityView : ComposableLayout {

    @Composable
    override fun build() {
        val showShadow = remember { mutableStateOf(false) }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            val modifier = if (showShadow.value) {
                Modifier.preferredSize(100.dp, 100.dp).drawOpacity(0.2f)
            } else {
                Modifier.preferredSize(100.dp, 100.dp)
            }
            Box(
                modifier = modifier
                    .background(Color.Green),
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