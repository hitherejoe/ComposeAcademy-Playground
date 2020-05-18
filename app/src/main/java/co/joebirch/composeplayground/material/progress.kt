package co.joebirch.composeplayground.material

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.graphics.Color
import androidx.ui.layout.Arrangement
import androidx.ui.layout.Column
import androidx.ui.layout.fillMaxSize
import androidx.ui.layout.padding
import androidx.ui.material.CircularProgressIndicator
import androidx.ui.material.LinearProgressIndicator
import androidx.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object ProgressView: ComposableLayout {

    @Composable
    override fun build() {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalGravity = Alignment.CenterHorizontally
        ) {
            CircularProgress()
            CircularProgressStatic()
            LinearProgress()
            DeterminateProgress()
        }
    }

}

@Composable
fun CircularProgress() {
    CircularProgressIndicator()
}

@Composable
fun CircularProgressStatic() {
    CircularProgressIndicator(0.5f, color = Color.Cyan)
}

@Composable
fun LinearProgress() {
    LinearProgressIndicator()
}

@Composable
fun DeterminateProgress() {
    LinearProgressIndicator(0.5f, color = Color.Red)
}