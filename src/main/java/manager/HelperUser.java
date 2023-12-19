package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
        click(By.xpath("//*[text()='Ok']"));
    }

public void fillLogin(String email, String passport){
//        WebElement emaill = wd.findElement(By.xpath("//*[@id = 'email']"));
//        emaill.click();
//        emaill.clear();
//        emaill.sendKeys(email);
    type(By.xpath("//*[@id = 'email']"), email);


    type(By.xpath("//*[@id = 'password']"), passport);

}
public void submitLogin(){
        click(By.cssSelector("button[type='submit']"));
}



}
