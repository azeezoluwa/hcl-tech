package pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;
import base.CommonUtilities;

public class HomePage extends BasePage {

	public HomePage() {
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, Long.parseLong(prop.getProperty("webdriverWait")));
	}

	@CacheLookup
	@FindBy(how=How.XPATH, using="/html[1]/body[1]/section[2]/div[1]/div[1]/div[1]/div[1]/div[2]/h1[1]")
	public WebElement heroText;

	@CacheLookup                 
	@FindBy(how=How.LINK_TEXT, using="Leadership")
	public WebElement leadership;
	
	@CacheLookup                 
	@FindBy(how=How.XPATH, using="/html[1]/body[1]/div[5]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/div[1]/img[1]")
	public WebElement image;
	
	@CacheLookup                 
	@FindBy(how=How.XPATH, using="//h4[contains(text(),'Shiv Nadar')]")
	public WebElement founderName;
	
	
	
	public void verifyUserIsOnHomePage()
	{
		CommonUtilities.pause(Long.parseLong(prop.getProperty("shortTimeout")));
		if(wait.until(ExpectedConditions.visibilityOf(heroText))!=null)
		{
			assertTrue(heroText.isDisplayed());
			System.out.println("User is on Home Page");
		}
		else 
			throw new RuntimeException("Issue with Home Page");
	}
	
	public void isFounderVisible()
	{
		verifyUserIsOnHomePage();
		scrollInToViewOfAnElement(heroText);
		
		clickElement(leadership);
		assertEquals(driver.getCurrentUrl(), prop.getProperty("leadership_url"));
		
		scrollToMiddleOfPage();
		verifyTextAndClickElement(founderName, prop.getProperty("founderName"));
		System.out.println("Founder Name: "+founderName);
	}

}
