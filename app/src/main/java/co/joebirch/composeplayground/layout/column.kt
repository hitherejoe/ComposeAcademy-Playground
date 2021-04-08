package co.joebirch.composeplayground.layout

import androidx.compose.material.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object ColumnView : ComposableLayout {

    @Composable
    override fun build() {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "First item",
                modifier = Modifier
                    .padding(PaddingValues(16.dp))
                    .background(Color.Blue)
            )
            Text(
                text = "Second item",
                modifier = Modifier
                    .padding(16.dp)
                    .background(Color.Red)
            )
        }
    }

    @Composable
    fun ScrollingColumn() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .scrollable(
                    rememberScrollState(),
                    orientation = Orientation.Vertical
                ),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            repeat(100) {
                Text(
                    text = "Item $it",
                    modifier = Modifier
                        .padding(PaddingValues(16.dp))
                        .background(Color.Blue)
                )
            }
        }
    }

}
