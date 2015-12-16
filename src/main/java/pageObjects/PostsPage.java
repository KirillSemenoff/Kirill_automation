package pageObjects;

/**
 * Created by ksemenov on 11/17/2015.
 */

import core.WebDriverExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PostsPage extends WebDriverExtension {

    public PostsPage (WebDriver driver){
        super(driver);
    }

    protected static By posts = By.id("menu-posts");
    protected static By allposts = By.xpath("//a[text()='Все записи']");

    public static class AllPosts {

        public static void Select (){
            MoveMouseOverElement(posts); //hover mouse to  "Posts" menu
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(allposts)));
            MoveMouseOverElementAndClick(allposts);// move mouse to "All posts" menu and click
        }
            }

    public static class DropdownMenuActions {

            public static void DropdownMenuSelect (String dropdownValue){
                WebElement element = driver.findElement(By.id("bulk-action-selector-top")); //element "Actions" in "All posts"
                Select select=new Select(element);
                select.selectByValue(dropdownValue);
            }
        }

    public static class TitleCheckbox {
        public static void Check (){
            WebElement titleCheckbox = driver.findElement(By.id("cb-select-all-1"));
            titleCheckbox.click();

        }
    }

    public static class SpecificTitleCheckbox {
        public static void SpecificCheck(String title) {
            WebElement specificTitleCheckbox = driver.findElement(By.xpath("//label[text()= \"Выбрать "+ title + "\"]/following-sibling::input[@type=\"checkbox\"] "));//this long path is selecting neighbor with type=checkbox of the label="Выбрать.."
            specificTitleCheckbox.click();
        }
    }


    public static class ApplyButton {
        public static void Click () {
            WebElement apply = driver.findElement(By.id("doaction"));
            apply.click();
        }
    }

}
