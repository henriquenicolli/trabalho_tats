package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Henrique
 */
public class AkautingAddInvoices extends AkautingBasePage{
    
    @FindBy(xpath = "//*[@id=\"button-customer\"]")
    WebElement addNewCustomer;
    
    @FindBy(xpath = "//*[@id=\"name\"]")
    WebElement name;
    
    @FindBy(xpath = "//*[@id=\"email\"]")
    WebElement email;
    
    @FindBy(xpath = "//*[@id=\"tax_number\"]")
    WebElement taxNumber;
    
    @FindBy(xpath = "//*[@id=\"address\"]")
    WebElement address;
    
    @FindBy(xpath = "//*[@id=\"button-create-customer\"]")
    WebElement saveCustomer;
        
    @FindBy(xpath = "//*[@id=\"invoiced_at\"]")
    WebElement selectDayInvoice;
    
    @FindBy(xpath = "//*[@id=\"due_at\"]")
    WebElement selectDayDue;
    
    @FindBy(xpath = "//*[@id=\"order_number\"]")
    WebElement orderNumber;
    
    @FindBy(xpath = "//*[@id=\"item-name-0\"]")
    WebElement itemsName;
    
    @FindBy(xpath = "//*[@id=\"item-quantity-0\"]")
    WebElement quantity;
    
    @FindBy(xpath = "//*[@id=\"item-price-0\"]")
    WebElement prices;
    
    @FindBy(xpath = "//*[@id=\"select2-item-tax-0-container\"]")
    WebElement sppinerTax;
    
    @FindBy(xpath = "//*[@id=\"select2-item-tax-0-container\"]")
    WebElement tax;
    
    @FindBy(xpath = "/html/body/div[1]/div/section[2]/div/form/div[1]/div[8]")
    WebElement notes;
    
    @FindBy(xpath = "//*[@id=\"select2-category_id-container\"]")
    WebElement sppinerCategory;
    
    @FindBy(xpath = "/html/body/div[1]/div/section[2]/div/form/div[1]/div[9]/div/span/span[1]/span")
    WebElement deposit;
    
    @FindBy(xpath = "/html/body/div[1]/div/section[2]/div/form/div[2]/div/div/button")
    WebElement save;
    
    public AkautingAddInvoices(WebDriver driver) {
        super(driver);
    }
    
    public AkautingAddInvoices clickNewCustomer() {
        addNewCustomer.click();
        return new AkautingAddInvoices(driver);
    }
    
    public AkautingAddInvoices setNome(String nome) {
        name.clear();
        name.sendKeys(nome);
        return this;
    }
    
    public AkautingAddInvoices setEmail(String emailp) {
        email.clear();
        email.sendKeys(emailp);
        return this;
    }
    
    public AkautingAddInvoices setTaxNumber(String tax) {
        taxNumber.clear();
        taxNumber.sendKeys(tax);
        return this;
    }
    
    public AkautingAddInvoices setAddress(String endereco) {
        address.clear();
        address.sendKeys(endereco);
        return this;
    }
    
    public AkautingAddInvoices clickSaveCustomr() {
        saveCustomer.click();
        return new AkautingAddInvoices(driver);
    }
    
    public AkautingAddInvoices clickDayInvoice(String data) {
        selectDayInvoice.clear();
        selectDayInvoice.sendKeys(data);
        return this;
    }
    
     public AkautingAddInvoices clickDayDue(String data) {
        selectDayDue.clear();
        selectDayDue.sendKeys(data);
        return this;
     }
    
    
    public AkautingHomePage setOrderNumber(String number) {
        orderNumber.clear();
        orderNumber.sendKeys(number);
        return new AkautingHomePage(driver);
    }
    
    public AkautingAddInvoices setItemsName(String nome) {
        itemsName.clear();
        itemsName.sendKeys(nome);
        return this;
    }
 
    
    public AkautingAddInvoices setQuantity(String quantidade) {
        quantity.clear();
        quantity.sendKeys(quantidade);
        return this;
    }
    
    public AkautingAddInvoices setPrice(String preco) {
        prices.sendKeys(preco);
        return this;
    }
    
     public AkautingAddInvoices clickSppinerTax() {
        sppinerTax.click();
        return new AkautingAddInvoices(driver);
    }
     
    public AkautingAddInvoices clickTax() {
        tax.click();
        return new AkautingAddInvoices(driver);
    }
    
    public AkautingAddInvoices setNotes(String notas) {
        notes.clear();
        notes.sendKeys(notas);
        return this;
    }
    
    public AkautingAddInvoices clickSppinerCategory() {
        sppinerCategory.click();
        return new AkautingAddInvoices(driver);
    }
    
    public AkautingAddInvoices clickDeposit() {
        deposit.click();
        return new AkautingAddInvoices(driver);
    }
    
    public AkautingHomePage clickSave() {
        save.click();
        return new AkautingHomePage(driver);
    }
}
