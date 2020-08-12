package co.joebirch.composeplayground.material

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.state
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
    val state = state { true }

    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = {
            state.value = !state.value
        }) {
            Icon(asset = Icons.Filled.Done)
        }
    }, bottomBar = {
        BottomAppBar {

        }
    }, floatingActionButtonPosition = Scaffold.FabPosition.Center,
        isFloatingActionButtonDocked = state.value,
        bodyContent = {
            bodyContent()
        })
}

@Composable
fun ScaffoldWithTopAppBar(bodyContent: @Composable() () -> Unit) {
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
fun ScaffoldWithDrawer(bodyContent: @Composable() () -> Unit) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    Scaffold(
        scaffoldState = ScaffoldState(drawerState),
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Jetpack Compose")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        drawerState.open()
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
                drawerState.close()
            }) {
                Text(text = "Close Drawer")
            }
        }
    }, bodyContent = {
        bodyContent()
    })
}