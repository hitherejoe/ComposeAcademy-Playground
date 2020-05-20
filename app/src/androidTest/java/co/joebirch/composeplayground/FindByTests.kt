package co.joebirch.composeplayground

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.ui.core.TestTag
import androidx.ui.foundation.Text
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Surface
import androidx.ui.test.*

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Before
import org.junit.Rule

@RunWith(AndroidJUnit4::class)
class FindByTests {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun launchContent() {
        composeTestRule.setContent {
            MaterialTheme {
                Surface {
                    TestTag(tag = "MyTag") {
                        Text(text = "Hello")
                    }
                }
            }
        }
    }

    @Test
    fun testFindByText() {
        findByText("Hello").assertIsDisplayed()
    }

    @Test
    fun testFindAllByText() {
        findAllByText("Hello").first().assertIsDisplayed()
    }

    @Test
    fun testFindByTag() {
        findByTag("MyTag").assertIsDisplayed()
    }

    @Test
    fun testFindAllByTag() {
        findAllByTag("MyTag").first().assertIsDisplayed()
    }
}