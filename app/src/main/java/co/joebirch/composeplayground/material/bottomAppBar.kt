package co.joebirch.composeplayground.material

import androidx.compose.Composable
import androidx.compose.remember
import androidx.compose.state
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.Border
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.Icon
import androidx.ui.foundation.Text
import androidx.ui.foundation.shape.corner.CircleShape
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.filled.ArrowBack
import androidx.ui.material.icons.filled.Done
import androidx.ui.material.icons.filled.Menu
import androidx.ui.material.ripple.ripple
import androidx.ui.unit.IntPxSize
import androidx.ui.unit.PxPosition
import androidx.ui.unit.dp
import androidx.ui.unit.ipx
import co.joebirch.composeplayground.ComposableLayout

object BottomAppBarView : ComposableLayout {

    @Composable
    override fun build() {
        val selectedLayout = state { 0 }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalGravity = Alignment.CenterHorizontally
        ) {
            when (selectedLayout.value) {
                0 -> MinimalBottomAppBar {
                    Column(modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center) {
                        Button(onClick = {
                            selectedLayout.value = 1
                        }, modifier = Modifier.gravity(Alignment.CenterHorizontally)) {
                            Text(text = "Switch to styled bar")
                        }
                    }
                }
                1 -> StyledBottomAppBar {
                    Column(modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center) {
                        Button(onClick = {
                            selectedLayout.value = 2
                        }, modifier = Modifier.gravity(Alignment.CenterHorizontally)) {
                            Text(text = "Switch to FAB bar")
                        }
                    }
                }
                2 -> FabBottomAppBar {
                    Column(modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center) {
                        Button(onClick = {
                            selectedLayout.value = 0
                        }, modifier = Modifier.gravity(Alignment.CenterHorizontally)) {
                            Text(text = "Switch to minimal bar")
                        }
                    }
                }
            }
        }
    }

}

@Composable
fun MinimalBottomAppBar(bodyContent: @Composable() () -> Unit) {
    Scaffold(bottomAppBar = {
        BottomAppBar {
            Text(
                text = "Jetpack Compose",
                modifier = Modifier.padding(16.dp)
            )
        }
    }, bodyContent = {
        bodyContent()
    })
}

@Composable
fun StyledBottomAppBar(bodyContent: @Composable() () -> Unit) {
    Scaffold(bottomAppBar = {
        BottomAppBar(
            contentColor = Color.White,
            backgroundColor = Color.Black
        ) {
            Text(
                text = "Jetpack Compose",
                modifier = Modifier.padding(16.dp)
            )
        }
    }, bodyContent = {
        bodyContent()
    })
}

@Composable
fun FabBottomAppBar(bodyContent: @Composable() () -> Unit) {
    Scaffold(
        bottomAppBar = {
            BottomAppBar(
                contentColor = Color.White,
                backgroundColor = Color.Black,
                cutoutShape = CircleShape
            ) {

            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {

            }) {
                Icon(asset = Icons.Default.Done)
            }
        },
        floatingActionButtonPosition = Scaffold.FabPosition.CenterDocked,
        bodyContent = {
            bodyContent()
        })
}