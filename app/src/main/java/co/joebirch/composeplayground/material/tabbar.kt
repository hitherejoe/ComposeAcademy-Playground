package co.joebirch.composeplayground.material

import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.Modifier
import androidx.ui.foundation.*
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object TabBarView : ComposableLayout {

    @Composable
    override fun build() {
        val selectedTab = state { 0 }

        Scaffold(topAppBar = {
            TopAppBar(
                elevation = 0.dp
            ) {
                Text("Jetpack Compose",
                    modifier = Modifier.padding(16.dp))
            }
        }, bodyContent = {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top
            ) {

                val tabs = listOf("One", "Two")
                TabRow(
                    items = tabs,
                    selectedIndex = selectedTab.value,
                    tab = { index, currentTab ->
                        Tab(
                            selected = selectedTab.value == index,
                            onSelected = {
                                selectedTab.value = index
                            }) {
                            Text(
                                text = currentTab,
                                modifier = Modifier.padding(16.dp)
                            )
                        }
                    })
            }
        })
    }

}