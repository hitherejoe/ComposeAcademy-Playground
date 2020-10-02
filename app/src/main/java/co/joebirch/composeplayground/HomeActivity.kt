package co.joebirch.composeplayground

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.joebirch.composeplayground.animation.Animation
import co.joebirch.composeplayground.core.Core
import co.joebirch.composeplayground.foundation.Foundation
import co.joebirch.composeplayground.graphics.Graphics
import co.joebirch.composeplayground.layout.Layout
import co.joebirch.composeplayground.material.Material
import co.joebirch.composeplayground.resource.Resource

@ExperimentalFoundationApi
class HomeActivity : AppCompatActivity() {

    class HomeState(category: Category? = null) {
        var category by mutableStateOf(category)
    }

    private val currentState = HomeState()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mappedData = mapOf(
            Pair(
                Animation.Heading, listOf(
                    Animation.Crossfade,
                    Animation.SingleColor,
                    Animation.SingleFloat,
                    Animation.Transitions,
                    Animation.AnimatedValues,
                    Animation.RotatingShape,
                    Animation.PulsingShape,
                    Animation.InterationAnimation,
                    Animation.TextAnimations
                )
            ),
            Pair(
                Core.Heading,
                listOf(
                    Core.Gesture,
                    Core.Opacity,
                    Core.Popup,
                    Core.Shadow
                )
            ),
            Pair(Graphics.Heading, listOf(Graphics.Color)),
            Pair(
                Material.Heading, listOf(
                    Material.AlertDialog,
                    Material.Border,
                    Material.BottomAppBar,
                    Material.BottomNavigation,
                    Material.Button,
                    Material.Card,
                    Material.Checkbox,
                    Material.Divider,
                    Material.Fab,
                    Material.IconButton,
                    Material.Progress,
                    Material.RadioButton,
                    Material.Scaffold,
                    Material.Slider,
                    Material.Switch,
                    Material.Snackbar,
                    Material.TabRow,
                    Material.TextField,
                    Material.TopAppBar,
                    Material.TriStateRadioButton
                )
            ),
            Pair(
                Layout.Heading, listOf(
                    Layout.Column,
                    Layout.ScrollableColumn,
                    Layout.HorizontalArrangement,
                    Layout.FlowColumn,
                    Layout.Row,
                    Layout.Spacer,
                    Layout.Stack,
                    Layout.VerticalArrangement
                )
            ),
            Pair(
                Foundation.Heading, listOf(
                    Foundation.Border,
                    Foundation.Clickable,
                    Foundation.Shape,
                    Foundation.Text,
                    Foundation.TextStyle
                )
            ),
            Pair(
                Resource.Heading, listOf(
                    Resource.Color,
                    Resource.StringResource,
                    Resource.Primitive
                )
            )
        )

        setContent {
            val state = remember { currentState }

            Scaffold(bodyContent = {
                if (state.category == null) {
                    LazyColumnFor(items = mappedData.keys.toList()) {
                        val selected = state { false }
                        Text(
                            it.label,
                            style = TextStyle(color = Color.Black, fontSize = 20.sp),
                            modifier = Modifier.padding(16.dp).clickable(onClick = {
                                selected.value = !selected.value
                            }).fillParentMaxWidth()
                        )
                        if (selected.value) {
                            Column {
                                mappedData.getValue(it).toList().forEach {
                                    Text(
                                        it.label,
                                        style = TextStyle(
                                            color = Color.Black, fontSize = 14.sp,
                                            textIndent = TextIndent(firstLine = 16.sp)
                                        ),
                                        modifier = Modifier.padding(16.dp).clickable(onClick = {
                                            state.category = it
                                        }).fillParentMaxWidth()
                                    )
                                }
                            }
                        }
                    }
                } else {
                    state.category!!.intent!!.build()
                }
            })
        }
    }

    override fun onBackPressed() {
        if (currentState.category != null) {
            currentState.category = null
        } else {
            super.onBackPressed()
        }
    }

}