package co.joebirch.composeplayground.material

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.state
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object ButtonView : ComposableLayout {

    @Composable
    override fun build() {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MinimalButtonComponent()
            BorderButtonComponent()
            DisabledButtonComponent()
            ShapeButtonComponent()
        }
    }

}

@Composable
fun MinimalButtonComponent() {
    Button(onClick = {

    }) {
        Text(
            text = "Jetpack Compose",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun ShapeButtonComponent() {
    Button(onClick = {

    }, shape = CutCornerShape(12.dp)) {
        Text(
            text = "Jetpack Compose",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun BorderButtonComponent() {
    Button(onClick = {

    }, border = BorderStroke(2.dp, Color.Red)) {
        Text(
            text = "Jetpack Compose",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun DisabledButtonComponent() {
    val disabled = state { false }
    Button(onClick = {
        disabled.value = true
    }, backgroundColor = Color.Green,
        elevation = 8.dp,
        contentColor = Color.White, enabled = !disabled.value) {
        Text(
            text = "Jetpack Compose",
            modifier = Modifier.padding(16.dp)
        )
    }
}
