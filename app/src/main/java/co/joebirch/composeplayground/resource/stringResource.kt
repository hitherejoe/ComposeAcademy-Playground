package co.joebirch.composeplayground.resource

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout
import co.joebirch.composeplayground.R

object StringResourceView : ComposableLayout {

    @Composable
    override fun build() {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = stringResource(id = R.string.app_name),
                modifier = Modifier.padding(16.dp))
            Text(text = stringResource(id = R.string.app_name_formatting,
                formatArgs = arrayOf(stringResource(id = R.string.app_name))),
                modifier = Modifier.padding(16.dp))
            stringArrayResource(id = R.array.sample_array).forEach {
                Text(text = it,
                    modifier = Modifier.padding(16.dp))
            }
        }
    }

}