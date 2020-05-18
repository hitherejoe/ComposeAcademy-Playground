package co.joebirch.composeplayground.core

import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.core.gesture.*
import androidx.ui.foundation.Text
import androidx.ui.layout.*
import androidx.ui.material.Snackbar
import androidx.ui.unit.PxPosition
import androidx.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object GestureView : ComposableLayout {

    @Composable
    override fun build() {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalGravity = Alignment.CenterHorizontally
        ) {
            TapComponent()
            DoubleTapComponent()
            LongPressComponent()
            LongPressDragComponent()
        }
    }

}

@Composable
fun TapComponent() {
    val showSnackbar = state { false }
    Column(horizontalGravity = Alignment.CenterHorizontally) {
        Text(
            text = "Jetpack Compose",
            modifier = Modifier.padding(16.dp).tapGestureFilter(onTap = {
                showSnackbar.value = !showSnackbar.value
            })
        )
        if (showSnackbar.value) {
            Snackbar(text = {
                Text(text = "Tap again to hide")
            })
        }
    }
}

@Composable
fun DoubleTapComponent() {
    val showSnackbar = state { false }
    Column(horizontalGravity = Alignment.CenterHorizontally) {
        Text(
            text = "Jetpack Compose",
            modifier = Modifier.padding(16.dp).doubleTapGestureFilter(onDoubleTap = {
                showSnackbar.value = !showSnackbar.value
            })
        )
        if (showSnackbar.value) {
            Snackbar(text = {
                Text(text = "Double tap again to hide")
            })
        }
    }
}

@Composable
fun LongPressComponent() {
    val showSnackbar = state { false }
    Column(horizontalGravity = Alignment.CenterHorizontally) {

        Text(
            text = "Jetpack Compose",
            modifier = Modifier.padding(16.dp).longPressGestureFilter(onLongPress = {
                showSnackbar.value = !showSnackbar.value
            })
        )
        if (showSnackbar.value) {
            Snackbar(text = {
                Text(text = "Long press the text to hide")
            })
        }
    }
}

@Composable
fun LongPressDragComponent() {
    val showSnackbar = state { false }
    Column(horizontalGravity = Alignment.CenterHorizontally) {

        Text(
            text = "Jetpack Compose",
            modifier = Modifier.padding(16.dp).longPressDragGestureFilter(
                object : LongPressDragObserver {

                    override fun onLongPress(pxPosition: PxPosition) {
                        super.onLongPress(pxPosition)

                        //Toast.makeText(ContextAmbient.current, "Long pressed!!", LENGTH_SHORT)
                    }

                    override fun onDrag(dragDistance: PxPosition): PxPosition {
                        // Toast.makeText(ContextAmbient.current, "Dragged: " + dragDistance.x +
                        //   " : " + dragDistance.y, LENGTH_SHORT)
                        return super.onDrag(dragDistance)
                    }

                    override fun onDragStart() {
                        super.onDragStart()
                        showSnackbar.value = true
                    }

                    override fun onCancel() {
                        super.onCancel()
                    }

                    override fun onStop(velocity: PxPosition) {
                        showSnackbar.value = false
                        super.onStop(velocity)
                    }
                }
            )
        )
        if (showSnackbar.value) {
            Snackbar(text = {
                Text(text = "Dragging in progress")
            })
        }
    }
}