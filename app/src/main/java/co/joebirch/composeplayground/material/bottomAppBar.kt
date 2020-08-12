package co.joebirch.composeplayground.material

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Button
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.runtime.state
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
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
                            selectedLayout.value = 3
                        }, modifier = Modifier.gravity(Alignment.CenterHorizontally)) {
                            Text(text = "Switch to minimal bar")
                        }
                    }
                }
                3 -> DockedFabBottomAppBar {
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
    Scaffold(bottomBar = {
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
    Scaffold(bottomBar = {
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
        bottomBar = {
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
        floatingActionButtonPosition = Scaffold.FabPosition.Center,
        bodyContent = {
            bodyContent()
        })
}

@Composable
fun DockedFabBottomAppBar(bodyContent: @Composable() () -> Unit) {
    Scaffold(
        bottomBar = {
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
        floatingActionButtonPosition = Scaffold.FabPosition.Center,
        isFloatingActionButtonDocked = true,
        bodyContent = {
            bodyContent()
        })
}