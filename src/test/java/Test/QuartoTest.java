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
import PageObjects.AkautingHomePage;
import PageObjects.AkautingInvoicesPage;
import PageObjects.AkautingItemsPage;
import PageObjects.AkautingLogin;
import PageObjects.AkautingMenu;
import PageObjects.AkautingVendorsPage;

/**
 *
 * @author Henrique
 */
public class QuartoTest {

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
        AkautingHomePage homePage = new AkautingHomePage(driver);
        AkautingLogin login = new AkautingLogin(driver);

        login.setEmail("teste@teste.com").
                setSenha("utfpr").
                Logar();

        AkautingInvoicesPage invoice = homePage.getMenu().goToIncomes().goToInvoices();
        AkautingAddInvoices add = invoice.clickShowButton();
        String mensagem = add.setVerificarSku();

        assertEquals("SKU: 1", mensagem);

    }

    //@Test
    public void ErroNoSKU() {
        
        AkautingHomePage homePage = new AkautingHomePage(driver);
        AkautingLogin login = new AkautingLogin(driver);

        login.setEmail("teste@teste.com").
                setSenha("utfpr").
                Logar();

        AkautingInvoicesPage invoice = homePage.getMenu().goToIncomes().goToInvoices();
        AkautingAddInvoices add = invoice.clickShowButton();
        String mensagem = add.setVerificarSku();

        assertEquals("SKU: 10", mensagem);
    }

}
