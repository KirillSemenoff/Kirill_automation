package pageObjects;

/**
 * Created by ksemenov on 11/13/2015.
 */

import core.ApplicationSettings;
import core.WebDriverExtension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends WebDriverExtension  {

    @FindBy(id="user_login")
    public WebElement usernameTextbox;

    @FindBy(id="user_pass")
    public WebElement passwordTextbox;

    @FindBy(id="wp-submit")
    public WebElement loginButton;

    public LoginPage (WebDriver driver) {
        super(driver);
    }

    public void Open(){
        driver.navigate().to(ApplicationSettings.basicURL);
    }

    public void ProvideUserName (){
        usernameTextbox.sendKeys(ApplicationSettings.username);
    }

    public void ProvideUserPassword (){
        passwordTextbox.sendKeys(ApplicationSettings.password);
    }

    public void ClickLogin () {
        loginButton.click();
    }

}
