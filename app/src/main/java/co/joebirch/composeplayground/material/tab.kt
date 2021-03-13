package co.joebirch.composeplayground.material

import androidx.compose.material.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout
import co.joebirch.composeplayground.R

object TabView : ComposableLayout {

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

                //CustomIndicatorTabRow()
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
    fun TextTab() {
        Tab(
            selected = true,
            onClick = {

            },
            text = {
                Text(
                    text = "Compose Academy",
                    modifier = Modifier.padding(16.dp)
                )
            }
        )
    }

    @Composable
    fun IconTab() {
        Tab(
            selected = true,
            onClick = {

            },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_android_black_24dp),
                    modifier = Modifier.padding(16.dp),
                    contentDescription = "Android"
                )
            }
        )
    }

    @Composable
    fun SelectedColorTab() {
        Tab(
            selected = true,
            onClick = {

            },
            selectedContentColor = Color.Red,
            text = {
                Text(
                    text = "Compose Academy",
                    modifier = Modifier.padding(16.dp)
                )
            }
        )
    }

    @Composable
    fun UnselectedColorTab() {
        Tab(
            selected = true,
            onClick = {

            },
            unselectedContentColor = Color.LightGray,
            text = {
                Text(
                    text = "Compose Academy",
                    modifier = Modifier.padding(16.dp)
                )
            }
        )
    }

}