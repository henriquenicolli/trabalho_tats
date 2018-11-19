package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author Henrique
 */
public class AkautingBasePage {
    protected WebDriver driver;
    
    public AkautingBasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }    
}


