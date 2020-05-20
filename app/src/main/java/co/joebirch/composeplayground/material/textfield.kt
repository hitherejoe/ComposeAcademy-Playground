package co.joebirch.composeplayground.material

import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.*
import androidx.ui.graphics.Color
import androidx.ui.graphics.RectangleShape
import androidx.ui.input.ImeAction
import androidx.ui.input.KeyboardType
import androidx.ui.input.PasswordVisualTransformation
import androidx.ui.layout.*
import androidx.ui.material.FilledTextField
import androidx.ui.text.TextStyle
import androidx.ui.unit.dp
import androidx.ui.unit.sp
import co.joebirch.composeplayground.ComposableLayout

object TextFieldView : ComposableLayout {

    @Composable
    override fun build() {
        VerticalScroller {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalGravity = Alignment.CenterHorizontally
            ) {
                MinimalTextFieldComponent()
                StyledTextFieldComponent()
                ImeActionTextFieldComponent()
                KeyboardTypeTextFieldComponent()
                FilledTextFieldComponent()
            }
        }
    }

    @Composable
    fun MinimalTextFieldComponent() {
        val state = state { TextFieldValue(text = "Hello") }
        TextField(
            value = state.value, onValueChange = {
                state.value = it
            }, textColor = Color.Black,
            modifier = Modifier.padding(16.dp).fillMaxWidth()
        )
    }

    @Composable
    fun StyledTextFieldComponent() {
        val state = state { TextFieldValue(text = "Hello") }
        TextField(
            value = state.value, onValueChange = {
                state.value = it
            },
            modifier = Modifier.padding(16.dp).fillMaxWidth(),
            textColor = Color.Red,
            cursorColor = Color.Blue,
            textStyle = TextStyle(fontSize = 20.sp)
        )
    }

    @Composable
    fun ImeActionTextFieldComponent() {
        val state = state { TextFieldValue(text = "Hello") }
        TextField(value = state.value, onValueChange = {
            state.value = it
        },
            modifier = Modifier.padding(16.dp).fillMaxWidth(),
            imeAction = ImeAction.Next,
            onImeActionPerformed = {

            })
    }

    @Composable
    fun KeyboardTypeTextFieldComponent() {
        val state = state { TextFieldValue(text = "Hello") }
        TextField(
            value = state.value, onValueChange = {
                state.value = it
            },
            modifier = Modifier.padding(16.dp).fillMaxWidth(),
            keyboardType = KeyboardType.Password,
            visualTransformation = PasswordVisualTransformation()
        )
    }

    @Composable
    fun FilledTextFieldComponent() {
        val state = state { TextFieldValue(text = "Hello") }
        FilledTextField(value = state.value, onValueChange = {
            state.value = it
        }, label = {
            Text(text = "This is a label")
        },
            inactiveColor = Color.Gray,
            activeColor = Color.Black,
            errorColor = Color.Red,
            backgroundColor = Color.LightGray,
            shape = RectangleShape
        )
    }
}