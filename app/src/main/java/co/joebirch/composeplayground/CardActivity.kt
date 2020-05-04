package co.joebirch.composeplayground

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.Model
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.foundation.Border
import androidx.ui.foundation.Text
import androidx.ui.foundation.selection.ToggleableState
import androidx.ui.foundation.shape.corner.CornerSize
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp

class CardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Column(modifier = Modifier.wrapContentSize(align = Alignment.Center)
                        .padding(16.dp)) {
                    MinimalCardComponent()
                    Spacer(modifier = Modifier.preferredHeight(32.dp))
                }
            }
        }
    }

    @Composable
    fun MinimalCardComponent() {
        Card {
            Text(text = "Jetpack Compose",
                    modifier = Modifier.padding(16.dp))
        }
    }

    @Composable
    fun MultipleChildCardComponent() {
        Card {
            Column {
                Text(text = "Jetpack",
                        modifier = Modifier.padding(16.dp))
                Spacer(modifier = Modifier.preferredHeight(8.dp))
                Text(text = "Compose",
                        modifier = Modifier.padding(16.dp))
            }

        }
    }

    @Composable
    fun ShapeCardComponent() {
        Card(
                shape = RoundedCornerShape(3.dp)
        ) {
            Text(text = "Jetpack Compose",
                    modifier = Modifier.padding(16.dp))
        }
    }

    @Composable
    fun ColorCardComponent() {
        Card(
                color = Color.LightGray
        ) {
            Text(text = "Jetpack Compose",
                    modifier = Modifier.padding(16.dp))
        }
    }

    @Composable
    fun ContentColorCardComponent() {
        Card(
                color = Color.Black,
                contentColor = Color.White
        ) {
            Text(text = "Jetpack Compose",
                    modifier = Modifier.padding(16.dp))
        }
    }

    @Composable
    fun BorderCardComponent() {
        Card(
                border = Border(2.dp, Color.Black)
        ) {
            Text(text = "Jetpack Compose",
                    modifier = Modifier.padding(16.dp))
        }
    }

    @Composable
    fun ElevationCardComponent() {
        Card(
                elevation = 12.dp
        ) {
            Text(text = "Jetpack Compose",
                    modifier = Modifier.padding(16.dp))
        }
    }

    @Preview
    @Composable
    fun DefaultPreview() {
        MaterialTheme {
            Surface(modifier = Modifier.padding(16.dp),
            color = Color.White) {
                MultipleChildCardComponent()
            }
        }
    }
}