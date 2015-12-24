package pageObjects;

/**
 * Created by ksemenov on 11/18/2015.
 */

import core.WebDriverExtension;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ViewPostsPage extends WebDriverExtension {


    public static By postTitle = By.className("entry-title");
    public static By postBody = By.className("entry-content");

    public  ViewPostsPage (WebDriver driver){
        super(driver);
    }

    public boolean CheckPostPresent (String string){
         By postxpath = By.xpath("//*[text()=\""+string+"\"]");
        //System.out.println(postxpath);
        try {
           driver.findElement(postxpath);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    }
