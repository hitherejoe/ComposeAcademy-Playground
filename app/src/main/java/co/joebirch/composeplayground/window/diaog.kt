package co.joebirch.composeplayground.window

import androidx.compose.material.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.Popup
import androidx.ui.tooling.preview.Preview
import co.joebirch.composeplayground.ComposableLayout

object DialogView : ComposableLayout {

    @Composable
    override fun build() {
        val showingStandardPopup = remember { mutableStateOf(false) }

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

                if (showingStandardPopup.value) {
                    Dialog(onDismissRequest = {
                        showingStandardPopup.value = false
                    }) {
                        Column(
                            modifier = Modifier.size(300.dp, 200.dp)
                                .padding(16.dp)
                                .background(Color.White)
                                .align(Alignment.CenterHorizontally)
                        ) {
                            Text(text = "Jetpack Compose",
                                modifier = Modifier.padding(16.dp)
                                    .weight(1f))

                            TextButton(
                                onClick = {
                                    showingStandardPopup.value = false
                                },
                                modifier = Modifier.align(Alignment.End)
                                    .padding(16.dp)) {
                                Text(text = "Dismiss")
                            }
                        }
                    }
                }
            }


        }
    }
}

@Preview
@Composable
fun Dialog() {
    val showingStandardPopup = remember { mutableStateOf(false) }
    Column {

        Button(onClick = {
            showingStandardPopup.value = !showingStandardPopup.value
        }) {
            Text(text = "Standard Popup")
        }

        Spacer(modifier = Modifier.preferredHeight(16.dp))

        Dialog(onDismissRequest = {
            showingStandardPopup.value = false
        }) {
            Text(text = "Jetpack Compose")
        }
    }
}
