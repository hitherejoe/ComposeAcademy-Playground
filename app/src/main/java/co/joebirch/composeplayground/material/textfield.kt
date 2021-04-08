package co.joebirch.composeplayground.material

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.joebirch.composeplayground.ComposableLayout

@ExperimentalFoundationApi
object TextFieldView : ComposableLayout {

    @Composable
    override fun build() {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MinimalTextFieldComponent()
            StyledTextFieldComponent()
            ImeActionTextFieldComponent()
            KeyboardTypeTextFieldComponent()
        }
    }

    @Composable
    fun MinimalTextFieldComponent() {
        val state = remember { mutableStateOf(TextFieldValue(text = "Hello")) }
        BasicTextField(
            value = state.value, onValueChange = {
                state.value = it
            },
            modifier = Modifier.padding(16.dp).fillMaxWidth()
        )
    }

    @Composable
    fun StyledTextFieldComponent() {
        val state = remember { mutableStateOf(TextFieldValue(text = "Hello")) }
        BasicTextField(
            value = state.value, onValueChange = {
                state.value = it
            },
            modifier = Modifier.padding(16.dp).fillMaxWidth(),
            textStyle = TextStyle(fontSize = 20.sp)
        )
    }

    @Composable
    fun ImeActionTextFieldComponent() {
        val state = remember { mutableStateOf(TextFieldValue(text = "Hello")) }
        BasicTextField(
            value = state.value, onValueChange = {
                state.value = it
            },
            modifier = Modifier.padding(16.dp).fillMaxWidth()
        )
    }

    @Composable
    fun KeyboardTypeTextFieldComponent() {
        val state = remember { mutableStateOf(TextFieldValue(text = "Hello")) }
        BasicTextField(
            value = state.value,
            onValueChange = {
                state.value = it
            },
            modifier = Modifier.padding(16.dp).fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )
    }
}