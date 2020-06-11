import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

import java.util.concurrent.TimeUnit;

public class StepDefs extends TestRunner
{
    // public   static WebDriver driver;
     public   static  HomePage homepage;
     public   static CartPage cartpage;
     public   static LoginPage loginpage;
     public   static CheckoutPage checkoutpage;

        @Before
        public  static void start()
        {

          //  WebDriverManager.chromedriver().setup();
            //driver= new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
             homepage= new HomePage(driver);
             cartpage= new CartPage(driver);
            loginpage= new LoginPage(driver);
            checkoutpage= new CheckoutPage(driver);

        }
    @After
    public void stop(Scenario scenario)
    {
       //    if(scenario.isFailed())
      //    {
        byte[] screenshotBytes=((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshotBytes, "image/png");
        //  }
       // driver.quit();
    }


    @Given("I am in home page")
    public void i_am_in_home_page()
    {
      homepage.home();
    }

    @When("I add an item into the cart")
    public void i_add_an_item_into_the_cart()
    {
     homepage.addItem();
    }

    @When("I go to cart page")
    public void i_go_to_cart_page() throws InterruptedException
    {
    cartpage.pagecart();


    }

    @When("I checkout from cart")
    public void i_checkout_from_cart()
    {
     cartpage.clickTermsAndConditions();
     cartpage.clickCheckoutButton();

    }

    @When("I Login as an existing customer")
    public void i_Login_as_an_existing_customer()
    {
      loginpage.login();
      cartpage.clickTermsAndConditions();
      cartpage.clickCheckoutButton();
    }

    @When("I set billing address")
    public void i_set_billing_address()
    {
      checkoutpage.setBillingAddress();
    }

    @When("I set shipping address")
    public void i_set_shipping_address()
    {
      checkoutpage.setShippingAddress();
    }

    @When("I set shipping method")
    public void i_set_shipping_method()
    {
      checkoutpage.setShippingMethod();
    }

    @When("I set  payment method")
    public void i_set_payment_method()
    {
   checkoutpage.setPaymentMethod();

    }

    @When("I continue in payment information")
    public void i_continue_in_payment_information()
    {
      checkoutpage.continuePayment();
    }

    @When("I confirm the order")
    public void i_confirm_the_order() throws InterruptedException {
     checkoutpage.orderConfirmation();
    }

    @Then("the order confirmation screen with message is shown {string}")
    public void the_order_confirmation_screen_with_message_is_shown(String expText) throws InterruptedException {
        Thread.sleep(3000);
       String actualText= checkoutpage.message();
        Assert.assertEquals(expText,actualText);

    }


}
