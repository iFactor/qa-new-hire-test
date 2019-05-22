package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class ExamplePageFactory {
  WebDriver driver;

  @FindBy(xpath = "//img[@alt='Header Logo']")
  WebElement logo;

  public ExamplePageFactory(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void checkLogo() {
    Assert.assertEquals(logo.getAttribute("src"), "https://lakelandelectric.com/Portals/_default/Skins/Lakeland/img/banner.PNG");
  }


}
