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
public class AkautingTransactionPage extends AkauntingPage{
    
    @FindBy(xpath = "/html/body/div/div/section[2]/div/div[1]/form/div[1]/select[2]/option[2]")
    WebElement expense;
    
    @FindBy(xpath = "/html/body/div/div/section[2]/div/div[1]/form/div[1]/button")
    WebElement filter;
    
    public AkautingTransactionPage(WebDriver driver) {
        super(driver);
    }
    
    public AkautingTransactionPage clickExpense() {
        expense.click();
        return new AkautingTransactionPage(driver);
    }
    
    public AkautingTransactionPage clickFilter() {
        filter.click();
        return new AkautingTransactionPage(driver);
    }
}
