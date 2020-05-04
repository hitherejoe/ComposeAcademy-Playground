package co.joebirch.composeplayground

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.Model
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.Icon
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.foundation.selection.ToggleableState
import androidx.ui.foundation.shape.corner.CircleShape
import androidx.ui.graphics.Color
import androidx.ui.graphics.imageFromResource
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.res.imageResource
import androidx.ui.res.vectorResource
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp

class RadioButtonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Column(modifier = Modifier.wrapContentSize(align = Alignment.Center)) {
                    SimpleRadioGroupTextItemComponent(RadioState())
                }
            }
        }
    }
}

@Model
class RadioState(var selectedOption: String? = null)


@Composable
fun SimpleRadioGroupComponent(formState: RadioState) {
    val options = listOf("one", "two", "three")
    RadioGroup {
        RadioGroupItem(selected = options[0] == formState.selectedOption, onSelect = {
            formState.selectedOption = options[0]
        }) {
            RadioButtonWithLabel(formState = formState, text = options[0])
        }
        RadioGroupTextItem(selected = options[1] == formState.selectedOption, onSelect = {
            formState.selectedOption = options[1]
        }, text = "Hello!")
    }
}

@Composable
fun SimpleRadioGroupTextItemComponentTwo(formState: RadioState) {
    val options = listOf("one", "two", "three")
    RadioGroup {
        RadioGroupTextItem(selected = options[0] == formState.selectedOption, onSelect = {
            formState.selectedOption = options[0]
        }, text = options[0])
        RadioGroupTextItem(selected = options[1] == formState.selectedOption, onSelect = {
            formState.selectedOption = options[1]
        }, text = options[1])
    }
}

@Composable
fun SimpleRadioGroupTextItemComponent(formState: RadioState) {
    val options = listOf("one", "two", "three")
    RadioGroup {
        RadioGroupItem(selected = options[0] == formState.selectedOption, onSelect = {
            formState.selectedOption = options[0]
        }) {
            Row(modifier = Modifier.padding(10.dp)) {
                if (options[0] == formState.selectedOption) {
                    Image(asset = vectorResource(id = R.drawable.ic_android_black_24dp))
                } else {
                    Image(asset = vectorResource(id = R.drawable.ic_android_gray_24dp))
                }
                Text(
                        text = options[0],
                        modifier = Modifier.padding(start = 18.dp)
                )
            }
        }
        RadioGroupItem(selected = options[1] == formState.selectedOption, onSelect = {
            formState.selectedOption = options[1]
        }) {
            Row(modifier = Modifier.padding(10.dp)) {
                if (options[1] == formState.selectedOption) {
                    Image(asset = vectorResource(id = R.drawable.ic_android_black_24dp))
                } else {
                    Image(asset = vectorResource(id = R.drawable.ic_android_gray_24dp))
                }
                Text(
                        text = options[1],
                        modifier = Modifier.padding(start = 18.dp)
                )
            }
        }
        RadioGroupItem(selected = options[2] == formState.selectedOption, onSelect = {
            formState.selectedOption = options[2]
        }) {
            Row(modifier = Modifier.padding(10.dp)) {
                if (options[2] == formState.selectedOption) {
                    Image(asset = vectorResource(id = R.drawable.ic_android_black_24dp))
                } else {
                    Image(asset = vectorResource(id = R.drawable.ic_android_gray_24dp))
                }
                    Text(
                        text = options[2],
                        modifier = Modifier.padding(start = 18.dp)
                )
            }
        }
    }
}

@Composable
fun SimpleGroupComponent(formState: RadioState) {
    val options = listOf("one", "two", "three")
    RadioGroup(
            options = options,
            selectedOption = formState.selectedOption ?: options[0],
            onSelectedChange = {
                formState.selectedOption = it
            },
            radioColor = Color.Red,
            textStyle = TextStyle(fontWeight = FontWeight.Bold)
    )
}

@Composable
fun RadioGroupComponent(formState: RadioState) {
    val options = listOf("one", "two", "three")
    RadioGroup(
            options = options,
            selectedOption = formState.selectedOption ?: options[0],
            onSelectedChange = {
                formState.selectedOption = it
            },
            radioColor = Color.Red,
            textStyle = TextStyle(fontWeight = FontWeight.Bold)
    )
}

@Composable
fun RadioButtonWithLabel(
        text: String,
        formState: RadioState
) {
    Row(modifier = Modifier.padding(10.dp)) {
        RadioButton(
                selected = formState.selectedOption == text,
                onSelect = {
                    formState.selectedOption = text
                }
        )
        Text(
                text = text,
                modifier = Modifier.padding(start = 18.dp)
        )
    }
}