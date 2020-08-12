package co.joebirch.composeplayground.resource

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.booleanResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.integerArrayResource
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.unit.dp
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