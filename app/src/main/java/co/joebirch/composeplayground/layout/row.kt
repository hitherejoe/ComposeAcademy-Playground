package co.joebirch.composeplayground.layout

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.Text
import androidx.ui.layout.*
import androidx.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object RowView: ComposableLayout {

    @Composable
    override fun build() {
        Row(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalGravity = Alignment.CenterVertically
        ) {
            Text(
                    text = "First item",
                    modifier = Modifier.padding(4.dp)
            )
            Text(
                    text = "Second item",
                    modifier = Modifier.padding(4.dp)
            )
            Text(
                    text = "Third item",
                    modifier = Modifier.padding(4.dp)
            )
        }
    }

}