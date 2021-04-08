package co.joebirch.composeplayground.core

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.material.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.Snackbar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object GestureView : ComposableLayout {

    @Composable
    override fun build() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ZoomComponent()
        }
    }

}

@Composable
fun TapComponent() {
    val showSnackbar = remember { mutableStateOf(false) }
    Box {
        Text(
            text = "Jetpack Compose",
            modifier = Modifier
                .padding(16.dp)
                .clickable {
                    showSnackbar.value = !showSnackbar.value
                }
        )
        if (showSnackbar.value) {
            Snackbar(
                content = {
                    Text(text = "Jetpack Compose")
                }
            )
        }
    }
}

@Composable
fun zoomableComponent() {
    val showSnackbar = remember { mutableStateOf(false) }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Jetpack Compose",
            modifier = Modifier
                .padding(16.dp)
                .clickable {
                    showSnackbar.value = !showSnackbar.value
                }
        )
        if (showSnackbar.value) {
            Snackbar(content = {
                Text(text = "Tap again to hide")
            })
        }
    }
}

@Composable
fun DoubleTapComponent() {
    val showSnackbar = remember { mutableStateOf(false) }
    Box {
        Text(
            text = "Jetpack Compose",
            modifier = Modifier
                .padding(16.dp)
                .pointerInput(Unit) {
                    detectTapGestures {
                        showSnackbar.value = !showSnackbar.value

                    }
                }
        )
        if (showSnackbar.value) {
            Snackbar(content = {
                Text(text = "Double tap again to hide")
            })
        }
    }
}

@Composable
fun LongPressComponent() {
    val showSnackbar = remember { mutableStateOf(false) }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        Text(
            text = "Jetpack Compose",
            modifier = Modifier
                .padding(16.dp)
                .pointerInput(Unit) {
                    detectTapGestures(onLongPress = {
                        showSnackbar.value = !showSnackbar.value
                    })
                }
        )
        if (showSnackbar.value) {
            Snackbar(content = {
                Text(text = "Long press the text to hide")
            })
        }
    }
}

@Composable
fun ZoomComponent() {
    var scale = remember { mutableStateOf(1f) }
    var translate = remember { mutableStateOf(Offset(0f, 0f)) }

    /*
    Image(
        bitmap = imageResource(id = R.drawable.screen),
        contentDescription = "my description",
        modifier = Modifier
            .graphicsLayer(
                scaleX = if (scale.value < 1) 1f else scale.value,
                scaleY = if (scale.value < 1) 1f else scale.value,
                translationX = translate.value.x,
                translationY = translate.value.y
            )
        .fillMaxSize()
        .rawDragGestureFilter(object : DragObserver {
            override fun onDrag(dragDistance: Offset): Offset {
                if (scale.value > 1) {
                    Log.e("LOG", translate.value.x.toString())
                    translate.value = translate.value.plus(dragDistance)
                }
                return super.onDrag(dragDistance)
            }
        })
        .zoomable(
            onZoomDelta = {
                scale.value *= it
                Log.e("VALUE", it.toString())
            }
        ))
     */
}