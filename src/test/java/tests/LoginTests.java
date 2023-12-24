package tests;

import models.User;
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
    public void loginSuccess1(){
        User
//        User user = new User();
//        user.setEmail("kim19@gmail.com");
//        user.setPassword("Kim192023#");

        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLogin("kim19@gmail.com", "Kim192023#");
        app.getHelperUser().submitLogin();
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");

        //app.getHelperUser().clickOk();



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

    @Test
    public void loginWrongEmail(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLogin("kim19gmail.com", "Kim192023#");
        app.getHelperUser().submitLogin();
        Assert.assertEquals(app.getHelperUser().getErrorText(), "It'snot look like email");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());

    }

    @Test
    public void loginWrongPassword(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLogin("kim19@gmail.com", "Kim192023");
        app.getHelperUser().submitLogin();
        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");

    }

    @Test
    public void loginWrongUnregisteredUser(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLogin("kim@gmail.com", "Kim192023#");
        app.getHelperUser().submitLogin();
        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");

    }



}
