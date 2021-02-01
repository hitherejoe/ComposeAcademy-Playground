package co.joebirch.composeplayground.material

import androidx.compose.material.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import co.joebirch.composeplayground.ComposableLayout

object SnackbarView : ComposableLayout {

    @Composable
    override fun build() {
        Box(
            modifier = Modifier.fillMaxSize().padding(16.dp)
                .background(Color.LightGray)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                MinimalSnackbarComponent()
                ActionSnackbarComponent()
                ActionOnNewLineSnackbarComponent()
            }
        }
    }

    @Preview
    @Composable
    fun PreviewComponent() {
        Surface(color = Color.White) {
            Text(text = "This is a snackbar!")
        }
    }

    @Composable
    fun MinimalSnackbarComponent() {
        Snackbar(
            text = { Text(text = "This is a snackbar!") }
        )
    }

    @Composable
    fun ShapeSnackbarComponent() {
        Snackbar(
            text = { Text(text = "This is a snackbar!") },
            shape = RoundedCornerShape(4.dp)
        )
    }

    @Composable
    fun BackgroundColorSnackbarComponent() {
        Snackbar(
            text = { Text(text = "This is a snackbar!") },
            backgroundColor = Color.White
        )
    }

    @Composable
    fun ElevationSnackbarComponent() {
        Snackbar(
            text = { Text(text = "This is a snackbar!") },
            elevation = 8.dp
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
                        color = MaterialTheme.colors.primary
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
                        color = MaterialTheme.colors.primary
                    )
                )
            },
            actionOnNewLine = true
        )
    }
}