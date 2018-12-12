package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import PageObjects.AkautingAddInvoices;
import PageObjects.AkautingAddVendors;
import PageObjects.AkautingCostumersPage;
import PageObjects.AkautingHomePage;
import PageObjects.AkautingVendorsPage;
import PageObjects.AkautingInvoicesPage;
import PageObjects.AkautingLogin;
import PageObjects.AkautingMenu;
import PageObjects.Setup;

/**
 *
 * @author Henrique
 */
public class Caso07Test {
    private WebDriver driver = new ChromeDriver();
    AkautingLogin login;
    AkautingHomePage homePage;
    AkautingMenu menu;
    AkautingCostumersPage costumers;
    AkautingVendorsPage vendors;
    AkautingInvoicesPage invoices;
    AkautingAddVendors addVendors;
    AkautingAddInvoices addInvoices;
    
    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void before() {
        driver = Setup.setup();
        login = new AkautingLogin(driver);
    }
   
    @Test 
    public void ItemCadastradoComSucesso() {
        homePage = login
            .setEmail("teste@teste.com")
            .setSenha("utfpr")
            .Logar();

        addInvoices = homePage
            .getMenu()
            .goToIncomes()
            .goToInvoices();

        try {
            homePage = addInvoices
                .clickDayInvoice("2018-10-10")
                .clickDayDue("2018-10-20")
                .setOrderNumber("1");
            
            Thread.sleep(3000);
            homePage = addInvoices
                .setItemsName("Teste")
                .setQuantity("2")
                .setPrice("800")
                .setNotes("")
                .clickSppinerCategory()
                .clickDeposit()
                .clickSave();
        } catch (Exception e) {
            System.out.println("Deu erro!");
        }
        
        assertEquals("Invoices  Add New  Import  Export  Estimates", homePage.getTitle());
    }
}
