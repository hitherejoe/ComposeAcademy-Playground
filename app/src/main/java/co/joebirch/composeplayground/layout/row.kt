package co.joebirch.composeplayground.layout

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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