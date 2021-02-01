package co.joebirch.composeplayground.action

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.TextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TextActionTests {

    @get:Rule
    val composeTestRule = createComposeRule()

    private fun launchContent() {
        composeTestRule.setContent {
            MaterialTheme {
                Surface {
                    val textValue = remember { mutableStateOf(TextFieldValue()) }
                    TextField(value = textValue.value, onValueChange = {
                        textValue.value = it
                    }, imeAction = ImeAction.Search, onImeActionPerformed = { _, _ ->
                        textValue.value = TextFieldValue("Search!")
                    }, modifier = Modifier.testTag("MyTag"))
                }
            }
        }
    }

    @Test
    fun testClick() {
        launchContent()
        composeTestRule.onNodeWithTag("MyTag").performGesture {

        }
        composeTestRule.onNodeWithTag("MyTag").apply {
            performTextInput("Some text")
            performTextReplacement("Replaced text")
            performTextClearance()
            performClick()
            performImeAction()
            performScrollTo()
        }
    }
}