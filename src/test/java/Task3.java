/**
 * Created by ksemenov on 11/19/2015.
 */

import java.lang.String;
import core.ApplicationSettings;
import core.BaseClass;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.PostsPage;
import pageObjects.ViewPostsPage;
import static core.WebDriverExtension.isElementContainsText;

public class Task3 extends BaseClass {
    String title= RandomStringUtils.random(5);
    String body= "Some body";
      @Test
    public void CreatePost (){

        newPostPage.Open();
        newPostPage.ProvidePostTitle(title);
        newPostPage.ProvidePostBody("Kirill body");
        newPostPage.ClickPublishButton();
        newPostPage.ClickViewPost();
        Assert.assertTrue(isElementContainsText(ViewPostsPage.postTitle, title));

    }

      @Test
    public void EditPost (){

        driver.findElement(By.xpath("//a[text()=\"Kirill_site\" and @class=\"ab-item\"]")).click();
        postsPage.SelectAllPosts();
       /* postsPage.SpecificCheck(title);
        postsPage.DropdownMenuSelect("edit");
        postsPage.ClickApply();*/
        postsPage.MoveMouseToElement(title);
        newPostPage.ProvidePostBody(body);
        newPostPage.ClickPublishButton();

    }


  @Test
    public void RemovePost() {

        postsPage.SelectAllPosts();
        postsPage.SpecificCheck(title);
        postsPage.DropdownMenuSelect("trash");
        postsPage.ClickApply();
        viewPostsPage.CheckPostPresent(title);
  }

}
