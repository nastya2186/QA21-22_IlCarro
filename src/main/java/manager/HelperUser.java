package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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


    public void fillLogin(User user){
//
        type(By.xpath("//*[@id = 'email']"), user.);
        type(By.xpath("//*[@id = 'password']"), password);

    }
public void submitLogin(){
        click(By.cssSelector("button[type='submit']"));
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


}
