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
import PageObjects.AddInvoices;
import PageObjects.AddItems;
import PageObjects.AddVendors;
import PageObjects.AkauntingPage;
import PageObjects.CategoriesPage;
import PageObjects.CostumersPage;
import PageObjects.HomePage;
import PageObjects.InvoicesPage;
import PageObjects.ItemsPage;
import PageObjects.Login;
import PageObjects.Menu;
import PageObjects.ProfitLossPage;
import PageObjects.TransactionPage;
import PageObjects.VendorsPage;

/**
 *
 * @author Usuario
 */
public class OitavoCaseTest {

    private WebDriver driver = new ChromeDriver();

    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();

    }

    @Before
    public void before() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("headless");
        chromeOptions.addArguments("window-size=1200x600");
        chromeOptions.addArguments("lang=en-US");
        chromeOptions.addArguments("start-maximized");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void VerificarFatura() {
        HomePage homePage = new HomePage(driver);
        Login login = new Login(driver);

        login.setEmail("teste@teste.com").
                setSenha("utfpr").
                Logar();

        CostumersPage costumers = homePage.getMenu().goToIncomes().goToCustomers();
        String mensagem = costumers.clickFilter().setVerificarFatura();
        
        assertEquals("$2,698.00", mensagem);

        
    }

}
