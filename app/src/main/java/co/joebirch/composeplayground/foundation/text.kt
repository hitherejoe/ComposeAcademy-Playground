package co.joebirch.composeplayground.foundation

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.Text
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.text.TextStyle
import androidx.ui.text.style.TextOverflow
import androidx.ui.unit.dp
import androidx.ui.unit.sp
import co.joebirch.composeplayground.ComposableLayout

object TextView: ComposableLayout {

    @Composable
    override fun build() {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalGravity = Alignment.CenterHorizontally
        ) {
            MinimalTextComponent()
            StyledTextComponent()
            ColoredTextComponent()
            MaxLinesTextComponent()
            EllipsisTextComponent()
            ClippedTextComponent()
        }
    }

}

@Composable
fun MinimalTextComponent() {
    Text(
        text = "Simple text",
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun ColoredTextComponent() {
    Text(
        text = "Colored text",
        color = Color.Red,
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun MaxLinesTextComponent() {
    Text(
        text = "Max line length of 1 text that is using the default property for text overflow",
        color = Color.Red,
        maxLines = 1,
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun EllipsisTextComponent() {
    Text(
        text = "Max line length of 1 text that declares the use of Ellipsis for text overflow",
        color = Color.Red,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun ClippedTextComponent() {
    Text(
        text = "Max line length of 1 text that declares the use of Clip for text overflow",
        color = Color.Red,
        maxLines = 1,
        overflow = TextOverflow.Clip,
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun StyledTextComponent() {
    Text(
        text = "Large font size",
        style = TextStyle(fontSize = 28.sp),
        modifier = Modifier.padding(16.dp)
    )
}