package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.Login;
import Utility.ReadConfigFile;

public class testonSD
{
	public static WebDriver driver;
	static ReadConfigFile rc = new ReadConfigFile("C:\\Users\\Sourabh Patni\\eclipse-workspace\\SauceDemoProject\\src\\HardcodeDependencies\\config.properties");
	static Login L = new Login(driver);
	
	
	@BeforeTest
	public static void openandlaunchBrowserURL()
	{
		driver = new EdgeDriver();
		driver.get(rc.getApplicationURL());	
		driver.manage().window().maximize();
	}
		
	@Test(priority = 1)
	public static void loginToSDemo() 
	{
		Login L = new Login(driver);
		L.enteruserName(rc.getUserName());
		L.enterPassword(rc.getPassword());
		L.clickLoginButton();		
	}
	
	@Test(priority = 2)
	public static void getgreatestPrice() 
	{
		//L.selectgreatestprice();
		L.clickonAddtoCart();;
	}
	
	

}
