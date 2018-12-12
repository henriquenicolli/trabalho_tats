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
    
    @FindBy(xpath = "//*[@id=\"select2-customer_id-container\"]/span")
    WebElement customer;
        public AkautingInvoicesPage setCustomer(String value) {
        customer.sendKeys(value); 
        return this;
    }
        
    @FindBy(xpath = "//*[@id=\"due_at\"]")
    WebElement date;
    public AkautingInvoicesPage setDate(String value) {
        date.sendKeys(value); 
        return this;
    }
        
    @FindBy(xpath = "//*[@id=\"select2-category_id-container\"]")
    WebElement category;
    public AkautingInvoicesPage setCategory(String value) {
        category.sendKeys(value); 
        return this;
    }
    
    @FindBy(xpath = "//*[@id=\"due_at\"]")
    WebElement btnDate;
    public AkautingInvoicesPage btnDate() {
        date.click(); 
        return new AkautingInvoicesPage(driver);
    }
    
    @FindBy(xpath = "/html/body/div/div/section[1]/h1/span[1]/a")
    WebElement btnAdd;
    public AkautingInvoicesPage btnAdd() {
        btnAdd.click();
        return this;
    }
    
    @FindBy(xpath = "/html/body/div/div/section[2]/div/form/div[2]/div/div/button")
    WebElement btnSave;
    public AkautingInvoicesPage btnSave() {
        btnSave.click();
        return new AkautingInvoicesPage(driver);
    }
    
    public AkautingHomePage btnSave1() {
        btnSave.click();
        return new AkautingHomePage(driver);
    }
    
    @FindBy(xpath = "//*[@id=\"tbl-customers\"]/tbody/tr[1]/td[5]/div/button")
    WebElement btnActions;
    public AkautingInvoicesPage btnActions() {
        btnActions.click();
        return new AkautingInvoicesPage(driver);
    }
    
    @FindBy(xpath = "//*[@id=\"customer-1\"]/button")
    WebElement btnDelete;
    public AkautingInvoicesPage btnDelete() {
        btnDelete.click();
        return new AkautingInvoicesPage(driver);
    }
    
    @FindBy(xpath = "//*[@id=\"confirm-modal\"]/div/div/div[3]/div/button[1]")
    WebElement btnDeleteConfirm;
    public AkautingInvoicesPage btnDeleteConfirm() {
        btnDeleteConfirm.click();
        return new AkautingInvoicesPage(driver);
    }
    
    public String getTitle(){
        return driver.getTitle();
    }
}
