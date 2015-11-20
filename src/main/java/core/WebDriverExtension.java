package core;

/**
 * Created by ksemenov on 11/13/2015.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class WebDriverExtension {

    protected static WebDriver driver;

    public WebDriverExtension (WebDriver driver) {
        this.driver=driver;
            }

    protected static void MoveMouseOverElement (By element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(element)).perform();
    }

    protected static void MoveMouseOverElementAndClick (By element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(element)).click().perform();
    }

   public static boolean isElementContainsText (By by,String text){
       try {
           return driver.findElement(by).getText().contains(text);
       } catch (NullPointerException e) {
           return false;
       }
   }

    public static boolean isElementPresent (WebDriver driver,By by) {
        try {
            driver.findElement(by);//if it does not find the element throw NoSuchElementException, which calls "catch(Exception)" and returns false;
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void waitForElementEnabled (final By by) {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(new ExpectedCondition<Boolean>() {
            //@Override - not working (?)
            public Boolean apply (WebDriver driver) {
                return !driver.findElement(by).getAttribute("class").contains("disabled");
            }
        });
    }
}
