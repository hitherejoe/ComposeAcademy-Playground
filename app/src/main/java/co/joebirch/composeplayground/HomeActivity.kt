package co.joebirch.composeplayground

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Model
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.foundation.AdapterList
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.Text
import androidx.ui.graphics.Color
import androidx.ui.layout.fillMaxWidth
import androidx.ui.layout.padding
import androidx.ui.material.Scaffold
import androidx.ui.material.ripple.ripple
import androidx.ui.text.TextStyle
import androidx.ui.unit.dp
import androidx.ui.unit.sp
import co.joebirch.composeplayground.animation.Animation
import co.joebirch.composeplayground.core.Core
import co.joebirch.composeplayground.foundation.Foundation
import co.joebirch.composeplayground.graphics.Graphics
import co.joebirch.composeplayground.layout.Layout
import co.joebirch.composeplayground.material.Material
import co.joebirch.composeplayground.resource.Resource

class HomeActivity : AppCompatActivity() {

    @Model
    class CurrentSelected(var obj: ComposableLayout? = null)

    private val currentSelected = CurrentSelected()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val data = listOf(
            Animation.Heading,
            Animation.Crossfade,
            Animation.SingleColor,
            Animation.SingleFloat,
            Animation.Transitions,
            Animation.AnimatedValues,
            Animation.RotatingShape,
            Animation.PulsingShape,
            Animation.InterationAnimation,
            Core.Heading,
            Core.Gesture,
            Graphics.Heading,
            Graphics.Color,
            Material.Heading,
            Material.Border,
            Material.Fab,
            Material.Card,
            Material.Progress,
            Material.Slider,
            Material.Switch,
            Material.Snackbar,
            Layout.Heading,
            Layout.Column,
            Layout.HorizontalArrangement,
            Layout.Row,
            Layout.Spacer,
            Layout.VerticalArrangement,
            Foundation.Heading,
            Foundation.Border,
            Foundation.Clickable,
            Foundation.Shape,
            Foundation.Text,
            Foundation.TextStyle,
            Resource.Heading,
            Resource.Color,
            Resource.StringResource,
            Resource.Primitive
        )

        setContent {
            Scaffold(bodyContent = {
                if (currentSelected.obj == null) {
                    AdapterList(data = data) {
                        if (it.intent == null) {
                            Text(
                                it.label,
                                style = TextStyle(color = Color.Black, fontSize = 20.sp),
                                modifier = Modifier.padding(16.dp)
                            )
                        } else {
                            Clickable(
                                onClick = {
                                    currentSelected.obj = it.intent
                                },
                                modifier = Modifier.ripple(bounded = true).fillMaxWidth()
                            ) {
                                Text(
                                    it.label,
                                    style = TextStyle(color = Color.Black, fontSize = 14.sp),
                                    modifier = Modifier.padding(16.dp)
                                )
                            }
                        }
                    }
                } else {
                    currentSelected.obj!!.build()
                }
            })
        }
    }

    override fun onBackPressed() {
        if (currentSelected.obj != null) {
            currentSelected.obj = null
        } else {
            super.onBackPressed()
        }
    }

}