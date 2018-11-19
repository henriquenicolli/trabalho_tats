package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Henrique
 */
public class AkautingInvoicesPage extends AkauntingPage{
    
    @FindBy(xpath = "/html/body/div/div/section[1]/h1/span[1]/a")
    WebElement addInvoicesButton;
    
    @FindBy(xpath = "//*[@id=\"tbl-invoices\"]/tbody/tr/td[1]/a")
    WebElement showButton;
   
    
    public AkautingInvoicesPage(WebDriver driver) {
        super(driver);
    }
    
    public AkautingAddInvoices clickFindButton() {
        addInvoicesButton.click();
        return new AkautingAddInvoices(driver);
    }
    
    public AkautingAddInvoices clickShowButton() {
        showButton.click();
        return new AkautingAddInvoices(driver);
    }
}
