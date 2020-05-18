package co.joebirch.composeplayground.foundation

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.Text
import androidx.ui.layout.*
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontStyle
import androidx.ui.text.font.FontSynthesis
import androidx.ui.text.font.FontWeight
import androidx.ui.text.style.BaselineShift
import androidx.ui.text.style.TextIndent
import androidx.ui.unit.dp
import androidx.ui.unit.sp
import co.joebirch.composeplayground.ComposableLayout

object TextStyleView: ComposableLayout {

    @Composable
    override fun build() {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalGravity = Alignment.CenterHorizontally
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
fun FontWeightComponent() {
    Text(
        text = "Font weight",
        style = TextStyle(fontWeight = FontWeight.Bold),
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