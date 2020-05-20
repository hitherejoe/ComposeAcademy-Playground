package co.joebirch.composeplayground.assertions

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.ui.foundation.Text
import androidx.ui.layout.Stack
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Surface
import androidx.ui.test.createComposeRule
import androidx.ui.test.findByText

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Rule

@RunWith(AndroidJUnit4::class)
class AssertExistsTests {

    @get:Rule
    val composeTestRule = createComposeRule()

    private fun launchContent(hidden: Boolean) {
        composeTestRule.setContent {
            MaterialTheme {
                Surface {
                    Stack {
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
        findByText("Hello").assertExists()
    }

    @Test
    fun testNotExists() {
        launchContent(true)
        findByText("Hello").assertDoesNotExist()
    }
}