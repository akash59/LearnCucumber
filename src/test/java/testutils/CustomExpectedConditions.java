package testutils;

import core.controller.Controller;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class CustomExpectedConditions {

    private final Controller controller;
    private final WebDriver driver;

    public CustomExpectedConditions(Controller controller) {
        this.controller = controller;
        this.driver = controller.getDriver();
    }

    public ExpectedCondition<Boolean> hasGoogleHomePageLoaded(final By searchBox) {
        return hasLoaded -> driver.findElement(searchBox).isDisplayed()
                && driver.findElement(searchBox).isEnabled();
    }

    public ExpectedCondition<Boolean> hasSearchResultsLoaded(final By searchResult) {
        JavascriptExecutor exec = (JavascriptExecutor) driver;
        return hasLoaded ->
                exec.executeScript("return document.readyState").equals("complete") &&
                driver.findElement(searchResult).isEnabled();
    }



}

