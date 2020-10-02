package co.joebirch.composeplayground.material

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object ProgressView: ComposableLayout {

    @Composable
    override fun build() {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
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