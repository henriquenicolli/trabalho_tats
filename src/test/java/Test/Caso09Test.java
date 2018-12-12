package Test;

import PageObjects.AkautingHomePage;
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
public class Caso09Test {
    private WebDriver driver;
    AkautingLogin login;
    AkautingHomePage homePage;
    AkautingMenu menu;
    AkautingRevenuesPage revenues;

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
    public void caseTest09() {
        menu = login
            .setEmail("teste@teste.com")
            .setSenha("utfpr")
            .Logar1();
        
        revenues = menu
            .btnIncomes()
            .btnRevenues();
        
        homePage = revenues
            .btnAdd()
            .setCategory("Sales")
            .btnOk();
        
        assertEquals("New Revenue - UTFPR", homePage.getTitle());
    }
}