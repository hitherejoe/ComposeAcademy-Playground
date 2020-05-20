package co.joebirch.composeplayground.core

import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.*
import androidx.ui.foundation.Box
import androidx.ui.foundation.Text
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.Button
import androidx.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object PopupView : ComposableLayout {

    @Composable
    override fun build() {
        val showingStandardPopup = state { false }
        val showingStandardPopupWithProperties = state { false }
        val showingDropdownPopup = state { false }
        Stack(
            modifier = Modifier.fillMaxSize().padding(32.dp)
        ) {
            Column(modifier = Modifier.gravity(Alignment.Center)) {

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

                Button(onClick = {
                    showingDropdownPopup.value = !showingDropdownPopup.value
                }) {
                    Text(text = "Dropdown Popup")
                }

                Spacer(modifier = Modifier.preferredHeight(16.dp))
            }

            when {
                showingStandardPopup.value -> StandardPopup()
                showingDropdownPopup.value -> PopupDropdown()
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
        Stack {
            Box(
                Modifier.preferredSize(200.dp, 50.dp),
                shape = RoundedCornerShape(16.dp),
                backgroundColor = Color.Black
            )
            Text(
                text = "Pop up!", modifier = Modifier.gravity(Alignment.Center),
                color = Color.White
            )
        }
    }
}

@Composable
fun StandardPopupWithProperties(onDismiss: () -> Unit) {
    Box {
        Popup(popupProperties = PopupProperties(isFocusable = true, onDismissRequest = {
            onDismiss()
        })) {
            Stack {
                Box(
                    Modifier.preferredSize(200.dp, 50.dp),
                    shape = RoundedCornerShape(16.dp),
                    backgroundColor = Color.Black
                )
                Text(
                    text = "Click to dismiss!", modifier = Modifier.gravity(Alignment.Center),
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun PopupDropdown() {
    DropdownPopup(dropDownAlignment = DropDownAlignment.End) {
        Stack {
            Box(
                Modifier.preferredSize(200.dp, 50.dp),
                shape = RoundedCornerShape(16.dp),
                backgroundColor = Color.Black
            )
            Text(
                text = "Pop up!", modifier = Modifier.gravity(Alignment.Center),
                color = Color.White
            )
        }
    }
}