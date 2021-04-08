package co.joebirch.composeplayground.material

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.BottomNavigationItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object BottomNavigationView : ComposableLayout {

    @Composable
    override fun build() {
        val selectedLayout = remember { mutableStateOf(0) }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when (selectedLayout.value) {
                0 -> StandardBottomNavigation {
                    Button(onClick = {
                        selectedLayout.value = 1
                    }, modifier = Modifier.align(Alignment.CenterHorizontally)) {
                        Text(text = "Switch to no labels")
                    }
                }
                1 -> BottomNavigationOnlySelectedLabels {
                    Button(onClick = {
                        selectedLayout.value = 2
                    }, modifier = Modifier.align(Alignment.CenterHorizontally)) {
                        Text(text = "Switch to styled")
                    }
                }
            }
        }
    }

}

class NavigationItem(val label: String, val icon: ImageVector)

@Composable
fun StandardBottomNavigation(bodyContent: @Composable() () -> Unit) {
    val selectedItem = remember { mutableStateOf(0) }
    val items = listOf(
        NavigationItem("Call", Icons.Filled.Call),
        NavigationItem("People", Icons.Filled.Face),
        NavigationItem("Email", Icons.Filled.Email)
    )
    Column {
        bodyContent()
        Spacer(modifier = Modifier.height(64.dp))
        BottomNavigation {
            items.forEachIndexed { index, item ->
                BottomNavigationItem(
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = null
                        )
                    },
                    label = { Text(text = item.label) },
                    selected = selectedItem.value == index,
                    onClick = { selectedItem.value = index }
                )
            }
        }
    }
}

@Composable
fun RowScope.StandardBottomNavigationItem(bodyContent: @Composable() () -> Unit) {
    val selectedItem = remember { mutableStateOf(0) }
    BottomNavigationItem(
        icon = { Icon(Icons.Filled.Call, contentDescription = "Call") },
        selected = selectedItem.value == 0,
        onClick = { selectedItem.value = 0 }
    )
}

@Composable
fun RowScope.LabelBottomNavigationItem(bodyContent: @Composable() () -> Unit) {
    val selectedItem = remember { mutableStateOf(0) }
    BottomNavigationItem(
        icon = { Icon(Icons.Filled.Call, contentDescription = "Call") },
        label = { Text(text = "Call") },
        selected = selectedItem.value == 0,
        onClick = { selectedItem.value = 0 }
    )
}

@Composable
fun RowScope.AlwaysVisibleLabelBottomNavigationItem(bodyContent: @Composable() () -> Unit) {
    val selectedItem = remember { mutableStateOf(0) }
    BottomNavigationItem(
        icon = { Icon(Icons.Filled.Call, contentDescription = "Call") },
        label = { Text(text = "Call") },
        alwaysShowLabel = true,
        selected = selectedItem.value == 0,
        onClick = { selectedItem.value = 0 }
    )
}

@Composable
fun RowScope.SelectedColorBottomNavigationItem(bodyContent: @Composable() () -> Unit) {
    val selectedItem = remember { mutableStateOf(0) }
    BottomNavigationItem(
        icon = { Icon(Icons.Filled.Call, contentDescription = "Call") },
        selectedContentColor = Color.Red,
        selected = selectedItem.value == 0,
        onClick = { selectedItem.value = 0 }
    )
}

@Composable
fun RowScope.UnselectedColorBottomNavigationItem(bodyContent: @Composable() () -> Unit) {
    val selectedItem = remember { mutableStateOf(0) }
    BottomNavigationItem(
        icon = { Icon(Icons.Filled.Call, contentDescription = "Call") },
        unselectedContentColor = Color.LightGray,
        selected = selectedItem.value == 0,
        onClick = { selectedItem.value = 0 }
    )
}

@Composable
fun InteractionState(bodyContent: @Composable() () -> Unit) {
    val selectedItem = remember { mutableStateOf(0) }
    val items = listOf(
        NavigationItem("Call", Icons.Filled.Call),
        NavigationItem("People", Icons.Filled.Face),
        NavigationItem("Email", Icons.Filled.Email)
    )
    Column {
        bodyContent()
        Spacer(modifier = Modifier.height(64.dp))
        BottomNavigation {
            items.forEachIndexed { index, item ->
                BottomNavigationItem(
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = null
                        )
                    },
                    label = { Text(text = item.label) },
                    selected = selectedItem.value == index,
                    onClick = { selectedItem.value = index }
                )
            }
        }
    }
}

@Composable
fun BottomNavigationOnlySelectedLabels(bodyContent: @Composable() () -> Unit) {
    val selectedItem = remember { mutableStateOf(0) }
    val items = listOf(
        NavigationItem("Call", Icons.Filled.Call),
        NavigationItem("People", Icons.Filled.Face),
        NavigationItem("Email", Icons.Filled.Email)
    )
    Column {
        bodyContent()
        Spacer(modifier = Modifier.height(64.dp))
        BottomNavigation {
            items.forEachIndexed { index, item ->
                BottomNavigationItem(
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = null
                        )
                    },
                    label = { Text(text = item.label) },
                    selected = selectedItem.value == index,
                    onClick = { selectedItem.value = index },
                    alwaysShowLabel = false
                )
            }
        }
    }
}

@Composable
fun BackgroundColorBottomNavigation(bodyContent: @Composable() () -> Unit) {
    val selectedItem = remember { mutableStateOf(0) }
    val items = listOf(
        NavigationItem("Call", Icons.Filled.Call),
        NavigationItem("People", Icons.Filled.Face),
        NavigationItem("Email", Icons.Filled.Email)
    )
    BottomNavigation(
        backgroundColor = Color.Red
    ) {
        items.forEachIndexed { index, item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = null
                    )
                },
                label = { Text(text = item.label) },
                selected = selectedItem.value == index,
                onClick = { selectedItem.value = index },
                selectedContentColor = Color.Green,
                unselectedContentColor = Color.Red
            )
        }
    }
}

@Composable
fun ContentColorBottomNavigation(bodyContent: @Composable() () -> Unit) {
    val selectedItem = remember { mutableStateOf(0) }
    val items = listOf(
        NavigationItem("Call", Icons.Filled.Call),
        NavigationItem("People", Icons.Filled.Face),
        NavigationItem("Email", Icons.Filled.Email)
    )
    BottomNavigation(
        contentColor = Color.Blue
    ) {
        items.forEachIndexed { index, item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = null
                    )
                },
                label = { Text(text = item.label) },
                selected = selectedItem.value == index,
                onClick = { selectedItem.value = index },
                selectedContentColor = Color.Green,
                unselectedContentColor = Color.Red
            )
        }
    }
}


@Composable
fun ElevationBottomNavigation(bodyContent: @Composable() () -> Unit) {
    val selectedItem = remember { mutableStateOf(0) }
    val items = listOf(
        NavigationItem("Call", Icons.Filled.Call),
        NavigationItem("People", Icons.Filled.Face),
        NavigationItem("Email", Icons.Filled.Email)
    )
    BottomNavigation(
        elevation = 12.dp
    ) {
        items.forEachIndexed { index, item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = null
                    )
                },
                label = { Text(text = item.label) },
                selected = selectedItem.value == index,
                onClick = { selectedItem.value = index },
                selectedContentColor = Color.Green,
                unselectedContentColor = Color.Red
            )
        }
    }
}
