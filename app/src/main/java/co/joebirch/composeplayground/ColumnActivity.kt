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

class ColumnActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                MinimalCardComponentBottom()
            }
        }
    }

    @Composable
    fun MinimalCardComponentTop() {
        Column(verticalArrangement = Arrangement.Center, modifier = Modifier.padding(16.dp).fillMaxSize()) {
            Text("Jetpack")
            Text("Compose")
        }
    }

    @Composable
    fun MinimalCardComponentBottom() {
        Row(horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier.padding(16.dp).fillMaxSize()) {
            Text("Jetpack")
            Text("Compose")
        }
    }

    @Preview
    @Composable
    fun DefaultPreview() {
        MaterialTheme {
        }
    }
}