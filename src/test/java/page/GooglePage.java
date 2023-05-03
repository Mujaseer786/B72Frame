package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage {

	@FindBy(name="q")
	private WebElement searchBox;
	
	public GooglePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void setSearch(String s) {
		searchBox.sendKeys(s);
	}
}
