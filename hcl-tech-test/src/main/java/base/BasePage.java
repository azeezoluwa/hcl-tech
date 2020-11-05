package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends ConfigFileReader {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public static final String hcl_env="https://www.hcl.com/";
	public static int numbers [] = {1,2,3,4,5,6,7,8,9,10};
	
	
	protected <PFPage extends BasePage> PFPage instanceOf(Class<PFPage> pageInstance) 
	{
		try {
			return PageFactory.initElements(driver, pageInstance);
		} catch (Exception e) {
			throw new RuntimeException("Unable to create instance of a page ", e);
		}
	}
	
	protected WebElement clickElement(WebElement element) 
	{
		try {
			element.click();
		}
		catch(Exception e) {
			throw new RuntimeException("Unable to click element, could be a web element has changed " +e);
		}
		return element;
	}
	
	protected WebElement verifyTextAndClickElement(WebElement element, String value)
	{
		if(element.getText().equals(value));
		{
			element.click();
		}
		return element;
	}
	
	protected WebElement scrollInToViewOfAnElement(WebElement element) 
	{
		try {
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
		}
		catch(Exception e) {
			throw new RuntimeException("Unable to scroll into view of an element " +e);
		}
		return element;
	}
	
	protected void scrollToMiddleOfPage() 
	{
		try {
			((JavascriptExecutor)driver).executeScript("window.scrollBy(0,600)");
		}
		catch(Exception e) {
			throw new RuntimeException("Unable to scroll to middle of page " +e);
		}
	}
}
