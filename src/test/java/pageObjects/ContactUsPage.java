package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage
{
    WebDriver driver;

    @FindBy(id = "FullName") public WebElement yourNameTextBox;
    @FindBy(id = "Email") public WebElement emailTextBox;
    @FindBy(id = "Enquiry") public WebElement enquiryTextBox;
    @FindBy(name = "send-email") public WebElement sendButton;
    @FindBy(className = "result")  public WebElement confirmationMessage;

    public  ContactUsPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);

    }

  public  void enterName(String name)
  {   yourNameTextBox.clear();
      yourNameTextBox.sendKeys(name);
  }
    public  void enterEmail(String email)
    {   emailTextBox.clear();
        emailTextBox.sendKeys(email);
    }
    public  void enterEnquiry(String enquiry)
    {
        enquiryTextBox.sendKeys(enquiry);
    }

    public void submitEnquiry()
    {
        driver.getTitle();
        sendButton.click();

      String  actualMessage=confirmationMessage.getText();
      String  expMessage="Your enquiry has been successfully sent to the store owner.";
      Assert.assertEquals(actualMessage,expMessage);

  }


}
