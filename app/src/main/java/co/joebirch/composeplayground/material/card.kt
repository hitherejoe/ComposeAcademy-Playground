package co.joebirch.composeplayground.material

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.material.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object CardView: ComposableLayout {

    @Composable
    override fun build() {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MinimalCardComponent()
            MultipleChildCardComponent()
            ShapeCardComponent()
            ColorCardComponent()
            ContentColorCardComponent()
            BorderCardComponent()
            ElevationCardComponent()
        }
    }

}

@Composable
fun MinimalCardComponent() {
    Card {
        Text(
            text = "Jetpack Compose",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = false)
@Composable
fun CardPreview() {
    MinimalCardComponent()
}

@Composable
fun MultipleChildCardComponent() {
    Card {
        Column {
            Text(
                text = "Jetpack",
                modifier = Modifier.padding(16.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Compose",
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Preview(showBackground = false)
@Composable
fun CardMultipleChildPreview() {
    MultipleChildCardComponent()
}

@Composable
fun ShapeCardComponent() {
    Card(
        shape = RectangleShape,
        backgroundColor = Color.LightGray
    ) {
        Text(
            text = "Jetpack Compose",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun ColorCardComponent() {
    Card(
        backgroundColor = Color.LightGray
    ) {
        Text(
            text = "Jetpack Compose",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun ContentColorCardComponent() {
    Card(
        backgroundColor = Color.Black,
        contentColor = Color.White
    ) {
        Text(
            text = "Jetpack Compose",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun BorderCardComponent() {
    Card(
        border = BorderStroke(2.dp, Color.Black)
    ) {
        Text(
            text = "Jetpack Compose",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun ElevationCardComponent() {
    Card(
        elevation = 12.dp
    ) {
        Text(
            text = "Jetpack Compose",
            modifier = Modifier.padding(16.dp)
        )
    }
}


@Preview
@Composable
fun ElevationCardComponent_Preview() {
    Box(
        modifier = Modifier.background(Color.White)
            .height(100.dp).width(200.dp),
        contentAlignment = Alignment.Center
    ) {
        ElevationCardComponent()
    }
}

@Preview
@Composable
fun BorderCardComponent_Preview() {
    Box(
        modifier = Modifier.background(Color.White)
            .height(100.dp).width(200.dp),
        contentAlignment = Alignment.Center
    ) {
        BorderCardComponent()
    }
}

@Preview
@Composable
fun ContentColorCardComponent_Preview() {
    Box(
        modifier = Modifier.background(Color.White)
            .height(100.dp).width(200.dp),
        contentAlignment = Alignment.Center
    ) {
        ContentColorCardComponent()
    }
}

@Preview
@Composable
fun ColorCardComponent_Preview() {
    Box(
        modifier = Modifier.background(Color.White)
            .height(100.dp).width(200.dp),
        contentAlignment = Alignment.Center
    ) {
        ColorCardComponent()
    }
}

@Preview
@Composable
fun ShapeCardComponent_Preview() {
    Box(
        modifier = Modifier.background(Color.White)
            .height(100.dp).width(200.dp),
        contentAlignment = Alignment.Center
    ) {
        ShapeCardComponent()
    }
}