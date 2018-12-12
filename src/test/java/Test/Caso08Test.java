package Test;

import PageObjects.AkautingHomePage;
import PageObjects.AkautingRevenuesPage;
import PageObjects.AkautingLogin;
import PageObjects.AkautingMenu;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import PageObjects.Setup;
import org.junit.Test;

/**
 *
 * @author Henrique
 */
public class Caso08Test {
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
    public void VerificarFatura() {
        menu = login
            .setEmail("teste@teste.com")
            .setSenha("utfpr")
            .Logar1();

    }
}
