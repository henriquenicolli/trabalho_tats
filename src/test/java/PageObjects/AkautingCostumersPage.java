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
    
}
