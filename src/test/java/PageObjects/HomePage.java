package PageObjects;

import org.openqa.selenium.WebDriver;

/**
 *
 * @author Henrique
 */
public class HomePage extends AkauntingPage{
     public HomePage(WebDriver driver) {
        super(driver);
        driver.get("http://192.168.100.61");
    }
}
