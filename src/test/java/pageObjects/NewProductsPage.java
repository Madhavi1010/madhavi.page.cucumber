package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewProductsPage
{
    WebDriver driver;


    @FindBy(xpath = "//input[@value='Add to cart']") public WebElement addToCartLink;

    @FindBy(linkText = "Contact us") public WebElement contactUsLink;

    public  NewProductsPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);

    }

    public void clickAddToCart()
    {   driver.getTitle();
        addToCartLink.isDisplayed();
    }


    public void clickContactUs() throws InterruptedException
    {   driver.getTitle();
       Thread.sleep(2000);
        contactUsLink.click();
    }

}
