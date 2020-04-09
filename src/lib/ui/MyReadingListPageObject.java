package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MyReadingListPageObject extends MainPageObject {

    private static final String
            ARTICLE = "org.wikipedia:id/page_list_item_title",
            PATH_TO_ARTICLE_TPL = "//*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='{SUBSTRING}']",
            PATH_TO_READING_LIST_TPL = "//*[@resource-id='org.wikipedia:id/item_title'][@text='{SUBSTRING}']";

    public MyReadingListPageObject(AppiumDriver driver) {
        super(driver);
    }

    public String getNameOfArticle() {
        return this.waitForElementAndGetAttribute(
                By.id(ARTICLE),
                "text",
                "Cannot get attribute text",
                10);
    }

    public void openArticleByName(String articleName) {
        String article = replaceTemplate(PATH_TO_ARTICLE_TPL, articleName);
        this.waitForElementAndClick(
                By.xpath(article),
                "Cannot click of article",
                10);
    }

    public void deleteArticleByName(String articleName) {
        String article = replaceTemplate(PATH_TO_ARTICLE_TPL, articleName);
        this.swipeElementToLeft(
                By.xpath(article),
                "Cannot swipe element to left");
    }

    private static String replaceTemplate(String template, String substring) {
        return template.replace("{SUBSTRING}", substring);
    }

    public int getCountOfArticles() {
        return this.waitAndReturnListOfElements(
                By.id("org.wikipedia:id/page_list_item_title"),
                "Cannot find list of articles",
                10).size();
    }

    public void openReadingList(String readingListName) {
        String readingList = replaceTemplate(PATH_TO_READING_LIST_TPL, readingListName);
        this.waitForElementAndClick(
                By.xpath(readingList),
                "Cannot find list for saved articles",
                10);
    }

}
