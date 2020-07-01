package co.joebirch.composeplayground.material

import androidx.compose.Composable
import androidx.compose.remember
import androidx.compose.state
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.Text
import androidx.ui.foundation.clickable
import androidx.ui.layout.*
import androidx.ui.material.AlertDialog
import androidx.ui.material.Button
import androidx.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object AlertDialogView : ComposableLayout {

    @Composable
    override fun build() {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalGravity = Alignment.CenterHorizontally
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
            onCloseRequest = {
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
