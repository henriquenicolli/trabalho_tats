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
public class AkautingAddItems extends AkautingBasePage{
    
    @FindBy(xpath = "//*[@id=\"name\"]")
    WebElement name;
    
    @FindBy(xpath = "//*[@id=\"sku\"]")
    WebElement sku;
    
    @FindBy(xpath = "//*[@id=\"description\"]")
    WebElement description;
    
    @FindBy(xpath = "//*[@id=\"sale_price\"]")
    WebElement salePrice;
    
    @FindBy(xpath = "//*[@id=\"purchase_price\"]")
    WebElement purchasePrice;
    
    @FindBy(xpath = "//*[@id=\"quantity\"]")
    WebElement quantity;
    
    @FindBy(xpath = "/html/body/div/div/section[2]/div/form/div[1]/div[7]/div/span/span[1]/span/span[2]")
    WebElement spinnerTax;
    
    @FindBy(xpath = "//*[@id=\"tax_id\"]/option[2]")
    WebElement taxButton;
    
    @FindBy(xpath = "/html/body/div/div/section[2]/div/form/div[1]/div[8]/div/span/span[1]/span/span[2]")
    WebElement spinnerCategory;
    
    @FindBy(xpath = "//*[@id=\"select2-category_id-results\"]")
    WebElement general;
    
    @FindBy(xpath = "//*[@id=\"enabled_1\"]")
    WebElement enabled;
    
    @FindBy(xpath = "/html/body/div/div/section[2]/div/form/div[2]/div/div/button")
    WebElement save;
    
    @FindBy(xpath = "/html/body/div/div/section[2]/div[1]")
    WebElement message;
    
    @FindBy(xpath = "/html/body/div/div/section[2]/div/form/div[1]/div[2]/p")
    WebElement errorMessage;
    
    public AkautingAddItems(WebDriver driver) {
        super(driver);
    }
    
     public AkautingAddItems setNome(String nome) {
        name.clear();
        name.sendKeys(nome);
        return this;
    }
     
    public AkautingAddItems setSKU(String skup) {
        sku.clear();
        sku.sendKeys(skup);
        return this;
    }
    
    public AkautingAddItems setDescricao(String descricao) {
        description.clear();
        description.sendKeys(descricao);
        return this;
    }
    
    public AkautingAddItems setSalePrice(String salPrice) {
        salePrice.clear();
        salePrice.sendKeys(salPrice);
        return this;
    }
    
    public AkautingAddItems setPurchasePrice(String purchasePricep) {
        purchasePrice.clear();
        purchasePrice.sendKeys(purchasePricep);
        return this;
    }
    
    public AkautingAddItems setQuantidade(String quantidade) {
        quantity.clear();
        quantity.sendKeys(quantidade);
        return this;
    }
    
    public AkautingAddItems clickSpinnerTax() {
        spinnerTax.click();
        return new AkautingAddItems(driver);
    }
    
    public AkautingAddItems clickTaxButton() {
        taxButton.click();
        return new AkautingAddItems(driver);
    }
    
    public AkautingAddItems clickSpinnerCategory() {
        spinnerCategory.click();
        return new AkautingAddItems(driver);
    }
    
    public AkautingAddItems clickGeneral() {
        general.click();
        return new AkautingAddItems(driver);
    }
    
    public AkautingAddItems clickEnabled() {
        enabled.click();
        return new AkautingAddItems(driver);
    }
    
    public AkautingAddItems clickSave() {
        save.click();
        return new AkautingAddItems(driver);
    }
    
    public String setMessage() {
        return message.getText();
    }
    
    public String setErrorMessage() {
        return errorMessage.getText();
    }
    
}
