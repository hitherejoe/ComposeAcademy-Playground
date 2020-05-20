package co.joebirch.composeplayground.action

import androidx.compose.state
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.ui.core.TestTag
import androidx.ui.material.Checkbox
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Surface
import androidx.ui.test.*

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Rule

@RunWith(AndroidJUnit4::class)
class ClickTests {

    @get:Rule
    val composeTestRule = createComposeRule()

    private fun launchContent() {
        composeTestRule.setContent {
            MaterialTheme {
                Surface {
                    val selected = state { false }
                    TestTag(tag = "MyTag") {
                        Checkbox(checked = selected.value, onCheckedChange = {
                            selected.value = it
                        })
                    }
                }
            }
        }
    }

    @Test
    fun testClick() {
        launchContent()
        findByTag("MyTag").doClick()
    }
}