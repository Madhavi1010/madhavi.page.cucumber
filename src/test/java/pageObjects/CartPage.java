package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage
{
    WebDriver driver;

    public  CartPage(WebDriver driver)
    {   this.driver=driver;
        PageFactory.initElements(driver, this);

    }

        @FindBy(id ="termsofservice")
        public WebElement termsButton;

    @FindBy(id ="checkout")
    public WebElement checkoutButton;



     public void pagecart() throws InterruptedException {

         driver.get("http://twentyconsulting-001-site1.dtempurl.com/cart");
         driver.get("http://twentyconsulting-001-site1.dtempurl.com/cart");
         //driver.navigate().refresh();
         //driver.get(driver.getCurrentUrl());
         //driver.findElement(By.name("s")).sendKeys(Keys.COMMAND,"R");
     }


     public void clickTermsAndConditions()
     {
         driver.get("http://twentyconsulting-001-site1.dtempurl.com/cart");
         termsButton.click();
     }
     public void clickCheckoutButton()
     {

         checkoutButton.click();
     }

}
