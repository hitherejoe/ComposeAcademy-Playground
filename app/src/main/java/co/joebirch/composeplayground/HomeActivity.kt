package co.joebirch.composeplayground

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.foundation.AdapterList
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.Text
import androidx.ui.graphics.Color
import androidx.ui.layout.fillMaxWidth
import androidx.ui.layout.padding
import androidx.ui.material.Divider
import androidx.ui.material.ripple.RippleEffect
import androidx.ui.material.ripple.ripple
import androidx.ui.text.TextStyle
import androidx.ui.unit.dp
import androidx.ui.unit.sp

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val data = listOf(
            MaterialHeading(),
            Material.Snackbar, Material.AlertDialog, Foundation.AndroidView
        )

        setContent {
            AdapterList(data = data) {
                if (it.isHeading) {
                    Text(
                        it.label,
                        style = TextStyle(color = Color.Black, fontSize = 20.sp),
                        modifier = Modifier.padding(16.dp)
                    )
                } else {
                    Clickable(
                        onClick = {
                            startActivity(intentTo(it.intent))
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
        }
    }

}