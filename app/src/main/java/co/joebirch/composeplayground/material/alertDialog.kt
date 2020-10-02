package co.joebirch.composeplayground.material

import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.state
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object AlertDialogView : ComposableLayout {

    @Composable
    override fun build() {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AlertDialogComponent()
        }
    }

}

@Composable
fun AlertDialogComponent() {
    val showingDialog = state { false }
    if (showingDialog.value) {
        AlertDialog(
            onDismissRequest = {
                showingDialog.value = false
            },
            text = {
                Text(text = "Body message")
            },
            title = {
                Text(text = "Title")
            },
            buttons = {
                Row(horizontalArrangement = Arrangement.End,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Close",
                        modifier = Modifier.padding(16.dp).clickable(onClick = {
                            showingDialog.value = false
                        }))
                }
            })
    }
    Button(onClick = {
        showingDialog.value = true
    }) {
        Text(
            text = "Show dialog"
        )
    }
}

@Composable
fun ContentAlertDialogComponent() {
    val showingDialog = state { false }
    if (showingDialog.value) {
        AlertDialog(
            onDismissRequest = {
                showingDialog.value = false
            },
            text = {
                Text(text = "Body message")
            },
            title = {
                Text(text = "Title")
            },
            confirmButton = {
                Text(text = "Close",
                    modifier = Modifier.padding(16.dp).clickable(onClick = {
                        showingDialog.value = false
                    }))
            },
            backgroundColor = Color.White,
            shape = RectangleShape
        )
    }
    Button(onClick = {
        showingDialog.value = true
    }) {
        Text(
            text = "Show dialog"
        )
    }
}
