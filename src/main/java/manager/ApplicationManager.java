package manager;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;
//Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    HelperUser helperUser;
    HelperCar helperCar;

    public void init(){
        wd = new ChromeDriver();
        wd.navigate().to("https://ilcarro.web.app");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        helperUser = new HelperUser(wd);
        helperCar = new HelperCar(wd);


    }

    public HelperUser getHelperUser() {
        return helperUser;
    }

    public HelperCar getHelperCar() {
        return helperCar;
    }

    public void stop(){
        //wd.quit();

    }
}
