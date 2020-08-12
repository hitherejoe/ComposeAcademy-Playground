package co.joebirch.composeplayground.foundation

import androidx.compose.foundation.Box
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
            horizontalGravity = Alignment.CenterHorizontally
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
        shape = CutCornerShape(12.dp),
        backgroundColor = Color.Blue
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
        shape = CutCornerShape(12.dp, 4.dp, 12.dp, 4.dp),
        backgroundColor = Color.Blue
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
        shape = CutCornerShape(12f, 4f, 12f, 4f),
        backgroundColor = Color.Blue
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
        shape = CutCornerShape(40, 20, 50, 10),
        backgroundColor = Color.Blue
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
        shape = RoundedCornerShape(12.dp),
        backgroundColor = Color.Blue
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
        shape = RoundedCornerShape(12.dp, 0.dp, 12.dp, 0.dp),
        backgroundColor = Color.Blue
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
        shape = GenericShape(builder = {
            this.addOval(
                Rect(
                    top = 0f,
                    bottom = 175f,
                    left = -50f,
                    right = 320f
                )
            )
        }),
        backgroundColor = Color.Blue
    )
}