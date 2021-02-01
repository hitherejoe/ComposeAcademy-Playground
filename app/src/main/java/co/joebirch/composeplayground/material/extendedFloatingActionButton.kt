package co.joebirch.composeplayground.material

import androidx.compose.material.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExtendedFloatingActionButton
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

object ExtendedFloatingActionButtonView : ComposableLayout {

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
fun ExtendedFloatingActionButton() {
    ExtendedFloatingActionButton(
        onClick = {

        },
        text = {
            Text(text = "Extended")
        },
        icon = {
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = "my description"
            )
        }
    )
}

@Composable
fun ContentColorExtendedFloatingActionButton() {
    ExtendedFloatingActionButton(
        onClick = {

        },
        text = { Text(text = "Extended") },
        icon = {
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = "my description"
            )
        },
        contentColor = Color.Red
    )
}

@Composable
fun BackgroundColorExtendedFloatingActionButton() {
    ExtendedFloatingActionButton(
        onClick = {

        },
        text = { Text(text = "Extended") },
        icon = { Icon(
            imageVector = Icons.Filled.Star,
            contentDescription = "my description"
        ) },
        backgroundColor = Color.White
    )
}

@Composable
fun ElevatedExtendedFloatingActionButton() {
    ExtendedFloatingActionButton(
        onClick = {

        },
        text = { Text(text = "Extended") },
        icon = { Icon(
            imageVector = Icons.Filled.Star,
            contentDescription = "my description"
        ) },
        elevation = elevation(20.dp)
    )
}

@Composable
fun ShapeExtendedFloatingActionButton() {
    ExtendedFloatingActionButton(
        onClick = {

        },
        text = { Text(text = "Extended") },
        icon = { Icon(
            imageVector = Icons.Filled.Star,
            contentDescription = "my description"
        ) },
        shape = RectangleShape
    )
}
