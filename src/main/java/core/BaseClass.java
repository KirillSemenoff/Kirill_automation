package core;

/**
 * Created by ksemenov on 11/13/2015.
 */

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageObjects.LoginPage;
import pageObjects.NewPostsPage;
import pageObjects.PostsPage;
import pageObjects.ViewPostsPage;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

//Created by Kirill Semenov on 11/13/15

public class BaseClass {

    protected static WebDriver driver;
        public LoginPage loginPage = PageFactory.initElements(getCurrentDriver(),LoginPage.class);
        public static NewPostsPage newPostPage = new NewPostsPage(getCurrentDriver());
        public static PostsPage postsPage = new PostsPage(getCurrentDriver());
        public static ViewPostsPage viewPostsPage = new ViewPostsPage(getCurrentDriver());



    protected static WebDriver getCurrentDriver (){
        if (driver == null){
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        }
        return driver;
    }

    @BeforeTest
    public void SetUp() {
        loginPage.Open();
        driver.manage().window().maximize();
        loginPage.ProvideUserName();
        loginPage.ProvideUserPassword();
        loginPage.ClickLogin();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    }

    @AfterTest
    public void TearDown() {
        driver.quit();
    }

}
