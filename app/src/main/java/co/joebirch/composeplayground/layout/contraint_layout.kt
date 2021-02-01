package co.joebirch.composeplayground.layout

import androidx.compose.material.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object ConstraintLayoutView : ComposableLayout {

    @ExperimentalLayout
    @Composable
    override fun build() {
        Box(modifier = Modifier.height(180.dp).background(Color.Cyan)) {
            ConstraintLayout {
                Text(
                    text = "First item",
                    modifier = Modifier.height(65.dp)
                        .padding(16.dp)
                        .background(Color.Red)
                )
                Text(
                    text = "Second item",
                    modifier = Modifier.height(65.dp)
                        .padding(16.dp)
                        .background(Color.Red)
                )
                Text(
                    text = "Second item",
                    modifier = Modifier.height(65.dp)
                        .padding(16.dp)
                        .background(Color.Red)
                )
                Text(
                    text = "Third item",
                    modifier = Modifier.padding(16.dp)
                        .background(Color.Red)
                )
                Text(
                    text = "Fourth item",
                    modifier = Modifier.padding(16.dp)
                        .background(Color.Red)
                )
                Text(
                    text = "Fifth item",
                    modifier = Modifier.padding(16.dp)
                        .background(Color.Red)
                )
            }
        }
    }

}