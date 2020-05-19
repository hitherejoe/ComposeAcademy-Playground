package co.joebirch.composeplayground.material

import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.Border
import androidx.ui.foundation.Text
import androidx.ui.foundation.shape.corner.CutCornerShape
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.Button
import androidx.ui.material.Card
import androidx.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout
import kotlinx.coroutines.delay
import java.util.*
import kotlin.concurrent.schedule
import kotlin.concurrent.timer
import kotlin.concurrent.timerTask

object ButtonView : ComposableLayout {

    @Composable
    override fun build() {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalGravity = Alignment.CenterHorizontally
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

    }, border = Border(2.dp, Color.Red)) {
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
    }, backgroundColor = Color.Green, disabledBackgroundColor = Color.Red,
        elevation = 8.dp, disabledElevation = 0.dp, disabledContentColor = Color.DarkGray,
        contentColor = Color.White, enabled = !disabled.value) {
        Text(
            text = "Jetpack Compose",
            modifier = Modifier.padding(16.dp)
        )
    }
}
