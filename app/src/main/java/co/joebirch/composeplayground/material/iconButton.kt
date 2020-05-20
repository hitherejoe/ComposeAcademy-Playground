package co.joebirch.composeplayground.material

import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.Border
import androidx.ui.foundation.Icon
import androidx.ui.foundation.Text
import androidx.ui.foundation.shape.corner.CutCornerShape
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.Button
import androidx.ui.material.Card
import androidx.ui.material.IconButton
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.filled.Person
import androidx.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout
import kotlinx.coroutines.delay
import java.util.*
import kotlin.concurrent.schedule
import kotlin.concurrent.timer
import kotlin.concurrent.timerTask

object IconButtonView : ComposableLayout {

    @Composable
    override fun build() {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalGravity = Alignment.CenterHorizontally
        ) {
            MinimalIconButtonComponent()
        }
    }

}

@Composable
fun MinimalIconButtonComponent() {
    IconButton(onClick = {

    }, icon = {
        Icon(asset = Icons.Default.Person)
    })
}
