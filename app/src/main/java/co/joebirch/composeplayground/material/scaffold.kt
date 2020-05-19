package co.joebirch.composeplayground.material

import androidx.compose.Composable
import androidx.compose.remember
import androidx.compose.state
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.Border
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
import androidx.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object ScaffoldView : ComposableLayout {

    @Composable
    override fun build() {
        val selectedLayout = state { 0 }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalGravity = Alignment.CenterHorizontally
        ) {
            when (selectedLayout.value) {
                0 -> ScaffoldWithFabComponent {
                    Column(modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center) {
                        Button(onClick = {
                            selectedLayout.value = 1
                        }, modifier = Modifier.gravity(Alignment.CenterHorizontally)) {
                            Text(text = "Switch to docked FAB")
                        }
                    }
                }
                1 -> ScaffoldWithDockedFabComponent {
                    Column(modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center) {
                        Button(onClick = {
                            selectedLayout.value = 2
                        }, modifier = Modifier.gravity(Alignment.CenterHorizontally)) {
                            Text(text = "Switch to TopAppBar")
                        }
                    }
                }
                2 -> ScaffoldWithTopAppBar {
                    Column(modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center) {
                        Button(onClick = {
                            selectedLayout.value = 3
                        }, modifier = Modifier.gravity(Alignment.CenterHorizontally)) {
                            Text(text = "Switch to Drawer")
                        }
                    }
                }
                3 -> ScaffoldWithDrawer {
                    Column(modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center) {
                        Button(onClick = {
                            selectedLayout.value = 0
                        }, modifier = Modifier.gravity(Alignment.CenterHorizontally)) {
                            Text(text = "Switch to FAB")
                        }
                    }
                }
            }
        }
    }

}

@Composable
fun ScaffoldWithFabComponent(bodyContent: @Composable() () -> Unit) {
    val state = state { 0 }

    val positions = listOf(
        Scaffold.FabPosition.End,
        Scaffold.FabPosition.Center
    )

    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = {
            if (state.value < positions.count() - 1) {
                state.value = state.value + 1
            } else {
                state.value = 0
            }
        }) {
            Icon(asset = Icons.Filled.Done)
        }
    }, floatingActionButtonPosition = positions[state.value],
        bodyContent = {
            bodyContent()
        })
}

@Composable
fun ScaffoldWithDockedFabComponent(bodyContent: @Composable() () -> Unit) {
    val state = state { 0 }

    val positions = listOf(
        Scaffold.FabPosition.EndDocked,
        Scaffold.FabPosition.CenterDocked
    )

    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = {
            if (state.value < positions.count() - 1) {
                state.value = state.value + 1
            } else {
                state.value = 0
            }
        }) {
            Icon(asset = Icons.Filled.Done)
        }
    }, bottomAppBar = {
        BottomAppBar {

        }
    }, floatingActionButtonPosition = positions[state.value],
        bodyContent = {
            bodyContent()
        })
}

@Composable
fun ScaffoldWithTopAppBar(bodyContent: @Composable() () -> Unit) {
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
fun ScaffoldWithDrawer(bodyContent: @Composable() () -> Unit) {
    val scaffoldState = remember { ScaffoldState() }
    Scaffold(
        scaffoldState = scaffoldState,
        topAppBar = {
            TopAppBar(
                title = {
                    Text(text = "Jetpack Compose")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        scaffoldState.drawerState = DrawerState.Opened
                    }) {
                        Icon(Icons.Filled.Menu)
                    }
                }
            )
        }, drawerContent = {
        Column(modifier = Modifier.fillMaxSize(),
            horizontalGravity = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.preferredHeight(24.dp))
            Button(onClick = {
                scaffoldState.drawerState = DrawerState.Closed
            }) {
                Text(text = "Close Drawer")
            }
        }
    }, bodyContent = {
        bodyContent()
    })
}