package co.joebirch.composeplayground

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.ContextThemeWrapper
import androidx.compose.Composable
import androidx.compose.Model
import androidx.compose.Providers
import androidx.ui.core.Alignment
import androidx.ui.core.ContextAmbient
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.foundation.Border
import androidx.ui.foundation.Text
import androidx.ui.foundation.selection.ToggleableState
import androidx.ui.foundation.shape.corner.CornerSize
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import androidx.ui.viewinterop.AndroidView

class AndroidViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Column(modifier = Modifier.wrapContentSize(align = Alignment.Center)
                        .padding(16.dp)) {
                    MinimalCardComponent()
                    Spacer(modifier = Modifier.preferredHeight(32.dp))
                    MinimalCardComponentXml()
                    Spacer(modifier = Modifier.preferredHeight(32.dp))
                    MultipleChildCardComponent()
                }
            }
        }
    }

    @Composable
    fun MinimalCardComponent() {
        Surface(
            modifier = Modifier.padding(16.dp),
            color = Color.White,
            shape = RoundedCornerShape(CornerSize(4.dp))
        ) {

            Column(modifier = Modifier.padding(16.dp)) {
                MyCustomView(context = ContextAmbient.current)
            }
        }
    }

    @Composable
    fun MinimalCardComponentXml() {
        Surface(
            modifier = Modifier.padding(16.dp),
            color = Color.White,
            shape = RoundedCornerShape(CornerSize(4.dp))
        ) {

            Column(modifier = Modifier.padding(16.dp)) {
                AndroidView(resId = R.layout.view_demo)
            }
        }
    }

    @Composable
    fun MultipleChildCardComponent() {
        val context = ContextAmbient.current
        Providers(
            ContextAmbient provides ContextThemeWrapper(context, R.style.TestLayoutStyle)
        ) {
            AndroidView(resId = R.layout.view_demo)
        }
    }

    @Preview
    @Composable
    fun DefaultPreview() {
        MaterialTheme {
            Surface(modifier = Modifier.padding(16.dp),
            color = Color.White) {
                MultipleChildCardComponent()
            }
        }
    }
}