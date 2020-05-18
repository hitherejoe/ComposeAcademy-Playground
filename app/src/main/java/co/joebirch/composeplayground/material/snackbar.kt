package co.joebirch.composeplayground.material

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.Box
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.Text
import androidx.ui.graphics.Color
import androidx.ui.layout.Arrangement
import androidx.ui.layout.Column
import androidx.ui.layout.fillMaxSize
import androidx.ui.layout.padding
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Snackbar
import androidx.ui.material.ripple.ripple
import androidx.ui.material.snackbarPrimaryColorFor
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object SnackbarView: ComposableLayout {

    @Composable
    override fun build() {
        Box(
            modifier = Modifier.fillMaxSize(),
            backgroundColor = Color.LightGray
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalGravity = Alignment.CenterHorizontally
            ) {
                MinimalSnackbarComponent()
                ActionSnackbarComponent()
                ActionOnNewLineSnackbarComponent()
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
                        modifier = Modifier.padding(end = 16.dp).ripple(),
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
                        modifier = Modifier.padding(end = 16.dp).ripple(),
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