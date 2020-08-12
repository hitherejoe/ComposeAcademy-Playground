package co.joebirch.composeplayground.material

import androidx.compose.foundation.Box
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Snackbar
import androidx.compose.material.snackbarPrimaryColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object SnackbarView : ComposableLayout {

    @Composable
    override fun build() {
        Box(
            modifier = Modifier.fillMaxSize().padding(16.dp),
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
                Text(
                    text = "Undo",
                    modifier = Modifier.padding(end = 16.dp).clickable(onClick = {
                        // handle action
                    }),
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        color = snackbarPrimaryColorFor(MaterialTheme.colors)
                    )
                )
            }
        )
    }

    @Composable
    fun ActionOnNewLineSnackbarComponent() {
        Snackbar(
            text = { Text(text = "This is a snackbar with a lot of text, that way it makes sense to use the new line!") },
            action = {
                Text(
                    text = "Undo",
                    modifier = Modifier.padding(end = 16.dp).clickable(onClick = {
                        // Handle action
                    }),
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        color = snackbarPrimaryColorFor(MaterialTheme.colors)
                    )
                )
            },
            actionOnNewLine = true
        )
    }
}