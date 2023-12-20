package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {


    @BeforeMethod
    public void preconditions(){
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
        }
    }


    @AfterMethod
    public void postConditions(){
        app.getHelperUser().clickOk();
    }

    @Test
    public void loginSuccess(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLogin("kim19@gmail.com", "Kim192023#");
        app.getHelperUser().submitLogin();
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");

        //app.getHelperUser().clickOk();



    }


    @Test
    public void loginSuccessModel(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLogin("kim19@gmail.com", "Kim192023#");
        app.getHelperUser().submitLogin();
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");

       // app.getHelperUser().clickOk();



    }



}
