package co.joebirch.composeplayground.layout

import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object ScollableColumnView : ComposableLayout {

    @Composable
    override fun build() {



        val scrollState = rememberScrollState(250.dp.value)
        ScrollableColumn(
            scrollState = scrollState
        ) {
            Text(
                text = "First item",
                modifier = Modifier.padding(64.dp)
            )
            Text(
                text = "Second item",
                modifier = Modifier.padding(64.dp)
            )
            Text(
                text = "Second item",
                modifier = Modifier.padding(64.dp)
            )
            Text(
                text = "Second item",
                modifier = Modifier.padding(64.dp)
            )
            Text(
                text = "Second item",
                modifier = Modifier.padding(64.dp)
            )
            Text(
                text = "Second item",
                modifier = Modifier.padding(64.dp)
            )
            Text(
                text = "Second item",
                modifier = Modifier.padding(64.dp)
            )
            Text(
                text = "Second item",
                modifier = Modifier.padding(64.dp)
            )
            Text(
                text = "Second item",
                modifier = Modifier.padding(64.dp)
            )
            Text(
                text = "Second item",
                modifier = Modifier.padding(64.dp)
            )
            Text(
                text = "Second item",
                modifier = Modifier.padding(64.dp)
            )
            Text(
                text = "Second item",
                modifier = Modifier.padding(64.dp)
            )
        }
    }

}