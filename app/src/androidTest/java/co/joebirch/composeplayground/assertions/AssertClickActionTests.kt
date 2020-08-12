package co.joebirch.composeplayground.assertions

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.ui.core.Modifier
import androidx.ui.core.testTag
import androidx.ui.foundation.Text
import androidx.ui.foundation.clickable
import androidx.ui.layout.Stack
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Surface
import androidx.ui.test.assertHasClickAction
import androidx.ui.test.assertHasNoClickAction
import androidx.ui.test.createComposeRule
import androidx.ui.test.findByTag
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AssertClickActionTests {

    @get:Rule
    val composeTestRule = createComposeRule()

    private fun launchContent(clickable: Boolean) {
        composeTestRule.setContent {
            MaterialTheme {
                Surface {
                    Stack {
                        if (clickable) {
                            Text(
                                text = "Hello",
                                modifier = Modifier.clickable(onClick = {

                                }).testTag("MyTag")
                            )
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