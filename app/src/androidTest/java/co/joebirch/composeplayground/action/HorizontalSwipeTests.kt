package co.joebirch.composeplayground.action

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Slider
import androidx.compose.material.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.unit.Duration
import androidx.compose.ui.unit.inMilliseconds
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HorizontalSwipeTests {

    @get:Rule
    val composeTestRule = createComposeRule()

    private fun launchContent() {
        composeTestRule.setContent {
            MaterialTheme {
                Surface {
                    val selectedValue = remember { mutableStateOf(0f) }
                    Slider(value = selectedValue.value, onValueChange = {
                        selectedValue.value = it
                    }, modifier = Modifier.testTag("MyTag"))
                }
            }
        }
    }

    @Test
    fun testSwipeHorizontal() {
        launchContent()
        composeTestRule.onNodeWithTag("MyTag")
            .performGesture {
                swipe(Offset(0f, 0f),  Offset(200f, 0f),
                    Duration(5000).apply { inMilliseconds() })
                swipeRight()
                swipeLeft()
            }
    }
}