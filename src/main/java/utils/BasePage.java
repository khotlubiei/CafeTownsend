package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class BasePage {
    protected static WebDriver driver;
    public BasePage (WebDriver driver) {
        this.driver = driver;
    }
    protected static WebElement myElement(By by) {
        return driver.findElement(by);
    }
    protected void clickOn (By by) {
        myElement(by).click();
    }

    protected void typeText (By by, String text){
        myElement(by).clear();
        myElement(by).sendKeys(text);
    }

    protected static String getElementText(By by){
        return myElement(by).getText();
    }

    protected void submitForm(By by){
        myElement(by).submit();
    }

    protected void confirmAlert (){
        int i=0;
        while(i++<5)
        {
            try
            {
                driver.switchTo().alert().accept();
                myElement(By.xpath("//body")).sendKeys(Keys.F5);
                break;
            }
            catch(NoAlertPresentException e)
            {
                myWaitSeconds(1);
            }
        }
    }

    protected static void waitForElement(By by) {
        myWaitSeconds(1); // REWORK THIS WORKAROUND
        int secondsWaited;
        for (secondsWaited = 1; myElement(by).isDisplayed() == false || secondsWaited == 30; secondsWaited++) {
                myWaitSeconds(1);
        }
        if (secondsWaited >= 30) {
            System.out.println("Element is not displayed after more than 30 seconds of wait");
        }
    }

    protected static void myWaitSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected static void doubleClick(By by) {
        waitForElement(by);
        Actions actions = new Actions(driver);
        actions.doubleClick(myElement(by)).perform();
    }

    protected Boolean isElementPresented (By by){
        try {
            return myElement(by).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    protected static String getInputText(By by) {
        return myElement(by).getAttribute("value");
    }




}
