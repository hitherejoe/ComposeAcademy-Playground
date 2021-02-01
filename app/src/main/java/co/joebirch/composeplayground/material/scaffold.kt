package co.joebirch.composeplayground.material

import androidx.compose.material.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object ScaffoldView : ComposableLayout {

    @Composable
    override fun build() {
        val selectedLayout = remember { mutableStateOf(0) }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when (selectedLayout.value) {
                0 -> ScaffoldWithFabComponent {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Button(onClick = {
                            selectedLayout.value = 1
                        }, modifier = Modifier.align(Alignment.CenterHorizontally)) {
                            Text(text = "Switch to docked FAB")
                        }
                    }
                }
                1 -> ScaffoldWithDockedFabComponent {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Button(onClick = {
                            selectedLayout.value = 2
                        }, modifier = Modifier.align(Alignment.CenterHorizontally)) {
                            Text(text = "Switch to TopAppBar")
                        }
                    }
                }
                2 -> ScaffoldWithTopAppBar {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Button(onClick = {
                            selectedLayout.value = 3
                        }, modifier = Modifier.align(Alignment.CenterHorizontally)) {
                            Text(text = "Switch to Drawer")
                        }
                    }
                }
                3 -> ScaffoldWithDrawer {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Button(onClick = {
                            selectedLayout.value = 0
                        }, modifier = Modifier.align(Alignment.CenterHorizontally)) {
                            Text(text = "Switch to FAB")
                        }
                    }
                }
            }
        }
    }

}

@Composable
fun ScaffoldWithSnackbar(bodyContent: @Composable() () -> Unit) {
    val state = remember { mutableStateOf(0) }

    val positions = listOf(
        FabPosition.End,
        FabPosition.Center
    )
    Scaffold(
        snackbarHost = { state ->

        }
    ) {

    }

    Scaffold {
        bodyContent()
    }
}

@Composable
fun ScaffoldWithFabComponent(bodyContent: @Composable() () -> Unit) {
    val state = remember { mutableStateOf(0) }

    val positions = listOf(
        FabPosition.End,
        FabPosition.Center
    )
    Scaffold {

    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                // Handle FAB click
            }) {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "my description"
                )
            }
        },
        bodyContent = {
            bodyContent()
        }
    )
}

@Composable
fun ScaffoldWithPositionedFabComponent(bodyContent: @Composable() () -> Unit) {
    val state = remember { mutableStateOf(0) }

    val positions = listOf(
        FabPosition.End,
        FabPosition.Center
    )
    Scaffold {

    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                // Handle FAB click
            }) {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "my description"
                )
            }
        },
        floatingActionButtonPosition = FabPosition.End,
        bodyContent = {
            Text(text = "Compose Academy")
        }
    )
}

@Composable
fun ScaffoldWithDockedFabComponent(bodyContent: @Composable() () -> Unit) {
    val state = remember { mutableStateOf(true) }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                state.value = !state.value
            }) {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "my description"
                )
            }
        },
        bottomBar = {
            BottomAppBar { }
        },
        isFloatingActionButtonDocked = true,
        bodyContent = {
            Text(text = "Compose Academy")
        }
    )
}

@Composable
fun ScaffoldWithTopAppBar(bodyContent: @Composable() () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Compose Academy")
                },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "my description"
                        )
                    }
                }
            )
        },
        bodyContent = {
            Text(text = "Compose Academy")
        }
    )
}

@Composable
fun ScaffoldWithDrawer(bodyContent: @Composable() () -> Unit) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scaffoldState = rememberScaffoldState(drawerState = drawerState)
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Jetpack Compose")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        drawerState.open()
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "my description"
                        )
                    }
                }
            )
        },
        drawerContent = {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.preferredHeight(24.dp))
                Button(onClick = {
                    drawerState.close()
                }) {
                    Text(text = "Close Drawer")
                }
            }
        },
        bodyContent = {
            Text(text = "Compose Academy")
        }
    )
}

