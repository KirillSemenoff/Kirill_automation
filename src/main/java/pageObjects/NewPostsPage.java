package pageObjects;

/**
 * Created by ksemenov on 11/18/2015.
 */

import core.WebDriverExtension;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewPostsPage extends WebDriverExtension {

    public NewPostsPage (WebDriver driver){
        super(driver);
    }

    protected By postTitle = By.id("title");
    protected By postsMenu = By.id("menu-posts");
    protected By addNewSubMenu=By.xpath("//a[text()='Добавить новую']");

    public void Open () {
        MoveMouseOverElement(postsMenu);
           if (isElementPresent(driver,addNewSubMenu)){
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(addNewSubMenu)));
            //System.out.println(driver.findElement(addNewSubMenu).isDisplayed());//to check if element is present on the page and visible to the method
        MoveMouseOverElementAndClick(addNewSubMenu);
    }
    else
        {
            System.out.println("failed");
        }
    }

    public void ProvidePostTitle (String text) {
        driver.findElement(postTitle).sendKeys(text);
    }

    public void ProvidePostBody (String text) {
        driver.switchTo().frame("content_ifr");
        driver.switchTo().activeElement().sendKeys(text);
        driver.switchTo().defaultContent();
    }

    public void ClickPublishButton () {
        waitForElementEnabled(By.id("publish"));
        driver.findElement(By.id("publish")).click();
    }

    public void ClickViewPost () {
        driver.findElement(By.linkText("Посмотреть")).click();

    }

}
