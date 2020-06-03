package page_actions;

import core.controller.Controller;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class ActionsBase {

    protected WebDriverWait wait;
    protected WebDriver driver;
    protected Controller controller;

    public ActionsBase(Controller controller) {
        this.controller = controller;
        this.driver = controller.getDriver();
        this.wait = getWait(5000);
    }

    public WebDriverWait getWait(long timeOut) {
        if(null != wait) {
            return wait;
        }
        return new WebDriverWait(driver, timeOut);
    }


    public void setWait(WebDriverWait wait) {
        this.wait = wait;
    }

    protected void type(By loc, CharSequence text) {
        driver.findElement(loc).sendKeys(text);
    }

    protected void type(WebElement element, CharSequence text) {
        waitForVisibilityOfElement(element, 2000);
        element.clear();
        element.sendKeys(text);
    }

    protected void click(By loc) {
        wait.until(ExpectedConditions.elementToBeClickable(loc));
        driver.findElement(loc).click();
    }

    protected void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    protected void pressEnterKey(WebElement element) {
        type(element, Keys.ENTER);
    }

    protected void openPage(String url){
        driver.navigate().to(url);
    }

    protected WebElement getWebElement(By loc, long timeout) {
        return getWait(timeout).until(driver -> driver.findElement(loc));
    }

    public void waitForVisibilityOfElement(By locator, long timeOut)
    {
        getWait(timeOut).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForVisibilityOfElement(WebElement element, long timeOut)
    {
        wait = getWait(timeOut);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected Boolean isEnabled(By locator, long timeOutInSeconds)
    {
        waitForVisibilityOfElement(locator, timeOutInSeconds);
        return driver.findElement(locator).isEnabled();
    }







}
