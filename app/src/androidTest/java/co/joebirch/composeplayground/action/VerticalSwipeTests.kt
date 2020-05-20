package co.joebirch.composeplayground.action

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.ui.core.Modifier
import androidx.ui.core.TestTag
import androidx.ui.foundation.AdapterList
import androidx.ui.foundation.Text
import androidx.ui.layout.padding
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Surface
import androidx.ui.test.*
import androidx.ui.unit.dp

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Rule
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
                    TestTag(tag = "MyTag") {
                        AdapterList(data = content) {
                            Text(
                                text = it,
                                modifier = Modifier.padding(16.dp)
                            )
                        }
                    }
                }
            }
        }
    }

    @Test
    fun testSwipeVertical() {
        launchContent()
        findByTag("MyTag").doGesture {
            sendSwipeUp()
            sendSwipeDown()
        }
    }
}