package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
      WebDriver driver;

    public  HomePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);

    }


    public void home()
    {
        driver.get("http://twentyconsulting-001-site1.dtempurl.com/");
    }

     @FindBy(xpath = "(//input[@value='Add to cart'])[3]")
      public WebElement item;

     @FindBy(linkText = "New products") public WebElement newProuctsLink;

       public void clickNewproducts()
       {
           newProuctsLink.click();
       }

     public void addItem()
     {
        driver.navigate().refresh();
         item.click();
     }
    public void pageTitle()
    {
        driver.getTitle();
    }

}
