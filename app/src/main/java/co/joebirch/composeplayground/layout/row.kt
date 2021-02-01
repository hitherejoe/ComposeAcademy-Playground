package co.joebirch.composeplayground.layout

import androidx.compose.material.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object RowView: ComposableLayout {

    @Composable
    override fun build() {
        Row(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                    text = "First item",
                    modifier = Modifier.padding(4.dp)
                        .background(Color.Blue)
                        .weight(2f, fill = false)
            )
            Text(
                    text = "Second item",
                    modifier = Modifier.padding(4.dp)
                        .background(Color.Blue)
                        .weight(1f)
            )
        }
    }

}