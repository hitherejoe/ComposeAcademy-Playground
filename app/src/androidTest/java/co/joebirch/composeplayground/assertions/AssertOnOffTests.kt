package co.joebirch.composeplayground.assertions

import androidx.compose.foundation.layout.Box
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Switch
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.assertIsOff
import androidx.compose.ui.test.assertIsOn
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AssertOnOffTests {

    @get:Rule
    val composeTestRule = createComposeRule()

    private fun launchContent(isOn: Boolean) {
        composeTestRule.setContent {
            MaterialTheme {
                Surface {
                    Box {
                        Switch(
                            checked = isOn, onCheckedChange = { },
                            modifier = Modifier.testTag("MyTag")
                        )
                    }
                }
            }
        }
    }

    @Test
    fun testExists() {
        launchContent(true)
        composeTestRule.onNodeWithTag("MyTag").assertIsOn()
    }

    @Test
    fun testNotExists() {
        launchContent(false)
        composeTestRule.onNodeWithTag("MyTag").assertIsOff()
    }
}