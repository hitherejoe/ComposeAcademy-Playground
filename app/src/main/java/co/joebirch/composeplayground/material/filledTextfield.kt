package co.joebirch.composeplayground.material

import androidx.compose.foundation.Icon
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.state
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import co.joebirch.composeplayground.ComposableLayout

object FilledTextFieldView : ComposableLayout {

    @Composable
    override fun build() {
        ScrollableColumn {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                MinimalFilledTextFieldComponent()
                PlaceholderFilledTextFieldComponent()
                IconsFilledTextFieldComponent()
            }
        }
    }

    @Composable
    fun MinimalFilledTextFieldComponent() {
        val state = state { TextFieldValue(text = "Hello") }
        TextField(value = state.value, onValueChange = {
            state.value = it
        }, label = {
            Text(text = "This is a label")
        })
    }

    @Composable
    fun PlaceholderFilledTextFieldComponent() {
        val state = state { TextFieldValue(text = "Hello") }
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
        val state = state { TextFieldValue(text = "Hello") }
        TextField(value = state.value, onValueChange = {
            state.value = it
        }, label = {
            Text(text = "This is a label")
        }, leadingIcon = {
            Icon(Icons.Filled.Info)
        }, trailingIcon = {
            Icon(Icons.Filled.Check)
        })
    }

    @Composable
    fun ColoredFilledTextFieldComponent() {
        val state = state { TextFieldValue(text = "Hello") }
        TextField(value = state.value, onValueChange = {
            state.value = it
        }, label = {
            Text(text = "This is a label")
        }, activeColor = Color.Black,
            inactiveColor = Color.Gray,
            errorColor = Color.Red)
    }
}