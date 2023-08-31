package PageObjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Login 
{
	static WebDriver driver;
	int maxPrice;
	List<Integer> prices = new ArrayList<>();
	
	@FindBy(how = How.ID, using = "user-name")
	WebElement userName;
	
	@FindBy(how = How.ID, using = "password")
	WebElement password;
	
	@FindBy(how = How.ID, using = "login-button")
	WebElement loginButton;
	
	@FindBy(how = How.XPATH, using = "//div[@class = 'inventory_item_price']")
	List<WebElement> pricelist;
	
	@FindBy(how = How.XPATH, using = "//button[text() = 'Add to cart']")
	List<WebElement> AddtoCart;
	
	public Login(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enteruserName(String UserDetails)
	{
		userName.sendKeys(UserDetails);
	}
	
	public void enterPassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void clickLoginButton()
	{
		loginButton.click();
	}
	
	public void selectgreatestprice() 
		{
		System.out.println(pricelist);
			for (WebElement priceElement : pricelist) 
			{
				
				String priceText = priceElement.getText().replaceAll("[^0-9]", ""); // Remove non-numeric characters
				int intprice = Integer.parseInt(priceText);
				prices.add(intprice);
				maxPrice = Collections.max(prices);	
				
			}
		}
	
	public void clickonAddtoCart() 
		{
		
			selectgreatestprice();
			System.out.println("price");
			for (int i = 0; i < prices.size(); i++) 
				{
					int currentPrice = prices.get(i);
					if (currentPrice == maxPrice) 
						{	
							System.out.println("Current Price is "+maxPrice);            	
							WebElement AddtoCarts = AddtoCart.get(i);
						    AddtoCarts.click();;
	                        break; // Exit the loop after clicking
						}
				}
		}
	

}