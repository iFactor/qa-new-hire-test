package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ExamplePOM {

    WebDriver driver;

    By logo = By.xpath("//img[@alt='Header Logo']");

    public ExamplePOM (WebDriver driver) {
        this.driver = driver;
    }

    public void checkLogo() {
        Assert.assertEquals(driver.findElement(logo).getAttribute("src"), "https://lakelandelectric.com/Portals/_default/Skins/Lakeland/img/banner.PNG");
    }
}
