package co.joebirch.composeplayground

import android.os.Bundle
import android.widget.Toast
import androidx.animation.*
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.Model
import androidx.ui.animation.Transition
import androidx.ui.animation.animate
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.core.gesture.*
import androidx.ui.core.setContent
import androidx.ui.foundation.Border
import androidx.ui.foundation.Box
import androidx.ui.foundation.Text
import androidx.ui.foundation.selection.ToggleableState
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp

class SingleValueAnimationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Column(modifier = Modifier.wrapContentSize(align = Alignment.Center)) {
                    MinimalSwitchComponent()
                }
            }
        }
    }

    @Composable
    fun MinimalSwitchComponent() {
        Stack(modifier = Modifier.fillMaxSize()) {
            Box(
                backgroundColor = Color.LightGray,
                modifier = Modifier.matchParentSize(),
                    border = Border(2.dp, Color.Black)
            )

            Text(
                text = ("Top!"),
                modifier = Modifier.gravity(Alignment.TopCenter).padding(16.dp)
            )

            Text(
                text = ("Left!"),
                modifier = Modifier.gravity(Alignment.CenterStart).padding(16.dp)
            )

            Text(
                text = ("Right!"),
                modifier = Modifier.gravity(Alignment.CenterEnd).padding(16.dp)
            )

            Text(
                text = ("Bottom!"),
                modifier = Modifier.gravity(Alignment.BottomCenter).padding(16.dp)
            )
        }

    }

    @Preview
    @Composable
    fun DefaultPreview() {
        MaterialTheme {
            MinimalSwitchComponent()
        }
    }
}