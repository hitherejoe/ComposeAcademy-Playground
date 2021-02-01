package co.joebirch.composeplayground.material

import androidx.compose.foundation.Icon
import androidx.compose.material.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object TopAppBarView : ComposableLayout {

    @Composable
    override fun build() {
        val selectedLayout = remember { mutableStateOf(0) }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when (selectedLayout.value) {
                0 -> MinimalTopAppBar {
                    Column(modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center) {
                        Button(onClick = {
                            selectedLayout.value = 1
                        }, modifier = Modifier.align(Alignment.CenterHorizontally)) {
                            Text(text = "Switch to Navigation Icon")
                        }
                    }
                }
                1 -> NavigationIconTopAppBar {
                    Column(modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center) {
                        Button(onClick = {
                            selectedLayout.value = 2
                        }, modifier = Modifier.align(Alignment.CenterHorizontally)) {
                            Text(text = "Switch to styled TopAppBar")
                        }
                    }
                }
                /*
                2 -> StyledTopAppBar {
                    Column(modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center) {
                        Button(onClick = {
                            selectedLayout.value = 3
                        }, modifier = Modifier.align(Alignment.CenterHorizontally)) {
                            Text(text = "Switch to Actions TopAppBar")
                        }
                    }
                }
                 */
                3 -> ActionsTopAppBar {
                    Column(modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center) {
                        Button(onClick = {
                            selectedLayout.value = 0
                        }, modifier = Modifier.align(Alignment.CenterHorizontally)) {
                            Text(text = "Switch to Minimal TopAppBar")
                        }
                    }
                }
            }
        }
    }

}

@Composable
fun MinimalTopAppBar(bodyContent: @Composable() () -> Unit) {
    TopAppBar(
        title = {
            Text(text = "Compose Academy")
        }
    )
}

@Composable
fun MinimalFlexibleTopAppBar(bodyContent: @Composable() () -> Unit) {
    TopAppBar {
        Text(text = "Compose Academy")
    }
}

@Composable
fun NavigationIconTopAppBar(bodyContent: @Composable() () -> Unit) {
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(text = "Jetpack Compose")
            },
            navigationIcon = {
                IconButton(onClick = { }) {
                    Icon(Icons.Filled.ArrowBack)
                }
            }
        )
    }, bodyContent = {
        bodyContent()
    })
}

@Composable
fun ElevationTopAppBar(bodyContent: @Composable() () -> Unit) {
    TopAppBar(
        title = {
            Text(text = "Jetpack Compose")
        },
        elevation = 12.dp
    )
}

@Composable
fun BackgroundColorTopAppBar(bodyContent: @Composable() () -> Unit) {
    TopAppBar(
        title = {
            Text(text = "Jetpack Compose")
        },
        backgroundColor = Color.Black
    )
}

@Composable
fun ContentColorTopAppBar(bodyContent: @Composable() () -> Unit) {
    TopAppBar(
        title = {
            Text(text = "Jetpack Compose")
        },
        contentColor = Color.Black
    )
}

@Composable
fun ActionsTopAppBar(bodyContent: @Composable() () -> Unit) {
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(text = "Compose Academy")
            },
            actions = {
                Text(
                    text = "Save", modifier = Modifier.padding(16.dp).clickable(onClick = {

                    }),
                    color = Color.White
                )
            }
        )
    }, bodyContent = {
        bodyContent()
    })
}