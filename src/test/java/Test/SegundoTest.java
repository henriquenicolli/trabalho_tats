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
import PageObjects.AkautingHomePage;
import PageObjects.AkautingItemsPage;
import PageObjects.AkautingLogin;
import PageObjects.AkautingMenu;
import PageObjects.AkautingVendorsPage;
import PageObjects.Setup;

/**
 *
 * @author Henrique
 */
public class SegundoTest {

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
    public void ItemCadastradoComSucesso() {
        AkautingHomePage homePage = new AkautingHomePage(driver);
        AkautingLogin login = new AkautingLogin(driver);

        login.setEmail("teste@teste.com").
                setSenha("utfpr").
                Logar();

        AkautingItemsPage items = homePage.getMenu().goToItems();

        AkautingAddItems addItems = items.clickFindButton();

        addItems.setNome("Nome do Produto").
                setSKU("001").
                setDescricao("Descricao de teste").
                setSalePrice("20,00").
                setPurchasePrice("30,00").
                setQuantidade("5").
                clickSpinnerCategory().
                clickGeneral().
                clickEnabled().
                clickSave();

        String mensagem = addItems.setMessage();

        assertEquals("Item added!", mensagem);

    }

//    @Test
//    public void ErroNoCadastro() {
//
//        AkautingHomePage homePage = new AkautingHomePage(driver);
//        AkautingLogin login = new AkautingLogin(driver);
//
//        login.setEmail("teste@teste.com").
//                setSenha("utfpr").
//                Logar();
//
//        AkautingItemsPage items = homePage.getMenu().goToItems();
//
//        AkautingAddItems addItems = items.clickFindButton();
//
//        addItems.setNome("Teste").
//                setSKU("1").
//                setDescricao("Descricao de teste").
//                setSalePrice("200").
//                setPurchasePrice("400").
//                setQuantidade("10").
//                clickSpinnerTax().
//                clickTaxButton().
//                clickSpinnerCategory().
//                clickGeneral().
//                clickEnabled().
//                clickSave();
//
//        String mensagem = addItems.setErrorMessage();
//
//        assertEquals("The sku has already been taken.", mensagem);
//    }

}
