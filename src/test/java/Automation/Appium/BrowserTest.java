package Automation.Appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BrowserTest extends BrowserBaseTest{

	
	@Test
	public void chromebrowser() throws MalformedURLException, InterruptedException
	{
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel 3a API 30");
		options.setChromedriverExecutable("C:\\Users\\skane\\Desktop\\Testing\\Appium APPs\\chromedriver_win32\\chromedriver.exe");
		options.setCapability("browserName", "Chrome");
		
		driver = new AndroidDriver(new URL("http://192.168.0.9:4723"), options);
		
		
		driver.get("http://google.com");
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		driver.findElement(By.name("q")).sendKeys("Testing");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		
	}
}
