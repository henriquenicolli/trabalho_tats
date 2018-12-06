package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import PageObjects.AkautingAddInvoices;
import PageObjects.AkautingAddItems;
import PageObjects.AkautingAddVendors;
import PageObjects.AkauntingPage;
import PageObjects.AkautingCategoriesPage;
import PageObjects.AkautingCostumersPage;
import PageObjects.AkautingHomePage;
import PageObjects.AkautingInvoicesPage;
import PageObjects.AkautingItemsPage;
import PageObjects.AkautingLogin;
import PageObjects.AkautingMenu;
import PageObjects.AkautingProfitLossPage;
import PageObjects.AkautingTransactionPage;
import PageObjects.AkautingVendorsPage;
import PageObjects.Setup;

/**
 *
 * @author Henrique
 */
public class OitavoTest {

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

//    @Test
//    public void VerificarFatura() {
//        AkautingHomePage homePage = new AkautingHomePage(driver);
//        AkautingLogin login = new AkautingLogin(driver);
//
//        login.setEmail("teste@teste.com").
//                setSenha("utfpr").
//                Logar();
//
//        AkautingCostumersPage costumers = homePage.getMenu().goToIncomes().goToCustomers();
//        String mensagem = costumers.clickFilter().setVerificarFatura();
//        
//        assertEquals("$2,698.00", mensagem);
//
//        
//    }

}
