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
import PageObjects.AkautingAddVendors;
import PageObjects.AkauntingPage;
import PageObjects.AkautingHomePage;
import PageObjects.AkautingLogin;
import PageObjects.AkautingMenu;
import PageObjects.AkautingVendorsPage;

/**
 *
 * @author Henrique
 */
public class PrimeiroTest {

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
    public void CadastroComSucesso() {
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

    @Test
    public void EmailCadastrado() {

        AkautingHomePage homePage = new AkautingHomePage(driver);
        AkautingLogin login = new AkautingLogin(driver);

        login.setEmail("teste@teste.com").
                setSenha("utfpr").
                Logar();

        AkautingVendorsPage vendors = homePage.getMenu().goToExpenses().goToVendors();

        AkautingAddVendors addVendors = vendors.clickFindButton();
        addVendors.setNome("Teste").
                setEmail("teste.teste.com").
                setTax_Number("2").
                clickCurrenctButton().
                clickUsDollarButton().
                setPhone("666666666").
                setWebSite("www.teste.com").
                setAddress("").
                clickEnabledButton().
                clickSaveButton();

        String mensagem = addVendors.setErrorMessage();

        assertEquals("The email must be a valid email address.", mensagem);
    }

}
