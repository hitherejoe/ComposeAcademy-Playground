package co.joebirch.composeplayground.layout

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.Text
import androidx.ui.layout.*
import androidx.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object ColumnView : ComposableLayout {

    @Composable
    override fun build() {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalGravity = Alignment.CenterHorizontally
        ) {
            Text(
                text = "First item",
                modifier = Modifier.padding(16.dp)
            )
            Text(
                text = "Second item",
                modifier = Modifier.padding(16.dp)
            )
            Text(
                text = "Third item",
                modifier = Modifier.padding(16.dp)
            )
        }
    }

}