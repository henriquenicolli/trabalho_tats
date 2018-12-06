/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Henrique
 */
public class AkautingCostumersPage extends AkauntingPage{
    
    @FindBy(xpath = "//*[@id=\"tbl-customers\"]/tbody/tr/td[1]/a")
    WebElement bruno;
    
    @FindBy(xpath = "/html/body/div/div/section[2]/div/div[2]/div[1]/div[3]/div/div/span[2]")
    WebElement fatura;
    
    public AkautingCostumersPage(WebDriver driver) {
        super(driver);
    }
    
    public AkautingCostumersPage clickFilter() {
        bruno.click();
        return new AkautingCostumersPage(driver);
    }
    
    public String setVerificarFatura() {
        return fatura.getText();
    }
    
    @FindBy(xpath = "//*[@id=\"name\"]")
    WebElement name;
    public AkautingCostumersPage setName(String value) {
        name.sendKeys(value); 
        return this;
    }
    
    @FindBy(xpath = "/html/body/div/div/section[1]/h1/span[1]/a")
    WebElement btnAdd;
    public AkautingCostumersPage btnAdd() {
        btnAdd.click();
        return new AkautingCostumersPage(driver);
    }
    
    @FindBy(xpath = "/html/body/div/div/section[2]/div/form/div[2]/div/div/button")
    WebElement btnSave;
    public AkautingCostumersPage btnSave() {
        btnSave.click();
        return new AkautingCostumersPage(driver);
    }
    
    @FindBy(xpath = "//*[@id=\"tbl-customers\"]/tbody/tr[1]/td[5]/div/button")
    WebElement btnActions;
    public AkautingCostumersPage btnActions() {
        btnActions.click();
        return new AkautingCostumersPage(driver);
    }
    
    @FindBy(xpath = "//*[@id=\"customer-2\"]/button")
    WebElement btnDelete;
    public AkautingCostumersPage btnDelete() {
        btnDelete.click();
        return new AkautingCostumersPage(driver);
    }
    
    @FindBy(xpath = "//*[@id=\"confirm-modal\"]/div/div/div[3]/div/button[1]")
    WebElement btnDeleteConfirm;
    public AkautingCostumersPage btnDeleteConfirm() {
        btnDeleteConfirm.click();
        return new AkautingCostumersPage(driver);
    }
    
    public String getTitle(){
        return driver.getTitle();
    }
}
