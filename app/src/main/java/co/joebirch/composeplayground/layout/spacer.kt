package co.joebirch.composeplayground.layout

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.foundation.Text
import androidx.ui.layout.*
import androidx.ui.unit.dp
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