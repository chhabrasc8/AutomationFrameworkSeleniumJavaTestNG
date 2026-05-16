package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductListPage {
	
	WebDriver driver;
	
	public ProductListPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="add-to-cart-sauce-labs-backpack")
    private WebElement addToCartButton;
	
	@FindBy(className="shopping_cart_link")
    private WebElement cartIcon;
	
	public void clickAddToCart()
	{
		addToCartButton.click();
	}
	
	public void clickViewCart()
	{
		cartIcon.click();
	}
}
