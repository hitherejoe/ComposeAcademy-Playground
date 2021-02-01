package co.joebirch.composeplayground.layout

import androidx.compose.material.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import co.joebirch.composeplayground.ComposableLayout

object BoxView : ComposableLayout {

    @Composable
    override fun build() {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Item"
            )
            Text(
                text = "This is another item"
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun alignmentTopStart() {
    Box(
        modifier = Modifier
            .size(200.dp, 200.dp)
            .padding(16.dp),
        contentAlignment = Alignment.TopStart
    ) {
        Text(
            text = "Jetpack"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun alignmentTopCenter() {
    Box(
        modifier = Modifier
            .size(200.dp, 200.dp)
            .padding(16.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Text(
            text = "Jetpack"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun alignmentTopEnd() {
    Box(
        modifier = Modifier
            .size(200.dp, 200.dp)
            .padding(16.dp),
        contentAlignment = Alignment.TopEnd
    ) {
        Text(
            text = "Jetpack"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun one() {
    Box(
        modifier = Modifier.size(200.dp, 200.dp)
            .padding(16.dp)
    ) {
        Text(
            text = "Compose",
            modifier = Modifier
                .align(Alignment.TopStart)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun two() {
    Box(
        modifier = Modifier.size(200.dp, 200.dp)
            .padding(16.dp)
    ) {
        Text(
            text = "Compose",
            modifier = Modifier
                .align(Alignment.TopCenter)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun three() {
    Box(
        modifier = Modifier.size(200.dp, 200.dp)
            .padding(16.dp)
    ) {
        Text(
            text = "Compose",
            modifier = Modifier
                .align(Alignment.TopEnd)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun four() {
    Box(
        modifier = Modifier.size(200.dp, 200.dp)
            .padding(16.dp)
    ) {
        Text(
            text = "Compose",
            modifier = Modifier
                .align(Alignment.CenterStart)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun five() {
    Box(
        modifier = Modifier.size(200.dp, 200.dp)
            .padding(16.dp)
    ) {
        Text(
            text = "Compose",
            modifier = Modifier
                .align(Alignment.Center)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun six() {
    Box(
        modifier = Modifier.size(200.dp, 200.dp)
            .padding(16.dp)
    ) {
        Text(
            text = "Compose",
            modifier = Modifier
                .align(Alignment.CenterEnd)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun seven() {
    Box(
        modifier = Modifier.size(200.dp, 200.dp)
            .padding(16.dp)
    ) {
        Text(
            text = "Compose",
            modifier = Modifier
                .align(Alignment.BottomEnd)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun eight() {
    Box(
        modifier = Modifier.size(200.dp, 200.dp)
            .padding(16.dp)
    ) {
        Text(
            text = "Compose",
            modifier = Modifier
                .align(Alignment.BottomCenter)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun nine() {
    Box(
        modifier = Modifier.size(200.dp, 200.dp)
            .padding(16.dp)
    ) {
        Text(
            text = "Compose",
            modifier = Modifier
                .align(Alignment.BottomEnd)
        )
    }
}