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
public class AkautingProfilePage extends AkauntingPage{
    
    @FindBy(id = "name")
    WebElement name;
    
    @FindBy(id = "password")
    WebElement password;
    
    @FindBy(id = "password_confirmation")
    WebElement password_confirmation;
    
    @FindBy(xpath = "/html/body/div/div/section[2]/div/form/div[1]/div[5]/div/span/span[1]/span/span[2]")
    WebElement verIdiomas;
    
    @FindBy( xpath = "//*[@id=\"locale\"]/option[20]")
    WebElement idioma;
    
    @FindBy( xpath = "//*[@id=\"locale\"]/option[2]")
    WebElement idioma2;
    
    @FindBy(xpath = "/html/body/div/div/section[2]/div/form/div[2]/div/div/button")
    WebElement save;
    
    @FindBy(xpath = "/html/body/div/div/section[2]/div[1]")
    WebElement mensagem;
    
    public AkautingProfilePage(WebDriver driver) {
        super(driver);
    }
    
    public AkautingProfilePage setNome(String nome) {
        name.clear();
        name.sendKeys(nome);
        return this;
    }
    
    public AkautingProfilePage setSenha(String senha) {
        password.clear();
        password.sendKeys(senha);
        return this;
    }
    
    public AkautingProfilePage setConfirmarSenha(String conf_senha) {
        password_confirmation.clear();
        password_confirmation.sendKeys(conf_senha);
        return this;
    }
    
    public AkautingProfilePage clickVerIdioma() {
        verIdiomas.click();
        return new AkautingProfilePage(driver);
    }
    
    public AkautingProfilePage clickIdioma() {
        idioma.click();
        return new AkautingProfilePage(driver);
    }
    
    public AkautingProfilePage clickIdioma2() {
        idioma2.click();
        return new AkautingProfilePage(driver);
    }
   
    public AkautingProfilePage clickSave() {
        save.click();
        return new AkautingProfilePage(driver);
    }
    
    public String setMensagem() {
        return mensagem.getText();
    }
     
}
