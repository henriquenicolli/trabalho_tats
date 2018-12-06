package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author Henrique
 */
public class AkautingRevenuesPage extends AkautingBasePage {
    public AkautingRevenuesPage (WebDriver driver){
        super (driver);
    }
    
    @FindBy(xpath = "//*[@id=\"amount\"]")
    WebElement amount;
    public AkautingRevenuesPage setAmount(String value) {
        amount.sendKeys(value);
        return this;
    }
    
    @FindBy(xpath = "/html/body/div/div/section[2]/div/form/div[1]/div[6]/div/span/span[1]/span")
    WebElement category;
    public AkautingRevenuesPage setCategory(String name) {
        category.sendKeys(name); 
        return this;
    }
    
    @FindBy(xpath = "//*[@id=\"select2-payment_method-container\"]")
    WebElement paymentMethod;
    public AkautingRevenuesPage setPaymentMethod(String name) {
        paymentMethod.sendKeys(name); 
        return this;
    }
    
    @FindBy(xpath = "/html/body/div/div/section[1]/h1/span[1]/a")
    WebElement btnAdd;
    public AkautingRevenuesPage btnAdd() {
        btnAdd.click();
        return new AkautingRevenuesPage(driver);
    }
    
    @FindBy(xpath = "/html/body/div/div/section[2]/div/form/div[2]/div/div/button")
    WebElement btnOk;
    public AkautingRevenuesPage btnOk() {
        btnOk.click();
        return new AkautingRevenuesPage(driver);
    }
    
    @FindBy(xpath = "//*[@id=\"tbl-revenues\"]/tbody/tr/td[6]/div/button")
    WebElement btnActions;
    public AkautingRevenuesPage btnActions() {
        btnActions.click();
        return new AkautingRevenuesPage(driver);
    }
    
    @FindBy(xpath = "//*[@id=\"revenue-3\"]/button")
    WebElement btnDelete;
    public AkautingRevenuesPage btnDelete() {
        btnDelete.click();
        return new AkautingRevenuesPage(driver);
    }
    
    @FindBy(xpath = "//*[@id=\"confirm-modal\"]/div/div/div[3]/div/button[1]")
    WebElement btnDeleteConfirm;
    public AkautingRevenuesPage btnDeleteConfirm() {
        btnDeleteConfirm.click();
        return new AkautingRevenuesPage(driver);
    }
    
    public String getTitle(){
        return driver.getTitle();
    }
}
