package co.joebirch.composeplayground.assertions

import android.os.SystemClock
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.ui.core.Modifier
import androidx.ui.foundation.Text
import androidx.ui.layout.preferredHeight
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Surface
import androidx.ui.test.assertIsDisplayed
import androidx.ui.test.assertIsNotDisplayed
import androidx.ui.test.createComposeRule
import androidx.ui.test.findByText
import androidx.ui.unit.dp

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Rule

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
        findByText("Hello").assertIsDisplayed()
    }

    @Test
    fun testIsNotDisplayed() {
        launchContent(true)
        SystemClock.sleep(3000)
        findByText("Hello").assertIsNotDisplayed()
    }
}