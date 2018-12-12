package Test;

import PageObjects.AkautingHomePage;
import PageObjects.AkautingInvoicesPage;
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
 * @author Henrique
 */
public class Caso10Test {
    private WebDriver driver;
    AkautingLogin login;
    AkautingHomePage homePage;
    AkautingMenu menu;
    AkautingRevenuesPage revenues;
    AkautingInvoicesPage invoices;

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
    public void caseTest10() {
        menu = login
            .setEmail("teste@teste.com")
            .setSenha("utfpr")
            .Logar1();
        
        invoices = menu
            .btnIncomes()
            .btnInvoices();
        
        homePage = invoices
            .btnAdd()
            .setCustomer("Teste")
            .setCategory("Sales")
            .btnDate()
            .setDate("2018-12-31")
            .btnSave1();
        
        assertEquals("Invoices - UTFPR", homePage.getTitle());
    }
}