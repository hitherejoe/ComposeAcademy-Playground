package co.joebirch.composeplayground.assertions

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.ui.core.TestTag
import androidx.ui.layout.Stack
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Surface
import androidx.ui.material.Switch
import androidx.ui.test.*

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Rule

@RunWith(AndroidJUnit4::class)
class AssertToggleableTests {

    @get:Rule
    val composeTestRule = createComposeRule()

    private fun launchContent() {
        composeTestRule.setContent {
            MaterialTheme {
                Surface {
                    Stack {
                        TestTag(tag = "MyTag") {
                            Switch(checked = true, onCheckedChange = {

                            })
                        }
                    }
                }
            }
        }
    }

    @Test
    fun testToggleable() {
        launchContent()
        findByTag("MyTag").assertIsToggleable()
    }
}