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
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontSynthesis
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.joebirch.composeplayground.ComposableLayout

object TextStyleView: ComposableLayout {

    @Composable
    override fun build() {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SimpleComponent()
            FontWeightComponent()
            FontStyleComponent()
            LetterSpacingComponent()
            FontSynthesisWeightComponent()
            FontSynthesisStyleComponent()
            FontSynthesisAllComponent()
            BaselineShiftSubscriptComponent()
            BaselineShiftSuperscriptComponent()
        }
    }

}

@Composable
fun SimpleComponent() {
    Text(
        text = "Font size",
        style = TextStyle(fontSize = 28.sp),
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun TextWithShadowComponent() {
    Text(
        text = "Jetpack Compose",
        style = TextStyle(shadow = Shadow(Color.Gray)),
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun TextDirectionComponent() {
    Text(
        text = "Jetpack Compose",
        style = TextStyle(textDirection = TextDirection.ContentOrRtl),
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun TextDecorationComponent() {
    Text(
        text = "Jetpack Compose",
        style = TextStyle(textDecoration = TextDecoration.combine(listOf(
            TextDecoration.LineThrough, TextDecoration.Underline
        ))),
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun FontWeightComponent() {
    Text(
        text = "Font weight",
        style = TextStyle(fontWeight = FontWeight.Bold),
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun FontFamilyComponent() {
    Text(
        text = "Font weight",
        style = TextStyle(fontFamily = FontFamily.SansSerif),
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun FontStyleComponent() {
    Text(
        text = "Font style",
        style = TextStyle(fontStyle = FontStyle.Italic),
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun LetterSpacingComponent() {
    Text(
        text = "Letter Spacing",
        style = TextStyle(letterSpacing = 12.sp),
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun FontSynthesisWeightComponent() {
    Text(
        text = "Font Synthesis Weight",
        style = TextStyle(fontSynthesis = FontSynthesis.Weight),
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun FontSynthesisStyleComponent() {
    Text(
        text = "Font Synthesis Style",
        style = TextStyle(fontSynthesis = FontSynthesis.Style),
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun FontSynthesisAllComponent() {
    Text(
        text = "Font Synthesis All",
        style = TextStyle(fontSynthesis = FontSynthesis.All),
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun BaselineShiftSubscriptComponent() {
    Text(
        text = "Baseline Shift Subscript",
        style = TextStyle(baselineShift = BaselineShift.Subscript),
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun BaselineShiftSuperscriptComponent() {
    Text(
        text = "Baseline Shift Superscript",
        style = TextStyle(baselineShift = BaselineShift.Superscript),
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun LineHeightComponent() {
    Text(
            text = "This first line here will have a text indent. But the second line will have the indent set by restLine.",
            style = TextStyle(lineHeight = 16.sp),
            modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun TextIndentComponent() {
    Text(
        text = "This first line here will have a text indent. But the second line will have the indent set by restLine.",
        style = TextStyle(textIndent = TextIndent(firstLine = 16.sp, restLine = 8.sp)),
        modifier = Modifier.padding(16.dp)
    )
}