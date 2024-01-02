package manager;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HelperCar extends HelperBase{
    public HelperCar(WebDriver wd) {
        super(wd);
    }

    public void openCarForm() {
        pause(500);

        click(By.xpath("//a[text()=' Let the car work ']"));
    }

    public void fillCarForm(Car car) {
        typeLocation(car.getLocation());
        type(By.id("make"), car.getManufacture());
        type(By.cssSelector("#model"),car.getModel());
        type(By.cssSelector("#year"), car.getYear());
        select(By.id("fuel"),car.getFuel());
        type(By.id("seats"),String.valueOf(car.getSeats()));
        type(By.cssSelector("#class"),car.getCarClass());
        type(By.cssSelector("#serialNumber"),car.getCarRegNumber());
        type(By.cssSelector("#price"),car.getPrice()+"");
        type(By.cssSelector("#about"),car.getAbout());

    }

    private void select(By locator, String options) {
        Select select = new Select(wd.findElement(locator));
//        select.selectByVisibleText(" Gas ");
//        select.selectByIndex(5);
//        select.selectByValue("Gas");
        select.selectByValue(options);
    }

    private void typeLocation(String location) {
        type(By.id("pickUpPlace"),location);
        click(By.cssSelector("div.pac-item"));

    }


}
