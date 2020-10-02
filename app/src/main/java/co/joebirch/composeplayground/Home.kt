package co.joebirch.composeplayground

import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@ExperimentalLayout
@Composable
fun home() {
    ScrollableColumn {
        Spacer(modifier = Modifier.height(16.dp))
        FlowRow(
            mainAxisAlignment = MainAxisAlignment.SpaceEvenly,
            crossAxisAlignment = FlowCrossAxisAlignment.Center,
            crossAxisSpacing = 16.dp,
            mainAxisSpacing = 16.dp,
            mainAxisSize = SizeMode.Expand
        ) {
            /*
            CategoryHelper.getCategories().forEach { category ->
                Card(
                    modifier = Modifier.height(200.dp).width(350.dp)
                        .clickable(onClick = {

                        }, indication = RippleIndication())
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = category.title,
                            fontSize = 24.sp, fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = category.description,
                            modifier = Modifier.padding(end = 16.dp)
                        )
                    }
                }
            }
            */
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}