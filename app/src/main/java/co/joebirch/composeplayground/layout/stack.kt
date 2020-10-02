package co.joebirch.composeplayground.layout

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import co.joebirch.composeplayground.ComposableLayout

object StackView : ComposableLayout {

    @Composable
    override fun build() {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "Item",
                modifier = Modifier.align(Alignment.Center)
            )
            Text(
                text = "This is another item",
                modifier = Modifier.align(Alignment.BottomEnd)
            )
        }
    }

}