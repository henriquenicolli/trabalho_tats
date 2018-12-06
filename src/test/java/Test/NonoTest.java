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
import PageObjects.AkautingCategoriesPage;
import PageObjects.AkautingCostumersPage;
import PageObjects.AkautingHomePage;
import PageObjects.AkautingInvoicesPage;
import PageObjects.AkautingItemsPage;
import PageObjects.AkautingLogin;
import PageObjects.AkautingMenu;
import PageObjects.AkautingProfitLossPage;
import PageObjects.AkautingTransactionPage;
import PageObjects.AkautingVendorsPage;

/**
 *
 * @author Henrique
 */
public class NonoTest {

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

    
    
//    @Test
//    public void DeletarItem() {
//        AkautingHomePage homePage = new AkautingHomePage(driver);
//        AkautingLogin login = new AkautingLogin(driver);
//
//        login.setEmail("teste@teste.com").
//                setSenha("utfpr").
//                Logar();
//
//        AkautingItemsPage Item = homePage.getMenu().goToIncomes().goToItems();
//
//        try {
//            Item.clickButton().clickDeleteButton();
//            Thread.sleep(3000);
//            Item.clickConfirmarExclusao();
//        } catch (Exception e) {
//            System.out.println("Deu erro!");
//        }
//
//        String mensagem = Item.setMensagemAviso();
//        assertEquals("Warning: You are not allowed to delete Moto G5s Plus because it has 1 invoice related.",
//                mensagem);
//    }
}
