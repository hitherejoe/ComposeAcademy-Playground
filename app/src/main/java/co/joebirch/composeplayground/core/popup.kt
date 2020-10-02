package co.joebirch.composeplayground.core

import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.state
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import co.joebirch.composeplayground.ComposableLayout

object PopupView : ComposableLayout {

    @Composable
    override fun build() {
        val showingStandardPopup = state { false }
        val showingStandardPopupWithProperties = state { false }
        val showingDropdownPopup = state { false }
        Box(
            modifier = Modifier.fillMaxSize().padding(32.dp)
        ) {
            Column(modifier = Modifier.align(Alignment.Center)) {

                Button(onClick = {
                    showingStandardPopup.value = !showingStandardPopup.value
                }) {
                    Text(text = "Standard Popup")
                }

                Spacer(modifier = Modifier.preferredHeight(16.dp))

                Button(onClick = {
                    showingStandardPopupWithProperties.value =
                        !showingStandardPopupWithProperties.value
                }) {
                    Text(text = "Standard Popup with Properties")
                }

                Spacer(modifier = Modifier.preferredHeight(16.dp))

                Spacer(modifier = Modifier.preferredHeight(16.dp))
            }

            when {
                showingStandardPopup.value -> StandardPopup()
                showingStandardPopupWithProperties.value -> {
                    StandardPopupWithProperties(onDismiss = {
                        showingStandardPopupWithProperties.value = false
                    })
                }
            }
        }
    }

}

@Composable
fun StandardPopup() {
    Popup {
        Box {
            Box(
                Modifier.preferredSize(200.dp, 50.dp)
                    .background(
                        shape = RoundedCornerShape(16.dp),
                        color = Color.Black
                    )
            )
            Text(
                text = "Pop up!", modifier = Modifier.align(Alignment.Center),
                color = Color.White
            )
        }
    }
}

@Composable
fun StandardPopupWithProperties(onDismiss: () -> Unit) {
    Box {
        Popup(isFocusable = true, onDismissRequest = {
            onDismiss()
        }) {
            Box {
                Box(
                    Modifier.preferredSize(200.dp, 50.dp)
                        .background(
                            Color.Black,
                            shape = RoundedCornerShape(16.dp)
                        )
                )
                Text(
                    text = "Click to dismiss!", modifier = Modifier.align(Alignment.Center),
                    color = Color.White
                )
            }
        }
    }
}
