package co.joebirch.composeplayground.unit

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.VerticalScroller
import androidx.ui.geometry.Size
import androidx.ui.layout.*
import androidx.ui.unit.*
import co.joebirch.composeplayground.ComposableLayout

object DpView : ComposableLayout {

    @Composable
    override fun build() {
        VerticalScroller {
            Column(
                modifier = Modifier.fillMaxSize().padding(32.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalGravity = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(48.dp))
            }
        }
    }

}

@Composable
fun DisplayPixels() {
    val intAsDp = 8.dp
    val floatAsDp = 8f.dp
    val doubleAsDp = 8.5.dp
    val constructor = Dp(8f)

    val plus = 8.dp + 6.dp
    val minus = 8.dp - 6.dp
    val unaryMinus = 8.dp - (-8).dp

    val times = 8.dp * 6.dp
    val timesFloat = 8.dp * 6f
    val timesInt = 8.dp * 6

    val doubleTimes = 8.0 * 6.dp
    val doubleDivide = 8.0 / 6.dp

    val intTimes = 8 * 6.dp
    val intDivide = 8 / 6.dp

    val floatTimes = 8f * 6.dp
    val floatDivide = 8f / 6.dp

    val divide = 8.dp / 6.dp
    val divideFloat = 8.dp / 6f
    val divideInt = 8.dp / 6

    val min = min(6.dp, 12.dp)
    val max = max(6.dp, 12.dp)

    val hairline = Dp.Hairline
    val infinity = Dp.Infinity
    val unspecified = Dp.Unspecified

    val coerceIn = 8.dp.coerceIn(6.dp, 12.dp)
    val coerceAtLeast = 8.dp.coerceAtLeast(6.dp)
    val coerceAtMost = 8.dp.coerceAtMost(6.dp)
    val isFinite = 8.dp.isFinite()

}

@Composable
fun DisplayPixelsSquared() {
    val constructor = DpSquared(8f)

    val plus = DpSquared(8f) + DpSquared(8f)
    val minus = DpSquared(8f) - DpSquared(8f)

    val timesFloat = DpSquared(8f) * 6f
    val divideFloat = DpSquared(8f) / 6f
    val divideDp = DpSquared(8f) / 6.dp
    val divideDpSquared = DpSquared(8f) / DpSquared(2f)
}

@Composable
fun DisplayPixelsCubed() {
    val constructor = DpCubed(8f)

    val plus = DpCubed(8f) + DpCubed(8f)
    val minus = DpCubed(8f) - DpCubed(8f)

    val timesFloat = DpCubed(8f) * 6f
    val divideFloat = DpCubed(8f) / 6f
    val divideDp = DpCubed(8f) / 6.dp
    val divideDpp = DpCubed(8f) / DpSquared(6f)
    val divideDpSquared = DpCubed(8f) / DpCubed(2f)
}

@Composable
fun DisplayPixelsInverse() {
    val constructor = DpInverse(8f)

    val plus = DpInverse(8f) + DpInverse(8f)
    val minus = DpInverse(8f) - DpInverse(8f)

    val timesFloat = DpInverse(8f) * 6f
    val timesDp = DpInverse(8f) * 6.dp
    val timesDps = DpInverse(8f) * DpSquared(6f)
    val timesDpc = DpInverse(8f) * DpCubed(6f)
}

@Composable
fun DisplaySize() {
    val constructor = Size(8)

    val width = constructor.width
    val height = constructor.height
/*
    val timesFloat = Size(8) * 6f
    val timesInt = Size(8) * 6
    val timesDouble = Size(8) * 6.8

    val divFloat = Size(8) / 6f
    val divInt = Size(8) / 6
    val divDouble = Size(8) / 6.8

    val constructorSize = Size(8.dp, 8.dp)

    val timesSizeFloat = 6f * constructorSize
    val timesSizeInt = 6 * constructorSize
    val timesSizeDouble = 6.8 * constructorSize
    */
}

@Composable
fun DisplayPosition() {
    val constructor = Position(8)

    val width = constructor.x
    val height = constructor.y

    val plus = Position(8) + Position(2)
    val minus = Position(8) - Position(2)

    val constructorXY = Position(8.dp, 6.dp)

    val distance = constructor.getDistance()
}

@Composable
fun DisplayBounds() {
    val constructor = Bounds(0.dp, 200.dp, 200.dp, 0.dp)

    val width = constructor.width
    val height = constructor.height
   // val size = constructor.toSize()

   // val bounds = size.toBounds()
}