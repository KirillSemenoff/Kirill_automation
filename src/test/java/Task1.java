/**
 * Created by ksemenov on 11/10/2015.
 */


//import org.junit.Test;
import org.apache.http.util.Args;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Task1 {

    protected static WebDriver driver;



    public void  method1() {

        driver=new FirefoxDriver();

        driver.navigate().to("http://localhost:43198/wp-login.php");
        driver.findElement(By.id("user_login")).clear();
        driver.findElement(By.id("user_login")).sendKeys("Kirill");
        driver.findElement(By.id("user_pass")).clear();
        driver.findElement(By.id("user_pass")).sendKeys("3B*nPyIvTTKdlNb2Zm");
        driver.findElement(By.className("submit")).click();

        driver.close();
        driver.quit();
    }
}
