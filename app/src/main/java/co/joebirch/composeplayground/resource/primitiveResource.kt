package co.joebirch.composeplayground.resource

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.layout.*
import androidx.ui.res.*
import androidx.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout
import co.joebirch.composeplayground.R

object PrimitiveResourceView : ComposableLayout {

    @Composable
    override fun build() {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalGravity = Alignment.CenterHorizontally
        ) {
            repeat(integerResource(id = R.integer.some_integer)) {
                Text(text = it.toString())
            }

            integerArrayResource(id = R.array.some_integer_array).forEach {
                Text(text = it.toString(),
                    modifier = Modifier.padding(16.dp))
            }


            Text(text = "Is enabled: ${booleanResource(id = R.bool.is_feature_enabled)}",
                modifier = Modifier.padding(16.dp))

            Text(text = "Adding some padding",
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding)))
        }
    }

}