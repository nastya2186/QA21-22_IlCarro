package tests;

import models.User;
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
                .setEmail("snow"+i+"@mail.ru")
                .setPassword("Snow123654$");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicy();
        app.getHelperUser().submit();


    }
}
