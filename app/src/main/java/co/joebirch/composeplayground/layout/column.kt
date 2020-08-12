package co.joebirch.composeplayground.layout

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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