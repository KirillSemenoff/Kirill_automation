/**
 * Created by ksemenov on 11/11/2015.
 */


import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Task2 {



    protected static WebDriver driver;
    String postBody= "Once upon a time lived Vadim who provided Selenium's course";
    String expression;
    WebElement temp;
    public void  method2() {

        driver=new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.navigate().to("http://localhost:39015/wp-login.php");
        driver.findElement(By.xpath("//label[@for=\"user_login\"]")).sendKeys("Kirill");
        driver.findElement(By.xpath("//label[@for=\"user_pass\"]")).sendKeys("password");
        driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
        driver.findElement(By.xpath("//a[@href=\"edit.php\"]//div[@class=\"wp-menu-name\"]")).click();
        driver.findElement(By.xpath("//a[@href=\"post-new.php\"]")).click();
        driver.findElement(By.xpath("//input[@id=\"title\"]")).sendKeys("Test post title");

        //enter body text
        driver.switchTo().frame("content_ifr");
        driver.findElement(By.xpath("//body[@id=\"tinymce\"]")).click();
        driver.findElement(By.xpath("//body[@id=\"tinymce\"]")).sendKeys("Test post body");
        driver.switchTo().defaultContent();
        driver.findElements(By.tagName("div"));

        //Save post
        driver.findElement(By.xpath("//input[@id=\"save-post\"]")).click();
        //Navigating to new window
        driver.findElement(By.xpath("//a[@class=\"button button-small\"]")).click();


        //Creating array of windows handles. having it we can navigate to target window using array's element
        Set<String> handles = driver.getWindowHandles();
        /*Debug watching Handles
        for(String winHandle : driver.getWindowHandles()){
            System.out.println("'"+winHandle+"'"); //' is to locate possible spaces
        }*/
        /* To switch to original Window
        //get handle of original window so that we can switch to it in future
        String windHand = driver.getWindowHandle();
        switch to window
        driver.switchTo().window(windHand);
        this may not work since windHand and switchTo().Window may operate to different argument types*/

        //switching to target window using Handle. we take the Handle from the array of Handles
        driver.switchTo().window((String) handles.toArray()[1]);

        //Debug elements found on the window to make sure we are looking for the target text inside target tags
        List<WebElement> list = driver.findElements(By.xpath("//h1"));
        /*for (WebElement item: list){
            System.out.println("clss:" +item.getAttribute("class")+" text: "+item.getText());
        }*/

        //Checking condition
        Assert.assertTrue("Text not found!", list.size() > 0);
        driver.close();
        driver.quit();
    }


}
