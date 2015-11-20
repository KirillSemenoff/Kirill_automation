package pageObjects;

/**
 * Created by ksemenov on 11/17/2015.
 */

import core.WebDriverExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PostsPage extends WebDriverExtension {

    public PostsPage (WebDriver driver){
        super(driver);
    }

    public static class AllPosts {

        public static void Select (){
            MoveMouseOverElement(By.id("menu-posts"));
            MoveMouseOverElementAndClick(By.xpath("//*[@href=\"edit.php\" and @class=\"wp-first-item current\"] "));
        }
            }

    public static class DropdownMenuActions {

            public static void DropdownMenuSelect (String dropdownValue){
                WebElement element = driver.findElement(By.id("bulk-action-selector-top"));
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

    public static class ApplyButton {
        public static void Click () {
            WebElement apply = driver.findElement(By.id("doaction"));
            apply.click();
        }
    }

}
