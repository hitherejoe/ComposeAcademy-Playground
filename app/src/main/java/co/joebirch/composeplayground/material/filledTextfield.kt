package co.joebirch.composeplayground.material

import androidx.compose.material.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import co.joebirch.composeplayground.ComposableLayout

object FilledTextFieldView : ComposableLayout {

    @Composable
    override fun build() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MinimalFilledTextFieldComponent()
            PlaceholderFilledTextFieldComponent()
            IconsFilledTextFieldComponent()
        }
    }

    @Composable
    fun MinimalFilledTextFieldComponent() {
        val state = remember { mutableStateOf(TextFieldValue(text = "Hello")) }
        TextField(value = state.value, onValueChange = {
            state.value = it
        }, label = {
            Text(text = "This is a label")
        })
    }

    @Composable
    fun PlaceholderFilledTextFieldComponent() {
        val state = remember { mutableStateOf(TextFieldValue(text = "Hello")) }
        TextField(value = state.value, onValueChange = {
            state.value = it
        }, label = {
            Text(text = "This is a label")
        }, placeholder = {
            Text(text = "This is a placeholder")
        })
    }

    @Composable
    fun IconsFilledTextFieldComponent() {
        val state = remember { mutableStateOf(TextFieldValue(text = "Hello")) }
        TextField(value = state.value, onValueChange = {
            state.value = it
        }, label = {
            Text(text = "This is a label")
        }, leadingIcon = {
            Icon(Icons.Filled.Info, contentDescription = "Info")
        }, trailingIcon = {
            Icon(Icons.Filled.Check, contentDescription = "Checked")
        })
    }

    @Composable
    fun ColoredFilledTextFieldComponent() {
        val state = remember { mutableStateOf(TextFieldValue(text = "Hello")) }
        TextField(
            value = state.value,
            onValueChange = {
                state.value = it
            },
            label = {
                Text(text = "This is a label")
            },
            colors = TextFieldDefaults.textFieldColors(
                errorLabelColor = Color.Red,
                disabledTextColor = Color.Gray,
                textColor = Color.Black
            )
        )
    }

    @Composable
    fun VisualTransformationTextFieldComponent() {
        val state = remember { mutableStateOf(TextFieldValue(text = "Hello")) }
        TextField(
            value = state.value,
            onValueChange = {
                state.value = it
            },
            visualTransformation = PasswordVisualTransformation()
        )
    }

    @Composable
    fun ImeActionsTextFieldComponent() {
        val state = remember { mutableStateOf(TextFieldValue(text = "Hello")) }
        TextField(
            value = state.value,
            onValueChange = {
                state.value = it
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done
            )
        )
    }

    @Composable
    fun ColoredTextFieldComponent() {
        val state = remember { mutableStateOf(TextFieldValue(text = "Hello")) }
        TextField(
            value = state.value,
            onValueChange = {
                state.value = it
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White
            )
        )
    }

    @Composable
    fun ShapeTextFieldComponent() {
        val state = remember { mutableStateOf(TextFieldValue(text = "Hello")) }
        TextField(
            value = state.value,
            onValueChange = {
                state.value = it
            },
            shape = RoundedCornerShape(8.dp)
        )
    }

    @Composable
    fun KeyboardTypeTextFieldComponent() {
        val state = remember { mutableStateOf(TextFieldValue(text = "Hello")) }
        TextField(
            value = state.value,
            onValueChange = {
                state.value = it
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            )
        )
    }

    @Composable
    fun TextStyleTextFieldComponent() {
        val state = remember { mutableStateOf(TextFieldValue(text = "Hello")) }
        TextField(
            value = state.value,
            onValueChange = {
                state.value = it
            },
            textStyle = TextStyle(color = Color.Red)
        )
    }
}