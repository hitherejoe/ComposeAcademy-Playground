package co.joebirch.composeplayground.material

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object IconButtonView : ComposableLayout {

    @Composable
    override fun build() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MinimalIconButtonComponent()
        }
    }

}

@Composable
fun MinimalIconButtonComponent() {
    IconButton(
        onClick = {

        },
        content = {
            Icon(
                Icons.Default.Person,
                contentDescription = "my description"
            )
        }
    )
}

@Composable
fun DisabledMinimalIconButtonComponent() {
    IconButton(
        onClick = {

        },
        content = {
            Icon(
                Icons.Default.Person,
                contentDescription = "my description"
            )
        },
        enabled = false
    )
}
