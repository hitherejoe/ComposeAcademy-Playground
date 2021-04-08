package co.joebirch.composeplayground.material

import androidx.compose.material.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object BottomAppBarView : ComposableLayout {

    @Composable
    override fun build() {
        val selectedLayout = remember { mutableStateOf(0) }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when (selectedLayout.value) {
                0 -> MinimalBottomAppBar {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Button(onClick = {
                            selectedLayout.value = 1
                        }, modifier = Modifier.align(Alignment.CenterHorizontally)) {
                            Text(text = "Switch to styled bar")
                        }
                    }
                }
                1 -> StyledBottomAppBar {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Button(onClick = {
                            selectedLayout.value = 2
                        }, modifier = Modifier.align(Alignment.CenterHorizontally)) {
                            Text(text = "Switch to FAB bar")
                        }
                    }
                }
                2 -> FabBottomAppBar {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Button(onClick = {
                            selectedLayout.value = 3
                        }, modifier = Modifier.align(Alignment.CenterHorizontally)) {
                            Text(text = "Switch to minimal bar")
                        }
                    }
                }
                3 -> DockedFabBottomAppBar {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Button(onClick = {
                            selectedLayout.value = 0
                        }, modifier = Modifier.align(Alignment.CenterHorizontally)) {
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
    }, content = {
        bodyContent()
    })
}

@Composable
fun BackgroundColorBottomAppBar(bodyContent: @Composable() () -> Unit) {
    BottomAppBar(
        backgroundColor = Color.Black
    ) {
        Text(
            text = "Jetpack Compose",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun ContentColorBottomAppBar(bodyContent: @Composable() () -> Unit) {
    BottomAppBar(
        contentColor = Color.Black
    ) {
        Text(
            text = "Jetpack Compose",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun ElevationBottomAppBar(bodyContent: @Composable() () -> Unit) {
    BottomAppBar(
        elevation = 12.dp,
    ) {
        Text(
            text = "Jetpack Compose",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun StyledBottomAppBar(bodyContent: @Composable() () -> Unit) {
    Scaffold(bottomBar = {
        BottomAppBar(
            elevation = 12.dp,
            contentColor = Color.White,
            backgroundColor = Color.Black
        ) {
            Text(
                text = "Jetpack Compose",
                modifier = Modifier.padding(16.dp)
            )
        }
    }, content = {
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
                Icon(
                    Icons.Default.Done,
                    contentDescription = "my description"
                )
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        content = {
            bodyContent()
        }
    )
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
                Icon(
                    Icons.Default.Done,
                    contentDescription = "my description"
                )
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        content = {
            bodyContent()
        })
}