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
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.filled.ArrowBack
import androidx.ui.material.icons.filled.Done
import androidx.ui.material.icons.filled.Menu
import androidx.ui.material.ripple.ripple
import androidx.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object TopAppBarView : ComposableLayout {

    @Composable
    override fun build() {
        val selectedLayout = state { 0 }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalGravity = Alignment.CenterHorizontally
        ) {
            when (selectedLayout.value) {
                0 -> MinimalTopAppBar {
                    Column(modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center) {
                        Button(onClick = {
                            selectedLayout.value = 1
                        }, modifier = Modifier.gravity(Alignment.CenterHorizontally)) {
                            Text(text = "Switch to Navigation Icon")
                        }
                    }
                }
                1 -> NavigationIconTopAppBar {
                    Column(modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center) {
                        Button(onClick = {
                            selectedLayout.value = 2
                        }, modifier = Modifier.gravity(Alignment.CenterHorizontally)) {
                            Text(text = "Switch to styled TopAppBar")
                        }
                    }
                }
                2 -> StyledTopAppBar {
                    Column(modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center) {
                        Button(onClick = {
                            selectedLayout.value = 3
                        }, modifier = Modifier.gravity(Alignment.CenterHorizontally)) {
                            Text(text = "Switch to Actions TopAppBar")
                        }
                    }
                }
                3 -> ActionsTopAppBar {
                    Column(modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center) {
                        Button(onClick = {
                            selectedLayout.value = 0
                        }, modifier = Modifier.gravity(Alignment.CenterHorizontally)) {
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
    Scaffold(topAppBar = {
        TopAppBar(
            title = {
                Text(text = "Jetpack Compose")
            }
        )
    }, bodyContent = {
        bodyContent()
    })
}

@Composable
fun NavigationIconTopAppBar(bodyContent: @Composable() () -> Unit) {
    Scaffold(topAppBar = {
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
fun StyledTopAppBar(bodyContent: @Composable() () -> Unit) {
    Scaffold(topAppBar = {
        TopAppBar(
            title = {
                Text(text = "Jetpack Compose")
            },
            backgroundColor = Color.Black,
            contentColor = Color.White,
            elevation = 12.dp
        )
    }, bodyContent = {
        bodyContent()
    })
}

@Composable
fun ActionsTopAppBar(bodyContent: @Composable() () -> Unit) {
    Scaffold(topAppBar = {
        TopAppBar(
            title = {
                Text(text = "Jetpack Compose")
            },
            actions = {
                Clickable(onClick = {

                }, modifier = Modifier.ripple()) {
                    Text(text = "Save", modifier = Modifier.padding(16.dp),
                        color = Color.White)
                }
            }
        )
    }, bodyContent = {
        bodyContent()
    })
}