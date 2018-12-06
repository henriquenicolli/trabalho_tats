package Test;

import PageObjects.AkautingInvoicesPage;
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
 * @author Henrique
 */
public class DecimoTest {
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
    public void caseTest10() {
        AkautingLogin login = new AkautingLogin(driver);
        login.setEmail("teste@teste.com").setSenha("utfpr").Logar();
        assertEquals("Dashboard - UTFPR", login.getTitle());
        
        AkautingMenu menu = new AkautingMenu(driver);
        menu.btnIncomes().btnInvoices();
        assertEquals("Invoices - UTFPR", menu.getTitle());
        
        AkautingInvoicesPage invoices = new AkautingInvoicesPage(driver);
        invoices.btnAdd().setCustomer("Teste").setCategory("Sales").btnDate().setDate("2018-12-31").btnSave();
        assertEquals("Invoices - UTFPR", invoices.getTitle());
    }
}