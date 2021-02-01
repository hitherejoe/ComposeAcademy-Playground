package co.joebirch.composeplayground.assertions

import androidx.compose.foundation.layout.Box
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Switch
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.assertIsToggleable
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AssertToggleableTests {

    @get:Rule
    val composeTestRule = createComposeRule()

    private fun launchContent() {
        composeTestRule.setContent {
            MaterialTheme {
                Surface {
                    Box {
                        Switch(checked = true, onCheckedChange = {

                        }, modifier = Modifier.testTag("MyTag"))
                    }
                }
            }
        }
    }

    @Test
    fun testToggleable() {
        launchContent()
        composeTestRule.onNodeWithTag("MyTag").assertIsToggleable()
    }
}