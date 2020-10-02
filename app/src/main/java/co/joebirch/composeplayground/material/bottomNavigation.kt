package co.joebirch.composeplayground.material

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Button
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.runtime.Composable
import androidx.compose.runtime.state
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.VectorAsset
import androidx.compose.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object BottomNavigationView : ComposableLayout {

    @Composable
    override fun build() {
        val selectedLayout = state { 0 }

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
                2 -> StyledBottomNavigation {
                    Button(onClick = {
                        selectedLayout.value = 0
                    }, modifier = Modifier.align(Alignment.CenterHorizontally)) {
                        Text(text = "Switch to standard")
                    }
                }
            }
        }
    }

}

class NavigationItem(val label: String, val icon: VectorAsset)

@Composable
fun StandardBottomNavigation(bodyContent: @Composable() () -> Unit) {
    val selectedItem = state { 0 }
    val items = listOf(
        NavigationItem("Call", Icons.Filled.Call),
        NavigationItem("People", Icons.Filled.Face),
        NavigationItem("Email", Icons.Filled.Email)
    )
    Column {
        bodyContent()
        Spacer(modifier = Modifier.preferredHeight(64.dp))
        BottomNavigation {
            items.forEachIndexed { index, item ->
                BottomNavigationItem(
                    icon = { Icon(item.icon) },
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
    val selectedItem = state { 0 }
    val items = listOf(
        NavigationItem("Call", Icons.Filled.Call),
        NavigationItem("People", Icons.Filled.Face),
        NavigationItem("Email", Icons.Filled.Email)
    )
    Column {
        bodyContent()
        Spacer(modifier = Modifier.preferredHeight(64.dp))
        BottomNavigation {
            items.forEachIndexed { index, item ->
                BottomNavigationItem(
                    icon = { Icon(item.icon) },
                    label = { Text(text = item.label) },
                    selected = selectedItem.value == index,
                    onClick = { selectedItem.value = index },
                    alwaysShowLabels = false
                )
            }
        }
    }
}

@Composable
fun StyledBottomNavigation(bodyContent: @Composable() () -> Unit) {
    val selectedItem = state { 0 }
    val items = listOf(
        NavigationItem("Call", Icons.Filled.Call),
        NavigationItem("People", Icons.Filled.Face),
        NavigationItem("Email", Icons.Filled.Email)
    )
    Column {
        bodyContent()
        Spacer(modifier = Modifier.preferredHeight(64.dp))
        BottomNavigation {
            items.forEachIndexed { index, item ->
                BottomNavigationItem(
                    icon = { Icon(item.icon) },
                    label = { Text(text = item.label) },
                    selected = selectedItem.value == index,
                    onClick = { selectedItem.value = index },
                    selectedContentColor = Color.Green,
                    unselectedContentColor = Color.Red
                )
            }
        }
    }
}
