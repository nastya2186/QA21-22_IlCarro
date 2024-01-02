package manager;

import models.User;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.List;

public class HelperUser extends HelperBase{
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm(){
//        WebElement loginTab = wd.findElement(By.xpath("//*[text()=' Log in ']"));
//        loginTab.click();
        click(By.xpath("//*[text()='Log in']"));

    }
    public void clickOk(){
        if(isElementPresent(By.xpath("//*[text()='Ok']")))
        click(By.xpath("//*[text()='Ok']"));
    }

public void fillLogin(String email, String password){
//        WebElement emaill = wd.findElement(By.xpath("//*[@id = 'email']"));
//        emaill.click();
//        emaill.clear();
//        emaill.sendKeys(email);
    type(By.xpath("//*[@id = 'email']"), email);


    type(By.xpath("//*[@id = 'password']"), password);

}


    public void fillLoginForm(User user){
//
        type(By.xpath("//*[@id = 'email']"), user.getEmail());
        type(By.xpath("//*[@id = 'password']"), user.getPassword());

    }


    public boolean isLogged() {
        return
                isElementPresent(By.xpath("//a[@href='/logout?url=undefined']"));
    }


    public void logout() {
        click(By.xpath("//a[@href='/logout?url=undefined']"));
    }

    public String getErrorText() {
        return wd.findElement(By.cssSelector("div.error")).getText();
    }

///=========
    public void openRegistrationForm() {
        click(By.xpath("//a[text()=' Sign up ']"));
    }

    public void fillRegistrationForm(User user) {
        type(By.id("name"), user.getFirstName());
        type(By.id("lastName"), user.getLastName());
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());

    }

    public void checkPolicy() {

        //click(By.cssSelector("label[for ='terms-of-use']"));
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('#terms-of-use').click()");


    }

    public void checkPolicyYX(){
        WebElement label = wd.findElement(By.cssSelector("label[for ='terms-of-use']"));
       Rectangle rect =  label.getRect();
       int w = rect.getWidth();
        int xOffSet= -w/2;
        Actions action = new Actions(wd);
        action.moveToElement(label,xOffSet,0).click().release().perform();

    }

    public void login(User user) {
        openLoginForm();
        fillLoginForm(user);
        submit();
        clickOk();
    }
}
