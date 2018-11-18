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
import PageObjects.AddInvoices;
import PageObjects.AddItems;
import PageObjects.AddVendors;
import PageObjects.AkauntingPage;
import PageObjects.HomePage;
import PageObjects.InvoicesPage;
import PageObjects.ItemsPage;
import PageObjects.Login;
import PageObjects.Menu;
import PageObjects.VendorsPage;

/**
 *
 * @author Usuario
 */
public class TerceiroCaseTest {

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

    // Este caso de Teste não Funciona! Ele trava ao preencher o campo "Prices"
    //@Test 
    public void ItemCadastradoComSucesso() {
        HomePage homePage = new HomePage(driver);
        Login login = new Login(driver);

        login.setEmail("teste@teste.com").
                setSenha("utfpr").
                Logar();

        InvoicesPage invoices = homePage.getMenu().goToIncomes().goToInvoices();

        AddInvoices addInvoices = invoices.clickFindButton();

        try {
            //Caso não tenha nenhum Vendedor Cadastrado
            addInvoices.clickNewCustomer().
                    setNome("Bruno").
                    setEmail("bruno_daguano@hotmail.com").
                    setTaxNumber("1").
                    setAddress("").
                    clickSaveCustomr();
            Thread.sleep(3000);

            //Cadastro da Fatura
            addInvoices.
                    clickDayInvoice("2018-10-20").
                    clickDayDue("2018-10-30").
                    setOrderNumber("1");
            Thread.sleep(3000);
            
            addInvoices.setItemsName("Moto G5s Plus (1)").
                    setQuantity("2").
                    setPrice("1349").
                    setNotes("").
                    clickSppinerCategory().
                    clickDeposit().
                    clickSave();

        } catch (Exception e) {
            System.out.println("Deu erro!");
        }
        
        String produto = addInvoices.setProduto();
        String valor = addInvoices.setValor();
        
        assertEquals("Moto G5s Plus", produto);
        assertEquals("$1,349.00", valor);
        
    }

    @Test
    public void ErroNoCadastro() {

        HomePage homePage = new HomePage(driver);
        Login login = new Login(driver);

        login.setEmail("teste@teste.com").
                setSenha("utfpr").
                Logar();

        ItemsPage items = homePage.getMenu().goToItems();

        AddItems addItems = items.clickFindButton();

        addItems.setNome("Moto G5s Plus").
                setSKU("1").
                setDescricao("Smartphone\n Motorola Moto G5s Plus 32GB - Platinum Dual Chip\n"
                        + "4G Câm. Duo 13MP + 13MP").
                setSalePrice("1349").
                setPurchasePrice("1200").
                setQuantidade("50").
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
