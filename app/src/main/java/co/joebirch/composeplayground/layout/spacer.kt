package co.joebirch.composeplayground.layout

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object SpacerView : ComposableLayout {

    @Composable
    override fun build() {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp)
        ) {
            Text(
                text = "First item"
            )
            Spacer(modifier = Modifier.preferredHeight(16.dp))
            Text(
                text = "Second item"
            )
            Spacer(modifier = Modifier.preferredHeight(32.dp))
            Text(
                text = "Third item"
            )
        }
    }

}