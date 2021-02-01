package co.joebirch.composeplayground.action

import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class ClickTests {

    @get:Rule
    val composeTestRule = createComposeRule()

    private fun launchContent() {
        composeTestRule.setContent {
            MaterialTheme {
                Surface {
                    val selected = remember { mutableStateOf(false) }
                    Checkbox(checked = selected.value, onCheckedChange = {
                        selected.value = it
                    }, modifier = Modifier.testTag("MyTag"))
                }
            }
        }
    }

    @Test
    fun testClick() {
        launchContent()
        composeTestRule
            .onNodeWithTag("MyTag")
            .performClick()
    }
}