package co.joebirch.composeplayground.material

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.ButtonDefaults.elevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object ButtonView : ComposableLayout {

    @Composable
    override fun build() {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MinimalButtonComponent()
            BorderButtonComponent()
            DisabledButtonComponent()
            ShapeButtonComponent()
        }
    }

}

@Preview
@Composable
fun MinimalButtonComponent() {
    Button(onClick = {

    }) {
        Text(
            text = "Jetpack Compose",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview
@Composable
fun ShapeButtonComponent() {
    Button(
        onClick = {

        },
        shape = CutCornerShape(12.dp)
    ) {
        Text(
            text = "Jetpack Compose",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview
@Composable
fun BackgroundColorButtonComponent() {
    Button(
        onClick = {

        },
        colors = buttonColors(
            backgroundColor = Color.Red
        )
    ) {
        Text(
            text = "Jetpack Compose",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview
@Composable
fun ContentColorButtonComponent() {
    Button(
        onClick = {

        },
        colors = buttonColors(
            contentColor = Color.Black
        )
    ) {
        Text(
            text = "Jetpack Compose",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview
@Composable
fun DisabledBackgroundColorButtonComponent() {
    Button(
        enabled = false,
        onClick = {

        },
        colors = buttonColors(
            disabledBackgroundColor = Color.Gray
        )
    ) {
        Text(
            text = "Jetpack Compose",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview
@Composable
fun DisabledContentColorButtonComponent() {
    Button(
        enabled = false,
        onClick = {

        },
        colors = buttonColors(
            disabledBackgroundColor = Color.Gray,
            disabledContentColor = Color.Black,
        )
    ) {
        Text(
            text = "Jetpack Compose",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview
@Composable
fun ContentPaddingButtonComponent() {
    Button(
        onClick = {

        },
        contentPadding = PaddingValues(32.dp)
    ) {
        Text(
            text = "Jetpack Compose",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview
@Composable
fun ElevationPaddingButtonComponent() {
    Box(
        modifier = Modifier.height(100.dp)
            .width(200.dp)
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = {

            },
            elevation = elevation(
                defaultElevation = 12.dp,
                pressedElevation = 12.dp,
                disabledElevation = 2.dp,
            )
        ) {
            Text(
                text = "Jetpack Compose",
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Preview
@Composable
fun BorderButtonComponent() {
    Button(
        onClick = {

        },
        border = BorderStroke(2.dp, Color.Red)
    ) {
        Text(
            text = "Jetpack Compose",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview
@Composable
fun DisabledButtonComponent() {
    Button(
        onClick = {

        },
        enabled = false
    ) {
        Text(
            text = "Jetpack Compose",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview
@Composable
fun OutlinedButtonComponent() {
    OutlinedButton(onClick = {

    }) {
        Text(
            text = "Jetpack Compose",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview
@Composable
fun TextButtonComponent() {
    TextButton(onClick = {

    }) {
        Text(
            text = "Jetpack Compose",
            modifier = Modifier.padding(16.dp)
        )
    }
}
