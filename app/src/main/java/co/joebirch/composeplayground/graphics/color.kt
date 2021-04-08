package co.joebirch.composeplayground.graphics

import androidx.compose.foundation.background
import androidx.compose.material.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object ColorView : ComposableLayout {

    @Composable
    override fun build() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
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

@Composable
fun ColorObject() {
    val selectedColor = remember { mutableStateOf(0) }
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
        Color.Unspecified
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .clickable(onClick = {
                if (selectedColor.value < colors.count() - 1) selectedColor.value =
                    selectedColor.value + 1 else selectedColor.value = 0
            }),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.fillMaxWidth().height(16.dp)
                .background(colors[selectedColor.value])
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
        modifier = Modifier.fillMaxWidth().height(16.dp)
            .background(color = color)
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
        modifier = Modifier.fillMaxWidth().height(16.dp)
            .background(color)
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
        modifier = Modifier.fillMaxWidth().height(16.dp)
            .background(color)
    )
}
