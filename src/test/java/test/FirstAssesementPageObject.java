package test;

import static org.testng.Assert.assertEquals;
import org.apache.commons.exec.util.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.FirstAssesmentPageObjects;

@Test
public class FirstAssesementPageObject 
{
	WebDriver driver = null;
	
	@BeforeTest
	public void SetUpTest() 
	{
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath:" +projectPath); //Path to saved project
		
		//Path for webdriver , in this case i used Chrome Browser
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");//path for Chrome WebDrive
		driver = new ChromeDriver();
	}
	@AfterTest
	public void tearDownTest() 
	{
		driver.close();
		driver.quit();
		System.out.println("Test Completed Successfully");
	}
	public  void FirstAssesmentPOM()
	{
		FirstAssesmentPageObjects firsttask = new FirstAssesmentPageObjects(driver);	
		driver.get("https://www.ultimateqa.com/filling-out-forms/");
		String before = firsttask.TextBeforeSubmit(); //Captcha before submit 
		System.out.println("Numbers before submitting: " + before); //Print Captcha number before submit form
		firsttask.SetTextForTextBoxName("Test"); //Fill out the field Name
		firsttask.SetTextForTextBoxMessage("TestTestTest");//Fill out the field Message
		firsttask.TextBoxCaptcha("-1"); //Put wrong Captcha -1
		firsttask.clickButtonSubmit(); //Click submit button	
		String after = firsttask.TextAfterSubmit(); //Captcha after submit 
		System.out.println("Numbers after submitting: " + after); //Print Captcha number after submit form
		
		if(before.equals(after)) //Are equal before and after Captcha numbers
		{
	        System.out.println("These numbers are equal"); //If numbers are the same print this message
	    }
	        else 
	        {
	            System.out.println("These numbers are not equal"); //If numbers are different print this message
	        }
	}
	public void SecondAssesmentPOM() throws InterruptedException 
	
	{
		FirstAssesmentPageObjects secondtask = new FirstAssesmentPageObjects(driver);
		driver.get("https://www.ultimateqa.com/filling-out-forms/"); //Going to the desirable URL
		String before = secondtask.TextBeforeSubmit();
		System.out.println("Numbers before submitting: " + before); //Captcha before submitting form
		secondtask.SetTextForTextBoxName("Test"); //Type your Name
		secondtask.SetTextForTextBoxMessage("TestTestTest"); //Type your Message
		String numbers = before; //String Number before submit
		String split[] = StringUtils.split(numbers," + "); //Make list of string and cut +
		String part1 = split[0]; //Choose first string from the list 
		System.out.println("First Number is : "+part1); //Print our string 
		Integer x = Integer.valueOf(part1); //Make first string  to integer 
		String part2 = split[1]; //Choose second string from the list 
		Integer y = Integer.valueOf(part2); //Make second string  to integer 
		System.out.println("Second Number is : "+y);//Print our second integer 
		Integer sum = x+y; //Sum of our integers
		System.out.println("Sum of numbers is : "+sum); //Print sum
		String putintobox = secondtask.TextBoxCaptcha(sum.toString()); //Insert into Captcha box our sum
		secondtask.clickButtonSubmit(); //Click submit button
		Thread.sleep(6500); 
		System.out.println("Your number into box captcha : "+ putintobox);
		String successmessageaftersubmit = secondtask.GetSucessErrorMsgText(); //Catch Success Message
		System.out.println("Message is : " + successmessageaftersubmit); //Print our Success message
		assertEquals("Success",successmessageaftersubmit);//Are Equal Success message after submitting
	}

}
