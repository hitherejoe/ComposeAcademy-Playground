package co.joebirch.composeplayground.material

import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.RadioButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.state
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout
import co.joebirch.composeplayground.R

object TriStateRadioButtonView: ComposableLayout {

    @Composable
    override fun build() {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalGravity = Alignment.CenterHorizontally
        ) {
            SimpleTriRadioGroupComponent()
        }
    }

}

@Composable
fun SimpleTriRadioGroupComponent() {
    val options = listOf("one", "two", "three")
    val formState = state { "" }
    Column {
        Row(modifier = Modifier.selectable(
            selected = options[0] == formState.value,
            onClick = {
                formState.value = options[0]
            }
        )) {
            RadioButton(selected = options[0] == formState.value, onClick = {
                formState.value = options[0]
            })
            Text(text = options[0])
        }
        Row(modifier = Modifier.selectable(
            selected = options[1] == formState.value,
            onClick = {
                formState.value = options[1]
            }
        )) {
            RadioButton(selected = options[1] == formState.value, onClick = {
                formState.value = options[1]
            })
            Text(text = options[1])
        }
    }
}

@Composable
fun SimpleTriRadioGroupTextItemComponentTwo(formState: RadioState) {
    val options = listOf("one", "two", "three")

    Column {
        Row(modifier = Modifier.selectable(
            selected = options[0] == formState.selectedOption,
            onClick = {
                formState.selectedOption = options[0]
            }
        )) {
            RadioButton(selected = options[0] == formState.selectedOption, onClick = {
                formState.selectedOption = options[0]
            })
            Text(text = options[0])
        }
        Row(modifier = Modifier.selectable(
            selected = options[1] == formState.selectedOption,
            onClick = {
                formState.selectedOption = options[1]
            }
        )) {
            RadioButton(selected = options[1] == formState.selectedOption, onClick = {
                formState.selectedOption = options[1]
            })
            Text(text = options[1])
        }
    }
}

@Composable
fun SimpleTriRadioGroupTextItemComponent(formState: RadioState) {
    val options = listOf("one", "two", "three")
    Column {
        Row(modifier = Modifier.selectable(
            selected = options[0] == formState.selectedOption,
            onClick = {
                formState.selectedOption = options[0]
            }
        )) {
            if (options[0] == formState.selectedOption) {
                Image(asset = vectorResource(id = R.drawable.ic_android_black_24dp))
            } else {
                Image(asset = vectorResource(id = R.drawable.ic_android_gray_24dp))
            }
            Text(text = options[0])
        }
        Row(modifier = Modifier.selectable(
            selected = options[1] == formState.selectedOption,
            onClick = {
                formState.selectedOption = options[1]
            }
        )) {
            if (options[1] == formState.selectedOption) {
                Image(asset = vectorResource(id = R.drawable.ic_android_black_24dp))
            } else {
                Image(asset = vectorResource(id = R.drawable.ic_android_gray_24dp))
            }
            Text(text = options[1])
        }
    }
}

@Composable
fun TriRadioButtonWithLabel(
    text: String,
    formState: RadioState
) {
    Row(modifier = Modifier.padding(10.dp)) {
        RadioButton(
            selected = formState.selectedOption == text,
            onClick = {
                formState.selectedOption = text
            }
        )
        Text(
            text = text,
            modifier = Modifier.padding(start = 18.dp)
        )
    }
}