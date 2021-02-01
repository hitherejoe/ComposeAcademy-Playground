package co.joebirch.composeplayground.foundation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import co.joebirch.composeplayground.ComposableLayout

object TextView: ComposableLayout {

    @Composable
    override fun build() {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
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

@Preview
@Composable
fun MinimalTextComponent() {
    Text(
        text = "Jetpack Compose"
    )
}

@Preview
@Composable
fun ColoredTextComponent() {
    Text(
        text = "Jetpack Compose",
        color = Color.Red
    )
}

@Preview
@Composable
fun FontSizeTextComponent() {
    Text(
        text = "Colored text",
        fontSize = 18.sp
    )
}

@Preview
@Composable
fun FontWeightTextComponent() {
    Text(
        text = "Colored text",
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun FontStyleTextComponent() {
    Text(
        text = "Colored text",
        fontStyle = FontStyle.Italic
    )
}

@Composable
fun FontFamilyTextComponent() {
    Text(
        text = "Colored text",
        fontFamily = FontFamily.SansSerif
    )
}

@Composable
fun LetterSpacingTextComponent() {
    Text(
        text = "Colored text",
        letterSpacing = 4.sp
    )
}

@Composable
fun DecorationTextComponent() {
    Text(
        text = "Colored text",
        textDecoration = TextDecoration.LineThrough,
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun AlignTextComponent() {
    Text(
        text = "Colored text",
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun LineHeightTextComponent() {
    Text(
        text = "Colored text",
        lineHeight = 2.sp,
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun OverflowTextComponent() {
    Text(
        text = "Colored text",
        overflow = TextOverflow.Ellipsis,
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun WrapTextComponent() {
    Text(
        text = "Colored text",
        softWrap = true,
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