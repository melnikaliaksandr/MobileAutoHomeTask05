package tests;

import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class SearchTest extends CoreTestCase {

    @Test
    public void testOpenArticleWithTitleAndDescription() {
        SearchPageObject searchPageObject = new SearchPageObject(driver);
        searchPageObject.skipOnboarding();
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");
        assertTrue(searchPageObject.waitForElementByTitleAndDescription(
                "Java (programming language)", "Object-oriented programming language"));
    }

}
