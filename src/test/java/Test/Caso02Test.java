package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import PageObjects.AkautingAddItems;
import PageObjects.AkautingHomePage;
import PageObjects.AkautingItemsPage;
import PageObjects.AkautingLogin;
import PageObjects.Setup;

/**
 *
 * @author Henrique
 */
public class Caso02Test {
    private WebDriver driver;
    AkautingLogin login;
    AkautingHomePage homePage;
    AkautingItemsPage items;
    AkautingAddItems addItems;
    
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
    public void ItemCadastradoComSucesso() {
        homePage = login
            .setEmail("teste@teste.com")
            .setSenha("utfpr")
            .Logar();

        items = homePage
            .getMenu()
            .goToItems();

        addItems = items
            .clickFindButton();

        homePage = addItems
            .setNome("Nome do Produto")
            .setSKU("001")
            .setDescricao("Descricao de teste")
            .setSalePrice("20,00")
            .setPurchasePrice("30,00")
            .setQuantidade("5")
            .clickSpinnerCategory()
            .clickGeneral()
            .clickEnabled()
            .clickSave();

        assertEquals("Item added!", addItems.setMessage());
    }
}
