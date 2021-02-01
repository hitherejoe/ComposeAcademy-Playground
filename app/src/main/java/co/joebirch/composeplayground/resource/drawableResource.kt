package co.joebirch.composeplayground.resource

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.loadImageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import co.joebirch.composeplayground.ComposableLayout
import co.joebirch.composeplayground.R

object ImageResourceView : ComposableLayout {

    @Composable
    override fun build() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                imageVector = vectorResource(
                    id =
                    R.drawable.ic_baseline_account_circle_24
                ),
                modifier = Modifier.padding(16.dp),
                contentDescription = "my description"
            )
            Image(
                bitmap = imageResource(
                    id =
                    R.drawable.outline_accessibility_black_18dp
                ),
                modifier = Modifier.padding(16.dp),
                contentDescription = "my description"
            )

            loadImageResource(
                id =
                R.drawable.outline_accessibility_black_18dp
            ).resource.resource?.let {
                Image(
                    bitmap = it,
                    modifier = Modifier.padding(16.dp),
                    contentDescription = "my description"
                )
            }


        }
    }

}

@Preview
@Composable
fun test() {
    loadImageResource(
        id = R.drawable.outline_accessibility_black_18dp
    ).resource.resource?.let {
        Image(
            bitmap = it,
            modifier = Modifier.padding(16.dp),
            contentDescription = "my description"
        )
    }
}