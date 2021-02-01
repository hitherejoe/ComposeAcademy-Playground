package co.joebirch.composeplayground

import androidx.compose.material.Text
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.SemanticsProperties.TestTag
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.text.input.ImeAction
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FindByTests {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun launchContent() {
        composeTestRule.setContent {
            MaterialTheme {
                Surface {
                    Text(
                        text = "Hello",
                        modifier = Modifier.testTag("MyTag")
                    )
                }
            }
        }
    }

    @Test
    fun testOnNodeWithText() {
        composeTestRule.onNodeWithText("Hello")
    }

    @Test
    fun testFindAllByText() {
        composeTestRule.onAllNodesWithText("Hello").first().assertIsDisplayed()
    }

    @Test
    fun testFindBySubstring() {
        composeTestRule.onNodeWithSubstring("Hello")
    }

    @Test
    fun testFindAllNoesHasTestTag() {
        composeTestRule.onAllNodes(hasTestTag("Hello")).first().assertIsDisplayed()
    }

    @Test
    fun testFindAllNoesHasText() {
        composeTestRule.onAllNodes(hasText("Hello")).first().assertIsDisplayed()
    }

    @Test
    fun testFindAllNoesHasClickAction() {
        composeTestRule.onAllNodes(hasClickAction()).first().assertIsDisplayed()
    }

    @Test
    fun testFindAllNoesHasNoClickAction() {
        composeTestRule.onAllNodes(hasNoClickAction()).first().assertIsDisplayed()
    }

    @Test
    fun testFindAllNodesHasScrollAction() {
        composeTestRule.onAllNodes(hasScrollAction()).first().assertIsDisplayed()
    }

    @Test
    fun testFindAllNodesHasNoScrollAction() {
        composeTestRule.onAllNodes(hasNoScrollAction()).first().assertIsDisplayed()
    }

    @Test
    fun testFindAllNodesHasImeAction() {
        composeTestRule.onAllNodes(hasImeAction(ImeAction.Done)).first().assertIsDisplayed()
    }

    @Test
    fun testFindAllNodesHasValue() {
        composeTestRule.onAllNodes(hasValue("some_value")).first().assertIsDisplayed()
    }

    @Test
    fun testFindAllNodesHasAnyChild() {
        composeTestRule.onAllNodes(hasAnyChild(isEnabled())).first().assertIsDisplayed()
    }

    @Test
    fun testFindAllNodesHasAnyAncestor() {
        composeTestRule.onAllNodes(hasAnyAncestor(isEnabled())).first().assertIsDisplayed()
    }

    @Test
    fun testFindAllNodesHasAnyDescendant() {
        composeTestRule.onAllNodes(hasAnyDescendant(isEnabled())).first().assertIsDisplayed()
    }

    @Test
    fun testFindAllNodesHasAnySibling() {
        composeTestRule.onAllNodes(hasAnySibling(isEnabled())).first().assertIsDisplayed()
    }

    @Test
    fun testFindAllNodesHasParent() {
        composeTestRule.onAllNodes(hasParent(isEnabled())).first().assertIsDisplayed()
    }

    @Test
    fun testFindByTag() {
        composeTestRule.onNodeWithTag("MyTag").assertIsDisplayed()
    }

    @Test
    fun testFindAllByTag() {
        composeTestRule.onAllNodesWithTag("MyTag").first().assertIsDisplayed()
    }

    @Test
    fun testFindByLabel() {
        composeTestRule.onNodeWithLabel("Hello")
    }

    @Test
    fun testFindAllByLabel() {
        composeTestRule.onAllNodesWithLabel("Hello").first().assertIsDisplayed()
    }
}