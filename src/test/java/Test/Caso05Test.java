package Test;

import PageObjects.AkautingCostumersPage;
import PageObjects.AkautingHomePage;
import PageObjects.AkautingLogin;
import PageObjects.AkautingMenu;
import PageObjects.Setup;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


/**
 *
 * @author Henriqeu
 */
public class Caso05Test {
    private WebDriver driver;
    AkautingLogin login;
    AkautingHomePage homePage;
    AkautingMenu menu;
    AkautingCostumersPage costumers;

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
    public void caseTest05() {
        menu = login
            .setEmail("teste@teste.com")
            .setSenha("utfpr")
            .Logar1();
        
        costumers = menu
            .btnIncomes()
            .btnCustomers();
        
        homePage = costumers
            .btnActions();
        
        assertEquals("Customers  Add New  Import  Export", homePage.getTitle());
    }
}
