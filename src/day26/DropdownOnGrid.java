package day26;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DropdownOnGrid {
	@Parameters("browser")
	@Test
	public void dropdownTest(String b) throws MalformedURLException
	{
		DesiredCapabilities caps=null;
		if(b.equals("chrome"))
		{
			caps=DesiredCapabilities.chrome();
			caps.setPlatform(Platform.LINUX);
		}
		else if(b.equals("firefox"))
		{
			caps=DesiredCapabilities.firefox();
			caps.setPlatform(Platform.LINUX);
		}
		
		RemoteWebDriver driver=new RemoteWebDriver(new URL("http://192.168.255.128:4444/wd/hub"),caps);		
		driver.get("http://newtours.demoaut.com");
		Sleeper.sleepTightInSeconds(7);
		driver.findElement(By.linkText("REGISTER")).click();
		WebElement drop=driver.findElement(By.name("country"));
		List<WebElement> dropdown=drop.findElements(By.tagName("option"));
		System.out.println(dropdown.size());
		for(int i=0;i<dropdown.size();i++)
		{
			dropdown.get(i).click();
			if(dropdown.get(i).isSelected())
			{
				System.out.println(dropdown.get(i).getText()+" is active");
			}
			else
			{
				System.out.println(dropdown.get(i).getText()+" is active");
			}
		}
		
	}

}
