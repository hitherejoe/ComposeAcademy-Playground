package co.joebirch.composeplayground.material

import androidx.compose.Composable
import androidx.compose.remember
import androidx.compose.state
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.*
import androidx.ui.foundation.shape.corner.CircleShape
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.graphics.vector.VectorAsset
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.filled.*
import androidx.ui.material.ripple.ripple
import androidx.ui.res.booleanResource
import androidx.ui.unit.IntPxSize
import androidx.ui.unit.PxPosition
import androidx.ui.unit.dp
import androidx.ui.unit.ipx
import co.joebirch.composeplayground.ComposableLayout

object BottomNavigationView : ComposableLayout {

    @Composable
    override fun build() {
        val selectedLayout = state { 0 }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalGravity = Alignment.CenterHorizontally
        ) {
            when (selectedLayout.value) {
                0 -> StandardBottomNavigation {
                    Button(onClick = {
                        selectedLayout.value = 1
                    }, modifier = Modifier.gravity(Alignment.CenterHorizontally)) {
                        Text(text = "Switch to no labels")
                    }
                }
                1 -> BottomNavigationOnlySelectedLabels {
                    Button(onClick = {
                        selectedLayout.value = 2
                    }, modifier = Modifier.gravity(Alignment.CenterHorizontally)) {
                        Text(text = "Switch to styled")
                    }
                }
                2 -> StyledBottomNavigation {
                    Button(onClick = {
                        selectedLayout.value = 0
                    }, modifier = Modifier.gravity(Alignment.CenterHorizontally)) {
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
                    text = { Text(text = item.label) },
                    selected = selectedItem.value == index,
                    onSelected = { selectedItem.value = index }
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
                    text = { Text(text = item.label) },
                    selected = selectedItem.value == index,
                    onSelected = { selectedItem.value = index },
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
                    text = { Text(text = item.label) },
                    selected = selectedItem.value == index,
                    onSelected = { selectedItem.value = index },
                    activeColor = Color.Green,
                    inactiveColor = Color.Red
                )
            }
        }
    }
}
