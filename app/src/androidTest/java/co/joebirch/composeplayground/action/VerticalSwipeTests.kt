package co.joebirch.composeplayground.action

import androidx.compose.material.Text
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performGesture
import androidx.compose.ui.test.swipeDown
import androidx.compose.ui.test.swipeUp
import androidx.compose.ui.unit.dp
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*

@RunWith(AndroidJUnit4::class)
class VerticalSwipeTests {

    @get:Rule
    val composeTestRule = createComposeRule()

    private fun launchContent() {
        composeTestRule.setContent {
            MaterialTheme {
                Surface {
                    val content = (0..100).map { UUID.randomUUID().toString() }
                    LazyColumnFor(content) {
                        Text(
                            text = it,
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }
            }
        }
    }

    @Test
    fun testSwipeVertical() {
        launchContent()
        composeTestRule.onNodeWithTag("MyTag").performGesture {
            swipeUp()
            swipeDown()
        }
    }
}