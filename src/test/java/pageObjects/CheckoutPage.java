package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage
{
    WebDriver driver;

    public  CheckoutPage(WebDriver driver)
    {   this.driver=driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(id ="ShipToSameAddress" )
    public WebElement shipToSameAddressButton;
    @FindBy(xpath ="//input[@onclick='Billing.save()']" )
    public WebElement billingContinueButton;

    @FindBy(id="shipping-address-select")
    public WebElement selectShippingAddressButton;

    @FindBy(id="ShippingNewAddress_CountryId")
    public WebElement  shipCountrySelect;
    @FindBy(id="ShippingNewAddress_City")
    public WebElement cityTextBox;
    @FindBy(id="ShippingNewAddress_Address1")
    public  WebElement address1TextBox;
    @FindBy(id="ShippingNewAddress_ZipPostalCode")
    public  WebElement zipcodeTextBox;
    @FindBy(id="ShippingNewAddress_PhoneNumber")
    public  WebElement phoneNumberTextBox;
    @FindBy(xpath ="//input[@onclick='Shipping.save()']")
    public WebElement shippingAddressContinueButton;

    @FindBy(id="shippingoption_1")
    public WebElement nextDayAirShippingButton;

    @FindBy(xpath ="//input[@onclick='ShippingMethod.save()']")
    public WebElement shippingMethodContinueButton;

    @FindBy(id="paymentmethod_1")
    public WebElement creditCardRadioButton;
    @FindBy(xpath ="//input[@onclick='PaymentMethod.save()']")
    public WebElement paymentMethodContinueButton;

    @FindBy(id="CardholderName")
    public WebElement cardholderNameTextBox;
    @FindBy(id="CardNumber")
    public WebElement cardNumberTextBox;
    @FindBy(id="ExpireMonth")
    public WebElement cardExpiryMonth;
    @FindBy(id="ExpireYear")
    public WebElement cardExpireYear;
    @FindBy(id="CardCode")
    public WebElement cardCode;
    @FindBy(xpath ="//input[@onclick='PaymentInfo.save()']")
    public WebElement paymentInfoContinueButton;

    @FindBy(xpath ="//input[@onclick='ConfirmOrder.save()']")
    public WebElement confirmOrderButton;

    @FindBy(xpath = "//div[@class='title']/strong")
    public WebElement confirmationMessage;



    public void setBillingAddress()
    {
        shipToSameAddressButton.click();
        billingContinueButton.click();
    }

    public void setShippingAddress()
    {
        Select ship=new Select(selectShippingAddressButton);
        ship.selectByVisibleText("New Address");
        Select shipC=new Select(shipCountrySelect);
        shipC.selectByVisibleText("United Kingdom");
        cityTextBox.sendKeys("London");
        address1TextBox.sendKeys("43 Cranford");
        zipcodeTextBox.sendKeys("tw5 6hg");
        phoneNumberTextBox.sendKeys("07812345654");
        shippingAddressContinueButton.click();

    }

    public void setShippingMethod()
    {
     nextDayAirShippingButton.click();
     shippingMethodContinueButton.click();
    }

    public void setPaymentMethod()
    {
     creditCardRadioButton.click();
     paymentMethodContinueButton.click();
    }

    public void continuePayment()
    {
        cardholderNameTextBox.sendKeys("Martin");
        cardNumberTextBox.sendKeys("4111111111111111");
        Select M= new Select(cardExpiryMonth);
        M.selectByValue("3");
        Select Y= new Select(cardExpireYear);
        Y.selectByValue("2023");
        cardCode.sendKeys("111");
        paymentInfoContinueButton.click();
    }

    public void orderConfirmation() throws InterruptedException {
        Thread.sleep(2000);
        confirmOrderButton.click();
    }


     public  String message()
     {
        return confirmationMessage.getText();

     }
}
