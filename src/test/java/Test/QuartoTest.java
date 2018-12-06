package Test;

import PageObjects.AkautingCostumersPage;
import PageObjects.AkautingLogin;
import PageObjects.AkautingMenu;
import PageObjects.AkautingRevenuesPage;
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
public class QuartoTest {
    private WebDriver driver;

    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void before() {
        driver = Setup.setup();
    }

    @After
    public void after() {
        driver.close();
    }

    @Test
    public void caseTest04() {
        AkautingLogin login = new AkautingLogin(driver);
        login.setEmail("teste@teste.com").setSenha("utfpr").Logar();
        assertEquals("Dashboard - UTFPR", login.getTitle());
        
        AkautingMenu menu = new AkautingMenu(driver);
        menu.btnIncomes().btnCustomers();
        assertEquals("Customers - UTFPR", menu.getTitle());
        
        AkautingCostumersPage costumers = new AkautingCostumersPage(driver);
        costumers.btnAdd().setName("Teste").btnSave();
        assertEquals("Customers - UTFPR", costumers.getTitle());
    }
}