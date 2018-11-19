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
import PageObjects.AkautingHomePage;
import PageObjects.AkautingInvoicesPage;
import PageObjects.AkautingItemsPage;
import PageObjects.AkautingLogin;
import PageObjects.AkautingMenu;
import PageObjects.AkautingVendorsPage;

/**
 *
 * @author Henrique
 */
public class TerceiroTest {

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

    
    //@Test 
    public void ItemCadastradoComSucesso() {
        AkautingHomePage homePage = new AkautingHomePage(driver);
        AkautingLogin login = new AkautingLogin(driver);

        login.setEmail("teste@teste.com").
                setSenha("utfpr").
                Logar();

        AkautingInvoicesPage invoices = homePage.getMenu().goToIncomes().goToInvoices();

        AkautingAddInvoices addInvoices = invoices.clickFindButton();

        try {
            //Caso não tenha nenhum Vendedor Cadastrado
            addInvoices.clickNewCustomer().
                    setNome("Teste").
                    setEmail("teste@teste.com").
                    setTaxNumber("1").
                    setAddress("").
                    clickSaveCustomr();
            Thread.sleep(3000);

            //Cadastro da Fatura
            addInvoices.
                    clickDayInvoice("2018-10-10").
                    clickDayDue("2018-10-20").
                    setOrderNumber("1");
            Thread.sleep(3000);
            
            addInvoices.setItemsName("Teste").
                    setQuantity("2").
                    setPrice("800").
                    setNotes("").
                    clickSppinerCategory().
                    clickDeposit().
                    clickSave();

        } catch (Exception e) {
            System.out.println("Deu erro!");
        }
        
        String produto = addInvoices.setProduto();
        String valor = addInvoices.setValor();
        
        assertEquals("Teste", produto);
        assertEquals("$400.00", valor);
        
    }

    @Test
    public void ErroNoCadastro() {

        AkautingHomePage homePage = new AkautingHomePage(driver);
        AkautingLogin login = new AkautingLogin(driver);

        login.setEmail("teste@teste.com").
                setSenha("utfpr").
                Logar();

        AkautingItemsPage items = homePage.getMenu().goToItems();

        AkautingAddItems addItems = items.clickFindButton();

        addItems.setNome("Teste").
                setSKU("1").
                setDescricao("Descricao de teste").
                setSalePrice("200").
                setPurchasePrice("400").
                setQuantidade("10").
                clickSpinnerTax().
                clickTaxButton().
                clickSpinnerCategory().
                clickGeneral().
                clickEnabled().
                clickSave();

        String mensagem = addItems.setErrorMessage();

        assertEquals("The sku has already been taken.", mensagem);
    }

}
