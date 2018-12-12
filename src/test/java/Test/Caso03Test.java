package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import PageObjects.AkautingHomePage;
import PageObjects.AkautingItemsPage;
import PageObjects.AkautingLogin;
import PageObjects.Setup;

/**
 *
 * @author Henrique
 */
public class Caso03Test {
    private WebDriver driver;
    AkautingLogin login;
    AkautingHomePage homePage;
    AkautingItemsPage Item;

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
    public void DeletarItem() {
        homePage = login
            .setEmail("teste@teste.com")
            .setSenha("utfpr")
            .Logar();

        Item = homePage
            .getMenu()
            .goToIncomes()
            .goToItems();

        try {
            Item
                .clickButton()
                .clickDeleteButton();
            Thread.sleep(3000);
            
            homePage = Item
                .clickConfirmarExclusao();
        } catch (Exception e) {}

        assertEquals("Search:\n" +
            "All Categories\n" +
            "General\n" +
            " Filter\n" +
            "Show:\n" +
            "10\n" +
            "25\n" +
            "50\n" +
            "100\n" +
            "Picture Name  Category  Quantity  Sale Price  Purchase Price  Status  Actions\n" +
            "Nome do Produto General 5 $20.00 $30.00 Enabled\n" +
            "Edit\n" +
            "Disable\n" +
            "Duplicate\n" +
            "Delete\n" +
            "Showing 1 to 1 of 1 items\n" +
            "«\n" +
            "1\n" +
            "»", 
            Item.setMensagemAviso()
        );
    }
}
