package co.joebirch.composeplayground.material

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.Icon
import androidx.ui.graphics.Color
import androidx.ui.graphics.RectangleShape
import androidx.ui.layout.Arrangement
import androidx.ui.layout.Column
import androidx.ui.layout.fillMaxSize
import androidx.ui.layout.padding
import androidx.ui.material.FloatingActionButton
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.filled.Star
import androidx.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object FloatingActionButtonView: ComposableLayout {

    @Composable
    override fun build() {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalGravity = Alignment.CenterHorizontally
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
        Icon(asset = Icons.Filled.Star)
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
        Icon(asset = Icons.Filled.Star)
    }
}

@Composable
fun ElevatedFloatingActionButton() {
    FloatingActionButton(
        onClick = {

        },
        elevation = 20.dp
    ) {
        Icon(asset = Icons.Filled.Star)
    }
}

@Composable
fun ShapeFloatingActionButton() {
    FloatingActionButton(
        onClick = {

        },
        shape = RectangleShape
    ) {
        Icon(asset = Icons.Filled.Star)
    }
}