package co.joebirch.composeplayground.foundation

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.Box
import androidx.ui.foundation.Text
import androidx.ui.foundation.shape.GenericShape
import androidx.ui.foundation.shape.corner.CutCornerShape
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.geometry.Rect
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.text.style.TextAlign
import androidx.ui.unit.dp
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