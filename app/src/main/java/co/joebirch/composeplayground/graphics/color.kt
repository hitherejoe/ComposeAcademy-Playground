package co.joebirch.composeplayground.graphics

import androidx.compose.foundation.Box
import androidx.compose.foundation.Text
import androidx.compose.foundation.VerticalScroller
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.state
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
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
        Column(
            modifier = Modifier.fillMaxSize().clickable(onClick = {
                if (selectedColor.value < colors.count() - 1) selectedColor.value =
                    selectedColor.value + 1 else selectedColor.value = 0
            }),
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
