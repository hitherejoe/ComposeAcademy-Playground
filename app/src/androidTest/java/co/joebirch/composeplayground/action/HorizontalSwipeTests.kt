package co.joebirch.composeplayground.action

import androidx.compose.state
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.ui.core.TestTag
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Slider
import androidx.ui.material.Surface
import androidx.ui.test.*

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Rule

@RunWith(AndroidJUnit4::class)
class HorizontalSwipeTests {

    @get:Rule
    val composeTestRule = createComposeRule()

    private fun launchContent() {
        composeTestRule.setContent {
            MaterialTheme {
                Surface {
                    val selectedValue = state { 0f }
                    TestTag(tag = "MyTag") {
                        Slider(value = selectedValue.value, onValueChange = {
                            selectedValue.value = it
                        })
                    }
                }
            }
        }
    }

    @Test
    fun testSwipeHorizontal() {
        launchContent()
        findByTag("MyTag").doGesture {
            sendSwipeRight()
            sendSwipeLeft()
        }
    }
}