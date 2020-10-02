package co.joebirch.composeplayground.foundation

import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object ShapeView : ComposableLayout {

    @Composable
    override fun build() {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CutCornerShapeComponent()
            RoundedCornerShapeComponent()
            AlternateCutCornerShapeComponent()
            AlternateRoundedCornerShapeComponent()
            CustomShapeComponent()
        }
    }

}

@Composable
fun CutCornerShapeComponent() {
    Box(
        modifier = Modifier.background(Color.Blue, shape = CutCornerShape(12.dp))
    ) {
        Text(
            text = "Cut corner shape",
            modifier = Modifier.padding(16.dp),
            color = Color.White
        )
    }
}

@Composable
fun AlternateCutCornerShapeComponent() {
    Box(
        modifier = Modifier.background(Color.Blue, shape = CutCornerShape(12.dp, 4.dp, 12.dp, 4.dp))
    ) {
        Text(
            text = "Cut corner shape",
            modifier = Modifier.padding(16.dp),
            color = Color.White
        )
    }
}

@Composable
fun FloatCutCornerShapeComponent() {
    Box(
        modifier = Modifier.background(Color.Blue, shape = CutCornerShape(12f, 4f, 12f, 4f))
    ) {
        Text(
            text = "Cut corner shape",
            modifier = Modifier.padding(16.dp),
            color = Color.White
        )
    }
}

@Composable
fun PercentCutCornerShapeComponent() {
    Box(
        modifier = Modifier.background(Color.Blue, shape = CutCornerShape(40, 20, 50, 10))
    ) {
        Text(
            text = "Cut corner shape",
            modifier = Modifier.padding(16.dp),
            color = Color.White
        )
    }
}

@Composable
fun RoundedCornerShapeComponent() {
    Box(
        modifier = Modifier.background(Color.Blue, shape = RoundedCornerShape(12.dp))
    ) {
        Text(
            text = "Rounded corner shape",
            modifier = Modifier.padding(16.dp),
            color = Color.White
        )
    }
}

@Composable
fun AlternateRoundedCornerShapeComponent() {
    Box(
        modifier = Modifier.background(
            Color.Blue,
            shape = RoundedCornerShape(12.dp, 0.dp, 12.dp, 0.dp)
        )
    ) {
        Text(
            text = "Rounded corner shape",
            modifier = Modifier.padding(16.dp),
            color = Color.White
        )
    }
}

@Composable
fun CustomShapeComponent() {
    Box(
        modifier = Modifier.background(Color.Blue, shape = GenericShape(builder = {
            this.addOval(
                Rect(
                    top = 0f,
                    bottom = 175f,
                    left = -50f,
                    right = 320f
                )
            )
        }))
    )
}