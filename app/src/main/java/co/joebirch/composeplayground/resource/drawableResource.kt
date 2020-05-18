package co.joebirch.composeplayground.resource

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.Image
import androidx.ui.graphics.ImageAsset
import androidx.ui.layout.*
import androidx.ui.res.imageResource
import androidx.ui.res.loadImageResource
import androidx.ui.res.vectorResource
import androidx.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout
import co.joebirch.composeplayground.R

object ImageResourceView : ComposableLayout {

    @Composable
    override fun build() {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalGravity = Alignment.CenterHorizontally
        ) {
            Image(asset = vectorResource(id =
            R.drawable.ic_baseline_account_circle_24),
                modifier = Modifier.padding(16.dp))
            Image(asset = imageResource(id =
            R.drawable.outline_accessibility_black_18dp),
                modifier = Modifier.padding(16.dp))

            loadImageResource(id =
            R.drawable.outline_accessibility_black_18dp).resource.resource?.let {
                Image(asset = it,
                    modifier = Modifier.padding(16.dp))
            }


        }
    }

}