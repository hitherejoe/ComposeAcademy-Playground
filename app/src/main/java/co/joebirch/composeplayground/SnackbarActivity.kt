package co.joebirch.composeplayground

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.Text
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.unit.dp

class SnackbarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Column(modifier = Modifier.wrapContentSize(align = Alignment.Center)
                    .padding(32.dp)) {
                    MinimalSnackbarComponent()
                    Spacer(modifier = Modifier.preferredHeight(120.dp))
                    ActionSnackbarComponent()
                    Spacer(modifier = Modifier.preferredHeight(120.dp))
                    ActionOnNewLineSnackbarComponent()
                }
            }
        }
    }

    @Composable
    fun MinimalSnackbarComponent() {
        Snackbar(
            text = { Text(text = "This is a snackbar!") }
        )
    }

    @Composable
    fun ActionSnackbarComponent() {
        Snackbar(
            text = { Text(text = "This is a snackbar!") },
            action = {
                Clickable(onClick = {
                    // Handle action
                }) {
                    Text(
                        text = "Undo",
                        modifier = Modifier.padding(end = 16.dp),
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            color = snackbarPrimaryColorFor(MaterialTheme.colors)
                        )
                    )
                }
            }
        )
    }

    @Composable
    fun ActionOnNewLineSnackbarComponent() {
        Snackbar(
            text = { Text(text = "This is a snackbar with a lot of text, that way it makes sense to use the new line!") },
            action = {
                Clickable(onClick = {
                    // Handle action
                }) {
                    Text(
                        text = "Undo",
                        modifier = Modifier.padding(end = 16.dp),
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            color = snackbarPrimaryColorFor(MaterialTheme.colors)
                        )
                    )
                }
            },
            actionOnNewLine = true
        )
    }
}