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
class AssertOnOffTests {

    @get:Rule
    val composeTestRule = createComposeRule()

    private fun launchContent(isOn: Boolean) {
        composeTestRule.setContent {
            MaterialTheme {
                Surface {
                    Stack {
                        TestTag(tag = "MyTag") {
                            Switch(checked = isOn, onCheckedChange = { })
                        }
                    }
                }
            }
        }
    }

    @Test
    fun testExists() {
        launchContent(true)
        findByTag("MyTag").assertIsOn()
    }

    @Test
    fun testNotExists() {
        launchContent(false)
        findByTag("MyTag").assertIsOff()
    }
}