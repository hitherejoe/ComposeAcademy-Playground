package co.joebirch.composeplayground.assertions

import android.os.SystemClock
import androidx.compose.material.Text
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.unit.dp
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AssertDisplayedTests {

    @get:Rule
    val composeTestRule = createComposeRule()

    private fun launchContent(hidden: Boolean) {
        composeTestRule.setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.preferredHeight(
                        if (hidden) 0.dp else 100.dp
                    )
                ) {
                    Text(
                        text = "Hello"
                    )
                }
            }
        }
    }

    @Test
    fun testIsDisplayed() {
        launchContent(false)
        composeTestRule.onNodeWithTag("Hello").assertIsDisplayed()
    }

    @Test
    fun testIsNotDisplayed() {
        launchContent(true)
        SystemClock.sleep(3000)
        composeTestRule.onNodeWithTag("Hello").assertIsNotDisplayed()
    }
}