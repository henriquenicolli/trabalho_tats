package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Henrique
 */
public class AkautingLogin extends AkautingBasePage{
    public AkautingLogin(WebDriver driver) {
        super(driver);
    }
    
    @FindBy(name = "email")
    WebElement loginEmail;
    public AkautingLogin setEmail(String email) {
        loginEmail.clear();
        loginEmail.sendKeys(email);
        return this;
    }
     
    @FindBy(name = "password")
    WebElement loginSenha;
    public AkautingLogin setSenha(String senha) {
        loginSenha.clear();
        loginSenha.sendKeys(senha);
        return this;
    }
    
    @FindBy(xpath = "/html/body/div/div[2]/form/div[3]/div[2]/button")
    WebElement loginButton;
    public AkautingHomePage Logar() {
        loginButton.click();
        return new AkautingHomePage(driver);
    }
    
    public AkautingMenu Logar1() {
        loginButton.click();
        return new AkautingMenu(driver);
   }
    
    public String getTitle(){
        return driver.getTitle();
    }
}
