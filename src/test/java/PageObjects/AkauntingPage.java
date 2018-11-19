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
    
    public AkauntingPage(WebDriver driver) {
        super(driver);
        menu = new AkautingMenu(driver);
    }
     
    public AkautingMenu getMenu() {
        return menu;
    }
    
    public String getTitle() {
        return dashboard.getText();
    }  
}
