package co.joebirch.composeplayground.unit

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.*
import co.joebirch.composeplayground.ComposableLayout
import kotlin.ranges.coerceAtLeast
import kotlin.ranges.coerceAtMost
import kotlin.ranges.coerceIn

object DpView : ComposableLayout {

    @Composable
    override fun build() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(48.dp))
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

    val timesFloat = 8.dp * 6f
    val timesInt = 8.dp * 6

    val doubleTimes = 8.0 * 6.dp

    val intTimes = 8 * 6.dp

    val floatTimes = 8f * 6.dp

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

}


@Composable
fun DisplaySize() {

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
