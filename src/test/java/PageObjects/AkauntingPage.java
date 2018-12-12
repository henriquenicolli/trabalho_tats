package PageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Henrique
 */
public class AkauntingPage extends AkautingBasePage{
  
    @FindBy(tagName = "h1")
    WebElement dashboard;
    
    AkautingMenu menu;
    
    @FindBy(xpath = "/html/body/div/div/section[2]/div[1]/section/div[4]/div/table/tbody/tr[2]/td[1]/small")
    WebElement verificarSku;
    
    @FindBy(xpath = "/html/body/div/div/section[2]/div[2]/section/div[4]/div/table/tbody/tr[2]/td[1]/text()")
    WebElement produto;
    
    @FindBy(xpath = "/html/body/div/div/section[2]/div[2]/section/div[4]/div/table/tbody/tr[2]/td[4]")
    WebElement valor;
    
    public AkauntingPage(WebDriver driver) {
        super(driver);
    }
     
    public AkautingMenu getMenu() {
        return new AkautingMenu(driver);
    }
    
    public String getTitle() {
        return dashboard.getText();
    }  
    
    public String setProduto() {
        return produto.getText();
    }
    
    public String setVerificarSku() {
        return verificarSku.getText();
    }
    
    public String setValor() {
        return valor.getText();
    }
}
