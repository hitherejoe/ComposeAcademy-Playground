package co.joebirch.composeplayground.material

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.Border
import androidx.ui.foundation.Text
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.Card
import androidx.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object CardView: ComposableLayout {

    @Composable
    override fun build() {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalGravity = Alignment.CenterHorizontally
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

@Composable
fun MultipleChildCardComponent() {
    Card {
        Column {
            Text(
                text = "Jetpack",
                modifier = Modifier.padding(16.dp)
            )
            Spacer(modifier = Modifier.preferredHeight(8.dp))
            Text(
                text = "Compose",
                modifier = Modifier.padding(16.dp)
            )
        }

    }
}

@Composable
fun ShapeCardComponent() {
    Card(
        shape = RoundedCornerShape(3.dp)
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
        color = Color.LightGray
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
        color = Color.Black,
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
        border = Border(2.dp, Color.Black)
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