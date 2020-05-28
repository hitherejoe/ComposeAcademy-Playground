package co.joebirch.composeplayground.action

import androidx.compose.state
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.ui.core.TestTag
import androidx.ui.foundation.TextField
import androidx.ui.foundation.TextFieldValue
import androidx.ui.input.ImeAction
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Surface
import androidx.ui.test.*

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Rule

@RunWith(AndroidJUnit4::class)
class TextActionTests {

    @get:Rule
    val composeTestRule = createComposeRule()

    private fun launchContent() {
        composeTestRule.setContent {
            MaterialTheme {
                Surface {
                    val textValue = state { TextFieldValue() }
                    TestTag(tag = "MyTag") {
                        TextField(value = textValue.value, onValueChange = {
                            textValue.value = it
                        }, imeAction = ImeAction.Search, onImeActionPerformed = {
                            textValue.value = TextFieldValue("Search!")
                        })
                    }
                }
            }
        }
    }

    @Test
    fun testClick() {
        launchContent()
        findByTag("MyTag").apply {
            doSendText(text = "Some text")
            doReplaceText(text = "Replaced text")
            doClearText()
            doClick()
            doSendImeAction()
        }
    }
}