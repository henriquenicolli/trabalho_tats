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
import PageObjects.AkautingAddItems;
import PageObjects.AkautingAddVendors;
import PageObjects.AkauntingPage;
import PageObjects.AkautingAddInvoices;
import PageObjects.AkautingCategoriesPage;
import PageObjects.AkautingHomePage;
import PageObjects.AkautingInvoicesPage;
import PageObjects.AkautingItemsPage;
import PageObjects.AkautingLogin;
import PageObjects.AkautingMenu;
import PageObjects.AkautingProfitLossPage;
import PageObjects.AkautingVendorsPage;

/**
 *
 * @author Henrique
 */
public class SextoTest {

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
    public void CadastraVendedor() {
        AkautingHomePage homePage = new AkautingHomePage(driver);
        AkautingLogin login = new AkautingLogin(driver);

        login.setEmail("teste@teste.com").
                setSenha("utfpr").
                Logar();

        AkautingVendorsPage vendors = homePage.getMenu().goToExpenses().goToVendors();

        AkautingAddVendors addVendors = vendors.clickFindButton();
        addVendors.setNome("Teste").
                setEmail("teste@teste.com").
                setTax_Number("1").
                clickCurrenctButton().
                clickUsDollarButton().
                setPhone("66666666").
                setWebSite("www.teste.com").
                setAddress("").
                clickEnabledButton().
                clickSaveButton();

        String mensagem = addVendors.setMessage();

        assertEquals("Vendor added!", mensagem);
    }
    
//    @Test
//    public void Lucro() {
//        AkautingHomePage homePage = new AkautingHomePage(driver);
//        AkautingLogin login = new AkautingLogin(driver);
//
//        login.setEmail("teste@teste.com").
//                setSenha("utfpr").
//                Logar();
//
//        AkautingProfitLossPage prof = homePage.getMenu().goToReports().goToProfitLoss();
//        prof.clickAno().clickSelecionarAno();
//
//        String mensagem = prof.setLucro();
//
//        assertEquals("$0.00", mensagem);
//
//    }

}
