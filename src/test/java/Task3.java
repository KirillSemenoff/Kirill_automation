/**
 * Created by ksemenov on 11/19/2015.
 */


import core.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ViewPostsPage;
import static core.WebDriverExtension.isElementContainsText;

public class Task3 extends BaseClass {

    @Test
    public void CreatePost (){

        newPostPage.Open();
        newPostPage.ProvidePostTitle("Kirill title");
        newPostPage.ProvidePostBody("Kirill body");
        newPostPage.ClickPublishButton();
        newPostPage.ClickViewPost();
        Assert.assertTrue(isElementContainsText(ViewPostsPage.postTitle, "Kirill title"));

    }

}
