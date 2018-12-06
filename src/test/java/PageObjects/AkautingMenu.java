package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Henrique
 */
public class AkautingMenu extends AkautingBasePage{
    
    
    @FindBy(xpath = "/html/body/div[1]/aside/div/section/ul[2]/li[2]/a")
    WebElement items;
    
    @FindBy(xpath = "/html/body/div/header/a/span[2]/b")
    WebElement akuaunting;
    
    @FindBy(xpath = "/html/body/div[1]/aside/div/section/ul[2]/li[3]/a")
    WebElement incomes;
    
    @FindBy(xpath = "/html/body/div[1]/aside/div/section/ul[2]/li[3]/ul/li[1]/a/span")
    WebElement invoices;
    
    @FindBy(xpath = "/html/body/div[1]/aside/div/section/ul[2]/li[3]/ul/li[3]/a")
    WebElement customers;
    
    @FindBy(xpath = "/html/body/div[1]/aside/div/section/ul[2]/li[4]/a/span[1]")
    WebElement expenses;
    
    @FindBy(xpath = "/html/body/div/aside/div/section/ul[2]/li[5]/a/span[1]")
    WebElement banking;
    
    @FindBy(xpath = "/html/body/div/aside/div/section/ul[2]/li[5]/ul/li[3]/a/span")
    WebElement transaction;
    
    @FindBy(xpath = "/html/body/div[1]/aside/div/section/ul[2]/li[4]/ul/li[3]/a")
    WebElement vendors;
    
    @FindBy(xpath = "/html/body/div/aside/div/section/ul[2]/li[6]/a/span[1]")
    WebElement reports;
    
    @FindBy(xpath = "/html/body/div/aside/div/section/ul[2]/li[6]/ul/li[5]/a/span")
    WebElement profitLoss;
    
    @FindBy(xpath = "/html/body/div/aside/div/section/ul[2]/li[7]/a/span[1]")
    WebElement settings;
    
    @FindBy(xpath = "/html/body/div/aside/div/section/ul[2]/li[7]/ul/li[2]/a/span")
    WebElement categories;
    
    @FindBy(xpath = "/html/body/div[1]/header/nav/div/ul/li[5]/a")
    WebElement profile;
    
    @FindBy(xpath = "/html/body/div/header/nav/div/ul/li[5]/ul/li[3]/div[1]/a")
    WebElement profileButton;
    
    public AkautingMenu(WebDriver driver) {
        super(driver);
    }
    
    public AkautingMenu goToIncomes() {
        clickMenuOption(incomes);
        return new AkautingMenu(driver);
    }
    
     public AkautingItemsPage goToItems() {
        clickMenuOption(items);
        return new AkautingItemsPage(driver);
    }
     
    public AkautingInvoicesPage goToInvoices() {
        clickMenuOption(invoices);
        return new AkautingInvoicesPage(driver);
    }
    
    public AkautingVendorsPage goToVendors() {
        clickMenuOption(vendors);
        return new AkautingVendorsPage(driver);
    }
    
    public AkautingMenu goToBanking() {
        clickMenuOption(banking);
        return new AkautingMenu(driver);
    }
    
    public AkautingTransactionPage goToTransaction() {
        clickMenuOption(transaction);
        return new AkautingTransactionPage(driver);
    }
    
    public AkautingMenu goToExpenses() {
        clickMenuOption(expenses);
        return new AkautingMenu(driver);
    }
    
    public AkautingCostumersPage goToCustomers() {
        clickMenuOption(customers);
        return new AkautingCostumersPage(driver);
    }
    
    public AkautingMenu goToReports() {
        clickMenuOption(reports);
        return new AkautingMenu(driver);
    }
    
    public AkautingProfitLossPage goToProfitLoss() {
        clickMenuOption(profitLoss);
        return new AkautingProfitLossPage(driver);
    }
    
    public AkautingMenu goToSettings() {
        clickMenuOption(settings);
        return new AkautingMenu(driver);
    }  

    public AkautingCategoriesPage goToCategories() {
        clickMenuOption(categories);
        return new AkautingCategoriesPage(driver);
    }  
    
    public AkautingMenu goToProfile() {
        clickMenuOption(profile);
        return new AkautingMenu(driver);
    }  
    
    public AkautingProfilePage goToProfileButtom() {
        clickMenuOption(profileButton);
        return new AkautingProfilePage(driver);
    }  
    
    public AkautingHomePage goToHome() {
        clickMenuOption(akuaunting);
        return new AkautingHomePage(driver);
    }    
    
    private void clickMenuOption(WebElement menuOption) {
       
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until( ExpectedConditions.elementToBeClickable(menuOption) );
        menuOption.click();
    }
    
    @FindBy(xpath = "/html/body/div[1]/aside/div/section/ul[2]/li[3]/a")
    WebElement btnIncomes;
    public AkautingMenu btnIncomes() {
        btnIncomes.click();
        return new AkautingMenu(driver);
    }  
    
    @FindBy(xpath = "/html/body/div[1]/aside/div/section/ul[2]/li[3]/ul/li[2]/a/span")
    WebElement btnRevenues;
    public AkautingMenu btnRevenues() {
        btnRevenues.click();
        return new AkautingMenu(driver);
    }  
    
    public String getTitle(){
        return driver.getTitle();
    }
}
