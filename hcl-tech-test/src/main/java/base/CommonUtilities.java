package base;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class CommonUtilities extends BasePage{


	public void takeScreenshot() 
	{
		TakesScreenshot shot=(TakesScreenshot)driver;
		File source=shot.getScreenshotAs(OutputType.FILE);
		try {
			DateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
			Date date=new Date();
			FileUtils.copyFile(source, new File("./Screenshots/"+dateFormat.format(date)+".png"));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		System.out.println("screenshot taken!");	
	}
	
	public void closeBrowser()
	{
		driver.close();
		//driver.quit();
	}
	
	public static void pause(Long timeout) 
	{
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}	
	}
}
