/**
 * Created by ksemenov on 11/19/2015.
 */

import java.lang.String;
import core.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.PostsPage;
import pageObjects.ViewPostsPage;
import static core.WebDriverExtension.isElementContainsText;

public class Task3 extends BaseClass {

   /* @Test
    public void CreatePost (){

        newPostPage.Open();
        newPostPage.ProvidePostTitle("Kirill title");
        newPostPage.ProvidePostBody("Kirill body");
        newPostPage.ClickPublishButton();
        newPostPage.ClickViewPost();
        System.out.println(ViewPostsPage.postTitle);
        Assert.assertTrue(isElementContainsText(ViewPostsPage.postTitle, "Kirill title"));

    }*/

    /**/
    @Test
    public void RemovePost() {

        String title = "Kirill title";

        new PostsPage.AllPosts();
        PostsPage.AllPosts.Select();

        new PostsPage.SpecificTitleCheckbox();
        PostsPage.SpecificTitleCheckbox.SpecificCheck(title);

        new PostsPage.DropdownMenuActions();
        PostsPage.DropdownMenuActions.DropdownMenuSelect("trash");

        new PostsPage.ApplyButton();
        PostsPage.ApplyButton.Click();
        viewPostsPage.CheckPostPresent(title);


    }

}
