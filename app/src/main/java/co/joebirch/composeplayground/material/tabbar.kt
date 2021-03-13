package co.joebirch.composeplayground.material

import androidx.compose.material.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object TabBarView : ComposableLayout {

    @Composable
    override fun build() {


        Scaffold(topBar = {
            TopAppBar(
                elevation = 0.dp
            ) {
                Text(
                    "Jetpack Compose",
                    modifier = Modifier.padding(16.dp)
                )
            }
        }, content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top
            ) {

                CustomIndicatorTabRow()
            }
        })
    }

    @Composable
    fun MinimalTabRow() {
        val tabs = listOf("One", "Two")
        val selectedTab = remember { mutableStateOf(0) }
        TabRow(
            selectedTabIndex = selectedTab.value
        ) {
            tabs.forEachIndexed { index, s ->
                Tab(
                    selected = selectedTab.value == index,
                    onClick = {
                        selectedTab.value = index
                    }) {
                    Text(
                        text = s,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }

    @Composable
    fun BackgroundColorTabRow() {
        val tabs = listOf("One", "Two")
        val selectedTab = remember { mutableStateOf(0) }
        TabRow(
            selectedTabIndex = selectedTab.value,
            backgroundColor = Color.Red
        ) {
            tabs.forEachIndexed { index, s ->
                Tab(
                    selected = selectedTab.value == index,
                    onClick = {
                        selectedTab.value = index
                    }) {
                    Text(
                        text = s,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }

    @Composable
    fun ContentColorTabRow() {
        val tabs = listOf("One", "Two")
        val selectedTab = remember { mutableStateOf(0) }
        TabRow(
            selectedTabIndex = selectedTab.value,
            backgroundColor = Color.Blue
        ) {
            tabs.forEachIndexed { index, s ->
                Tab(
                    selected = selectedTab.value == index,
                    onClick = {
                        selectedTab.value = index
                    }) {
                    Text(
                        text = s,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }

    @Composable
    fun DividerTabRow() {
        val tabs = listOf("One", "Two")
        val selectedTab = remember { mutableStateOf(0) }
        TabRow(
            selectedTabIndex = selectedTab.value,
            divider = {
                Divider(
                    modifier = Modifier.height(8.dp)
                        .fillMaxWidth()
                        .background(color = Color.Red)
                )
            }
        ) {
            tabs.forEachIndexed { index, s ->
                Tab(
                    selected = selectedTab.value == index,
                    onClick = {
                        selectedTab.value = index
                    }
                )
            }
        }
    }

    @Composable
    fun CustomIndicatorTabRow() {
        val tabs = listOf("One", "Two")
        val selectedTab = remember { mutableStateOf(0) }
        TabRow(
            selectedTabIndex = selectedTab.value,
            indicator = { tabPositions: List<TabPosition> ->
                val modifier = Modifier.tabIndicatorOffset(
                    tabPositions[selectedTab.value]
                )
                Box(
                    modifier.fillMaxWidth().height(5.dp)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(
                                topStart = 16.dp, topEnd = 16.dp
                            )
                        ),
                )
            }
        ) {
            tabs.forEachIndexed { index, s ->
                Tab(
                    selected = selectedTab.value == index,
                    onClick = {
                        selectedTab.value = index
                    }) {
                    Text(
                        text = s,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }

}