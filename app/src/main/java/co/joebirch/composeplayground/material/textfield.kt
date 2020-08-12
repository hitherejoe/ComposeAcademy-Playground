package co.joebirch.composeplayground.material

import androidx.compose.foundation.BaseTextField
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.state
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.joebirch.composeplayground.ComposableLayout

@ExperimentalFoundationApi
object TextFieldView : ComposableLayout {

    @Composable
    override fun build() {
        ScrollableColumn {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalGravity = Alignment.CenterHorizontally
            ) {
                MinimalTextFieldComponent()
                StyledTextFieldComponent()
                ImeActionTextFieldComponent()
                KeyboardTypeTextFieldComponent()
            }
        }
    }

    @Composable
    fun MinimalTextFieldComponent() {
        val state = state { TextFieldValue(text = "Hello") }
        BaseTextField(
            value = state.value, onValueChange = {
                state.value = it
            }, textColor = Color.Black,
            modifier = Modifier.padding(16.dp).fillMaxWidth()
        )
    }

    @Composable
    fun StyledTextFieldComponent() {
        val state = state { TextFieldValue(text = "Hello") }
        BaseTextField(
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
        BaseTextField(value = state.value, onValueChange = {
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
        BaseTextField(
            value = state.value, onValueChange = {
                state.value = it
            },
            modifier = Modifier.padding(16.dp).fillMaxWidth(),
            keyboardType = KeyboardType.Password,
            visualTransformation = PasswordVisualTransformation()
        )
    }
}