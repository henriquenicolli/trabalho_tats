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
public class AkautingItemsPage extends AkauntingPage{
    
    @FindBy(xpath = "/html/body/div/div/section[1]/h1/span[1]/a\n")
    WebElement addItemsButton;
    
    @FindBy(xpath = "//*[@id=\"tbl-items\"]/tbody/tr/td[8]/div/button")
    WebElement clickButtom;
    
    @FindBy(xpath = "//*[@id=\"item-2\"]/button")
    WebElement deleteItem;
    
    @FindBy(xpath = "//*[@id=\"confirm-modal\"]/div/div/div[3]/div/button[1]")
    WebElement confirm;
    
    @FindBy(xpath = "/html/body/div/div/section[2]/div[1]")
    WebElement mensagem;
    
    public AkautingItemsPage(WebDriver driver) {
        super(driver);
    }
    
    public AkautingAddItems clickFindButton() {
        addItemsButton.click();
        return new AkautingAddItems(driver);
    }
    
    public AkautingItemsPage clickButton() {
        clickButtom.click();
        return new AkautingItemsPage(driver);
    }
    
    public AkautingItemsPage clickDeleteButton() {
        deleteItem.click();
        return new AkautingItemsPage(driver);
    }
    
    public AkautingItemsPage clickConfirmarExclusao() {
        confirm.click();
        return new AkautingItemsPage(driver);
    }
    
    public String setMensagemAviso() {
        return mensagem.getText();
    }
    
}
