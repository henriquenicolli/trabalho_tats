package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Henrique
 */

public class AkautingLogin extends AkautingBasePage{

    @FindBy(name = "email")
    WebElement loginEmail;
    
    @FindBy(name = "password")
    WebElement loginSenha;
    
    @FindBy(xpath = "/html/body/div/div[2]/form/div[3]/div[2]/button")
    WebElement loginButton;

    public AkautingLogin(WebDriver driver) {
        super(driver);
    }
    
     public AkautingLogin setEmail(String email) {
        loginEmail.clear();
        loginEmail.sendKeys(email);
        return this;
    }
     
     public AkautingLogin setSenha(String senha) {
        loginSenha.clear();
        loginSenha.sendKeys(senha);
        return this;
    }
    
    public AkautingLogin Logar() {
        loginButton.click();
        return this;
   }

}

