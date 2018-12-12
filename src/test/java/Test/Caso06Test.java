package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import PageObjects.AkautingAddVendors;
import PageObjects.AkautingCostumersPage;
import PageObjects.AkautingHomePage;
import PageObjects.AkautingLogin;
import PageObjects.AkautingMenu;
import PageObjects.AkautingVendorsPage;
import PageObjects.Setup;

/**
 *
 * @author Henrique
 */
public class Caso06Test {
    private WebDriver driver;
    AkautingLogin login;
    AkautingHomePage homePage;
    AkautingMenu menu;
    AkautingCostumersPage costumers;
    AkautingVendorsPage vendors;
    AkautingAddVendors addVendors;

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
    public void CadastraVendedor() {
        homePage = login
            .setEmail("teste@teste.com")
            .setSenha("utfpr")
            .Logar();

        vendors = homePage
            .getMenu()
            .goToExpenses()
            .goToVendors();

        addVendors = vendors
            .clickFindButton();
        
        homePage = addVendors
            .setNome("Teste")
            .setEmail("teste@teste.com")
            .setTax_Number("1")
            .clickCurrenctButton()
            .clickUsDollarButton()
            .setPhone("66666666")
            .setWebSite("www.teste.com")
            .setAddress("")
            .clickEnabledButton()
            .clickSaveButton();

        assertEquals("Vendor added!", addVendors.setMessage());
    }
}
