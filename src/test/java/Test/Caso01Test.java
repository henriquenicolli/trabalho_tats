package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import PageObjects.AkautingHomePage;
import PageObjects.AkautingLogin;
import PageObjects.Setup;

/**
 *
 * @author Henrique
 */
public class Caso01Test {
    private WebDriver driver;
    AkautingLogin login;
    AkautingHomePage homePage;
    
    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void before() {
        driver = Setup.setup();
        login = new AkautingLogin(driver);
    }

    @After
    public void after() {
        driver.close();
    }
    
    @Test
    public void Login(){
        homePage = login
            .setEmail("teste@teste.com")
            .setSenha("utfpr")
            .Logar();
        
        
        assertEquals("Dashboard", homePage.getTitle());
    }
}
