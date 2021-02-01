package co.joebirch.composeplayground.assertions

import androidx.compose.material.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
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
                    Box {
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
        composeTestRule.onNodeWithTag("MyTag")
            .assertHasClickAction()
    }

    @Test
    fun testNoClickAction() {
        launchContent(false)
        composeTestRule.onNodeWithTag("MyTag")
            .assert(isHidden())
    }
}