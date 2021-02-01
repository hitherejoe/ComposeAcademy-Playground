package co.joebirch.composeplayground.assertions

import androidx.compose.material.Text
import androidx.compose.foundation.layout.Box
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AssertExistsTests {

    @get:Rule
    val composeTestRule = createComposeRule()

    private fun launchContent(hidden: Boolean) {
        composeTestRule.setContent {
            MaterialTheme {
                Surface {
                    Box {
                        if (!hidden) {
                            Text(
                                text = "Hello"
                            )
                        }
                    }
                }
            }
        }
    }

    @Test
    fun testExists() {
        launchContent(false)
        composeTestRule.onNodeWithTag("Hello").assertExists()
    }

    @Test
    fun testNotExists() {
        launchContent(true)
        composeTestRule.onNodeWithTag("Hello").assertDoesNotExist()
    }
}