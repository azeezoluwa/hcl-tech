package tdd;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BasePage;
import base.BrowserManager;
import base.CommonUtilities;
import base.EnvironmentManager;
import pages.HomePage;

public class SeleniumTests extends BasePage {

	@BeforeMethod(alwaysRun=true)
	public void startSession() 
	{
		instanceOf(BrowserManager.class).getBrowserType();
		instanceOf(EnvironmentManager.class).getEnvironmentType();
	}

	@AfterMethod(alwaysRun=true)
	public void endSession(ITestResult result) 
	{
		if(ITestResult.SUCCESS==result.getStatus()) 
		{
			instanceOf(CommonUtilities.class).takeScreenshot();
			System.out.println("Test Passed");
		}
		else if(ITestResult.FAILURE==result.getStatus()) 
		{
			instanceOf(CommonUtilities.class).takeScreenshot();
			System.out.println("Test Failed");
		}
		instanceOf(CommonUtilities.class).closeBrowser();
	}

	@Test
	public void verifyHomePageLoadsSuccessfully()
	{
		instanceOf(HomePage.class).verifyUserIsOnHomePage();
	}

	@Test(dependsOnMethods="verifyHomePageLoadsSuccessfully")
	public void verifyFounderIsVisible()
	{
		instanceOf(HomePage.class).isFounderVisible();
	}
}
