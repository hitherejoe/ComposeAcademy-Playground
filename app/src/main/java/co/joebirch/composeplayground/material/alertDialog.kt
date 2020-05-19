package co.joebirch.composeplayground.material

import androidx.compose.Composable
import androidx.compose.remember
import androidx.compose.state
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.Border
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.Text
import androidx.ui.foundation.shape.corner.CutCornerShape
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.AlertDialog
import androidx.ui.material.Button
import androidx.ui.material.Card
import androidx.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout
import kotlinx.coroutines.delay
import java.util.*
import kotlin.concurrent.schedule
import kotlin.concurrent.timer
import kotlin.concurrent.timerTask

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
                    Clickable(onClick = {
                        showingDialog.value = false
                    }) {
                        Text(text = "Close",
                            modifier = Modifier.padding(16.dp))
                    }
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
