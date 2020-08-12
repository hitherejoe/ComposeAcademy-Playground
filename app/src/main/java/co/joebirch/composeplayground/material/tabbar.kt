package co.joebirch.composeplayground.material

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.state
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object TabBarView : ComposableLayout {

    @Composable
    override fun build() {
        val selectedTab = state { 0 }

        Scaffold(topBar = {
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