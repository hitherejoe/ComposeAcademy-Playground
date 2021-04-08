package co.joebirch.composeplayground.material

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults.elevation
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object FloatingActionButtonView : ComposableLayout {

    @Composable
    override fun build() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconFloatingActionButton()
            ColoredFloatingActionButton()
            ElevatedFloatingActionButton()
            ShapeFloatingActionButton()
        }
    }

}


@Composable
fun IconFloatingActionButton() {

    FloatingActionButton(onClick = {

    }) {
        Icon(
            imageVector = Icons.Filled.Star,
            contentDescription = "my description"
        )
    }
}

@Composable
fun ColoredFloatingActionButton() {
    FloatingActionButton(
        onClick = {

        },
        backgroundColor = Color.Red,
        contentColor = Color.White
    ) {
        Icon(
            imageVector = Icons.Filled.Star,
            contentDescription = "my description"
        )
    }
}

@Composable
fun ElevatedFloatingActionButton() {
    FloatingActionButton(
        onClick = {

        },
        elevation = elevation(20.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.Star,
            contentDescription = "my description"
        )
    }
}

@Composable
fun ShapeFloatingActionButton() {
    FloatingActionButton(
        onClick = {

        },
        shape = RectangleShape
    ) {
        Icon(
            imageVector = Icons.Filled.Star,
            contentDescription = "my description"
        )
    }
}
