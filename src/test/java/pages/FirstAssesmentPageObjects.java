package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FirstAssesmentPageObjects 
{
	WebDriver driver = null;
	By textboxname = By.id("et_pb_contact_name_1"); //element for username box
	By textboxmessage = By.id("et_pb_contact_message_1"); //element for message box
	By clickButton = By.xpath("//div[@id='et_pb_contact_form_1']//button[@class='et_pb_contact_submit et_pb_button'][contains(text(),'Submit')]"); //element for submit button
	By textbeforeandaftersubmit = By.className("et_pb_contact_captcha_question"); //element for captcha before and after submit
	By boxcaptcha = By.cssSelector("input.input.et_pb_contact_captcha");//element for box capture element
	By successmessage = By.cssSelector("div.et-pb-contact-message > p");
	
	public FirstAssesmentPageObjects(WebDriver driver) 
	{
		this.driver = driver;
	}
	public String TextBeforeSubmit()
	{
		WebElement results = driver.findElement(textbeforeandaftersubmit);
		return results.getText();
	}
	public void SetTextForTextBoxName(String text) 
	{
		driver.findElement(textboxname).sendKeys(text);
	}
	
	public void SetTextForTextBoxMessage(String text) 
	{
		driver.findElement(textboxmessage).sendKeys(text);
	}
	public String TextBoxCaptcha(String text)
	{
		driver.findElement(boxcaptcha).sendKeys(text);
		return text;
	}
	public void clickButtonSubmit()
	{
		driver.findElement(clickButton).sendKeys(Keys.RETURN);
	}
	public String TextAfterSubmit()
	{
		WebElement result = driver.findElement(textbeforeandaftersubmit);
		return result.getText();
	}
	public String GetSucessErrorMsgText()
    {
		WebElement success = driver.findElement(successmessage);
		return success.getText();
    }		
}
