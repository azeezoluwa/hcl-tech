package base;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserManager extends BasePage {

	
	public void getBrowserType() 
	{ 
		try {
			String browserName=prop.getProperty("browser");
			if(browserName.equalsIgnoreCase("chrome") || browserName.isEmpty()) 
			{
				WebDriverManager.chromedriver().setup();
				ChromeOptions chromeOptions=new ChromeOptions();
				chromeOptions.addArguments("start-maximized");
				chromeOptions.addArguments("disable-popup-blocking"); //disables pop ups
				chromeOptions.addArguments("--disable-notifications"); //disables notification
				chromeOptions.addArguments("test-type"); //blocks all security warnings
				chromeOptions.setAcceptInsecureCerts(true); 
				chromeOptions.setHeadless(false);
				
				//it makes headless execution much faster.
				//especially when wait conditions are in use.
				chromeOptions.addArguments("--proxy-server=direct://");
				chromeOptions.addArguments("--proxy-bypass-list=*");
				
				chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
				Map<String, Object> prefs=new HashMap<String, Object>();
				
				//Set the notification and popup settings this will override the default settings
				prefs.put("profile.default_content_setting_values.notifications", 1);
				prefs.put("profile.default_content_setting_values.popups", 1);
				chromeOptions.setExperimentalOption("prefs", prefs);
				driver=new ChromeDriver(chromeOptions);
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("implicitlyWait")), TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(Long.parseLong(prop.getProperty("pageLoadWait")), TimeUnit.SECONDS);
				System.out.println("Browser: Chrome");
			}
			else if(browserName.equalsIgnoreCase("firefox")) 
			{
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions FFOptions=new FirefoxOptions();
				FFOptions.addArguments("disable-popup-blocking");
				FFOptions.addArguments("--start-maximized");
				FFOptions.addArguments("--disable-infobars"); 
				FFOptions.addArguments("--disable-notifications");
				FFOptions.setAcceptInsecureCerts(true); 
				FFOptions.setHeadless(false);
				FFOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
				driver=new FirefoxDriver(FFOptions);
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("implicitlyWait")), TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(Long.parseLong(prop.getProperty("pageLoadWait")), TimeUnit.SECONDS);
				System.out.println("Browser: Firefox");
			}
		}
			catch(Exception e)
			{
				throw new RuntimeException("Browser not starting up " + e);
			}
		}
		
	}

