package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
    WebDriver driver;

    public  LoginPage(WebDriver driver)
    {    this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy(id ="Email" )
    public WebElement EmailTextBox;
    @FindBy(id ="Password" )
    public WebElement PasswordTextBox;
    @FindBy(xpath ="//input[@value='Log in']")
     public WebElement loginButton;

    @FindBy(id ="termsofservice")
    public WebElement termsButton;

    @FindBy(id ="checkout")
    public WebElement checkoutButton;



        public void login()
        {
            EmailTextBox.sendKeys("user3@testing.com");
            PasswordTextBox.sendKeys("user3123");
            loginButton.click();
            driver.navigate().refresh();
        }


}
