package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase{

    @BeforeMethod
    public void preconditions(){
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
        }
    }


    @Test
    public void registrationSuccess(){
        Random random = new Random();
        int i = random.nextInt(1000);
        User user = new User().setFirstName("Lisa")
                .setLastName("Snow")
                .setEmail("snowd"+i+"@mail.ru")
                .setPassword("Snow123654$");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyYX();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(),"You are logged in success");


    }

    @Test
    public void registrationEmptyName(){
        User user = new User()
                .setFirstName("")
                .setLastName("Petrova")
                .setEmail("natya21@gmail.com")
                .setPassword("Nastya12345#");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyYX();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(), "Name is required");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());

    }

    @Test
    public void registrationEmptyLastName(){
        User user = new User()
                .setFirstName("Nastya")
                .setLastName("")
                .setEmail("natya21@gmail.com")
                .setPassword("Nastya12345#");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyYX();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(), "Last name is required");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());

    }

    @Test
    public void registrationWrongEmail(){
        User user = new User()
                .setFirstName("Nastya")
                .setLastName("Petrova")
                .setEmail("natya2186mail.ru")
                .setPassword("Nastya12345#");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyYX();
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().getErrorText().contains("Wrong email format"));
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());

    }
    @Test
    public void registrationWrongPassword(){
        User user = new User()
                .setFirstName("Nastya")
                .setLastName("Petrova")
                .setEmail("liza1289@gmail.com")
                .setPassword("mastya123");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyYX();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(), "Password must contain 1 uppercase letter, 1 lowercase letter, 1 number and one special symbol of [@$#^&*!]");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());

    }

    @AfterMethod
    public void postConditions(){
        app.getHelperUser().clickOk();
    }


}
