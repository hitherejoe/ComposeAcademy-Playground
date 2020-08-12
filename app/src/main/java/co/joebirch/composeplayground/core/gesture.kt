package co.joebirch.composeplayground.core
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Snackbar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.state
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.gesture.*
import androidx.compose.ui.unit.dp
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

                    override fun onLongPress(offset: Offset) {
                        super.onLongPress(offset)

                        //Toast.makeText(ContextAmbient.current, "Long pressed!!", LENGTH_SHORT)
                    }

                    override fun onDrag(offset: Offset): Offset {
                        // Toast.makeText(ContextAmbient.current, "Dragged: " + dragDistance.x +
                        //   " : " + dragDistance.y, LENGTH_SHORT)
                        return super.onDrag(offset)
                    }

                    override fun onDragStart() {
                        super.onDragStart()
                        showSnackbar.value = true
                    }

                    override fun onCancel() {
                        super.onCancel()
                    }

                    override fun onStop(offset: Offset) {
                        showSnackbar.value = false
                        super.onStop(offset)
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