@Composable
fun ScaffoldWithBottomBar(bodyContent: @Composable() () -> Unit) {
    Scaffold(
        bottomBar = {
            BottomAppBar {
                Text(
                    text = "Compose Academy",
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    ) {
        Text(text = "Compose Academy")
    }
}

@Composable
fun ScaffoldColor(bodyContent: @Composable() () -> Unit) {
    val state = remember { mutableStateOf(0) }

    val positions = listOf(
        FabPosition.End,
        FabPosition.Center
    )
    Scaffold {

    }

    Scaffold(
        contentColor = Color.Black,
        backgroundColor = Color.White
    ) {
        bodyContent()
    }
}


@Composable
fun MinimalScaffold(bodyContent: @Composable() () -> Unit) {
    Scaffold {
        Text(text = "Compose Academy")
    }
}

@Composable
fun BackgroundColorScaffold(bodyContent: @Composable() () -> Unit) {
    Scaffold(
        backgroundColor = Color.White
    ) {
        Text(text = "Compose Academy")
    }
}

@Composable
fun ContentColorScaffold(bodyContent: @Composable() () -> Unit) {
    Scaffold(
        contentColor = Color.Blue
    ) {
        Text(text = "Compose Academy")
    }
}

@Composable
fun DrawerBackgroundColorScaffold(bodyContent: @Composable() () -> Unit) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scaffoldState = rememberScaffoldState(drawerState = drawerState)
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Jetpack Compose")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        drawerState.open()
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "my description"
                        )
                    }
                }
            )
        },
        drawerContent = {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.preferredHeight(24.dp))
                Button(onClick = {
                    drawerState.close()
                }) {
                    Text(text = "Close Drawer")
                }
            }
        },
        drawerBackgroundColor = Color.White,
        bodyContent = {
            Text(text = "Compose Academy")
        }
    )
}

@Composable
fun DrawerContentColorScaffold(bodyContent: @Composable() () -> Unit) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scaffoldState = rememberScaffoldState(drawerState = drawerState)
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Jetpack Compose")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        drawerState.open()
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "my description"
                        )
                    }
                }
            )
        },
        drawerContent = {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.preferredHeight(24.dp))
                Button(onClick = {
                    drawerState.close()
                }) {
                    Text(text = "Close Drawer")
                }
            }
        },
        drawerContentColor = Color.Blue,
        bodyContent = {
            Text(text = "Compose Academy")
        }
    )
}

@Composable
fun DrawerSrimColorScaffold(bodyContent: @Composable() () -> Unit) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scaffoldState = rememberScaffoldState(drawerState = drawerState)
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Jetpack Compose")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        drawerState.open()
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "my description"
                        )
                    }
                }
            )
        },
        drawerContent = {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.preferredHeight(24.dp))
                Button(onClick = {
                    drawerState.close()
                }) {
                    Text(text = "Close Drawer")
                }
            }
        },
        drawerScrimColor = Color.Red,
        bodyContent = {
            Text(text = "Compose Academy")
        }
    )
}

@Composable
fun DrawerShapeColorScaffold(bodyContent: @Composable() () -> Unit) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scaffoldState = rememberScaffoldState(drawerState = drawerState)
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Jetpack Compose")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        drawerState.open()
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "my description"
                        )
                    }
                }
            )
        },
        drawerContent = {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.preferredHeight(24.dp))
                Button(onClick = {
                    drawerState.close()
                }) {
                    Text(text = "Close Drawer")
                }
            }
        },
        drawerShape = RoundedCornerShape(8.dp),
        bodyContent = {
            Text(text = "Compose Academy")
        }
    )
}

@Composable
fun DrawerElevationScaffold(bodyContent: @Composable() () -> Unit) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scaffoldState = rememberScaffoldState(drawerState = drawerState)
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Jetpack Compose")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        drawerState.open()
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "my description"
                        )
                    }
                }
            )
        },
        drawerContent = {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.preferredHeight(24.dp))
                Button(onClick = {
                    drawerState.close()
                }) {
                    Text(text = "Close Drawer")
                }
            }
        },
        drawerElevation = 12.dp,
        bodyContent = {
            Text(text = "Compose Academy")
        }
    )
}

@Composable
fun DisableDrawerGestures(bodyContent: @Composable() () -> Unit) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scaffoldState = rememberScaffoldState(drawerState = drawerState)
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Jetpack Compose")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        drawerState.open()
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "my description"
                        )
                    }
                }
            )
        },
        drawerContent = {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.preferredHeight(24.dp))
                Button(onClick = {
                    drawerState.close()
                }) {
                    Text(text = "Close Drawer")
                }
            }
        },
        drawerGesturesEnabled = false,
        bodyContent = {
            Text(text = "Compose Academy")
        }
    )
}