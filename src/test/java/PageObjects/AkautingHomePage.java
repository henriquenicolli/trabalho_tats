package PageObjects;

import org.openqa.selenium.WebDriver;

/**
 *
 * @author Henrique
 */
public class AkautingHomePage extends AkauntingPage{
     public AkautingHomePage(WebDriver driver) {
        super(driver);
        driver.get("http://10.0.0.111/");
    }
}
