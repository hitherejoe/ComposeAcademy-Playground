package co.joebirch.composeplayground.layout

import androidx.compose.material.Text
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object PaddingView : ComposableLayout {

    @Composable
    override fun build() {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp)
        ) {
            Text(
                text = "First item"
            )
            Spacer(modifier = Modifier.padding(16.dp))
            PaddingValues()
            Text(
                text = "Second item"
            )
            Spacer(modifier = Modifier.width(32.dp))
            Text(
                text = "Third item"
            )
            Spacer(modifier = Modifier.absolutePadding(
                left = 32.dp,
                top = 32.dp,
                right = 32.dp,
                bottom = 32.dp,
            ))
            Text(
                text = "Fourth item"
            )
            Spacer(modifier = Modifier.padding(
                PaddingValues(
                    start = 32.dp,
                    top = 32.dp,
                    end = 32.dp,
                    bottom = 32.dp,
                )
            ))
            Text(
                text = "Fifth item"
            )
        }
    }

}