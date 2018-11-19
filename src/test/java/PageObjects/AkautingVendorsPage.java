package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Henrique
 */
public class AkautingVendorsPage extends AkauntingPage{
    
    @FindBy(xpath = "/html/body/div/div/section[1]/h1/span[1]/a")
    WebElement addVendorsButton;
    
    public AkautingVendorsPage(WebDriver driver) {
        super(driver);
    }
    
    public AkautingAddVendors clickFindButton() {
        addVendorsButton.click();
        return new AkautingAddVendors(driver);
    }
}
