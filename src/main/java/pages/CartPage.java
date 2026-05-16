package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	WebDriver driver;
	
	public CartPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "title")
	private WebElement cartPageTitle;
	
	@FindBy(className = "inventory_item_name")
	private WebElement productinCart;
	
	public String getCartPageHeading()
	{
		return cartPageTitle.getText();
	}
	
	public String getProductTitle()
	
	{
		return productinCart.getText();
	}
	
	
}
