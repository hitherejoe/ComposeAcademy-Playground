package co.joebirch.composeplayground.graphics

import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.Box
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.Text
import androidx.ui.foundation.VerticalScroller
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.Divider
import androidx.ui.text.style.TextAlign
import androidx.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object ColorView : ComposableLayout {

    @Composable
    override fun build() {
        VerticalScroller {
            Column(
                modifier = Modifier.fillMaxSize().padding(32.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalGravity = Alignment.CenterHorizontally
            ) {
                ColorObject()
                Spacer(modifier = Modifier.height(48.dp))
                ColorFromLong()
                Spacer(modifier = Modifier.height(48.dp))
                ColorFromFloats()
                Spacer(modifier = Modifier.height(48.dp))
                ColorFromIntRange()
            }
        }
    }

}

@Composable
fun ColorObject() {
    val selectedColor = state { 0 }
    val colors = listOf(
        Color.Red,
        Color.Green,
        Color.LightGray,
        Color.DarkGray,
        Color.Black,
        Color.White,
        Color.Cyan,
        Color.Blue,
        Color.Gray,
        Color.Magenta,
        Color.Transparent,
        Color.Yellow,
        Color.Unset
    )
    Clickable(onClick = {
        if (selectedColor.value < colors.count() - 1) selectedColor.value =
            selectedColor.value + 1 else selectedColor.value = 0
    }) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalGravity = Alignment.CenterHorizontally
        ) {
            Box(
                backgroundColor = colors[selectedColor.value],
                modifier = Modifier.fillMaxWidth().preferredHeight(16.dp)
            )
            Text(
                textAlign = TextAlign.Center,
                text = "Click to change",
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Composable
fun ColorFromLong() {
    val color = Color(0xFF000080)

    Box(
        backgroundColor = color,
        modifier = Modifier.fillMaxWidth().preferredHeight(16.dp)
    )
}

@Composable
fun ColorFromFloats() {
    val color = Color(
        red = 1.0f,
        green = 0f,
        blue = 0f,
        alpha = 1f
    )

    Box(
        backgroundColor = color,
        modifier = Modifier.fillMaxWidth().preferredHeight(16.dp)
    )
}

@Composable
fun ColorFromIntRange() {
    val color = Color(
        red = 255,
        green = 0,
        blue = 0,
        alpha = 1
    )

    Box(
        backgroundColor = color,
        modifier = Modifier.fillMaxWidth().preferredHeight(16.dp)
    )
}
