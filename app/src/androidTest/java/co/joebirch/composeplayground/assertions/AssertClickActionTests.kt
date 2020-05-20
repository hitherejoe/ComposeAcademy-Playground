package co.joebirch.composeplayground.assertions

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.ui.core.TestTag
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.Text
import androidx.ui.layout.Stack
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Surface
import androidx.ui.test.*

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Rule

@RunWith(AndroidJUnit4::class)
class AssertClickActionTests {

    @get:Rule
    val composeTestRule = createComposeRule()

    private fun launchContent(clickable: Boolean) {
        composeTestRule.setContent {
            MaterialTheme {
                Surface {
                    Stack {
                        TestTag(tag = "MyTag") {
                            if (clickable) {
                                Clickable(onClick = {

                                }) {
                                    Text(
                                        text = "Hello"
                                    )
                                }
                            } else {
                                Text(
                                    text = "Hello"
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    @Test
    fun testHasClickAction() {
        launchContent(true)
        findByTag("MyTag").assertHasClickAction()
    }

    @Test
    fun testNoClickAction() {
        launchContent(false)
        findByTag("MyTag").assertHasNoClickAction()
    }
}