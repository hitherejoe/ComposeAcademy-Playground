package co.joebirch.composeplayground.material

import androidx.compose.Composable
import androidx.compose.Model
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.Text
import androidx.ui.foundation.selection.ToggleableState
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.Checkbox
import androidx.ui.material.Divider
import androidx.ui.material.TriStateCheckbox
import androidx.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object DividerView: ComposableLayout {

    @Composable
    override fun build() {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalGravity = Alignment.CenterHorizontally
        ) {
            MinimalDividerComponent()
            ColoredDividerComponent()
            IndentDividerComponent()
            ThickDividerComponent()
        }
    }

}


@Composable
fun MinimalDividerComponent() {
    Divider()
}

@Composable
fun ColoredDividerComponent() {
    Divider(color = Color.Red)
}

@Composable
fun ThickDividerComponent() {
    Divider(thickness = 12.dp)
}

@Composable
fun IndentDividerComponent() {
    Divider(startIndent = 12.dp)
}