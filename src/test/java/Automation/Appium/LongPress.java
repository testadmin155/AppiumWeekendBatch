package Automation.Appium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class LongPress extends BaseTest{

	//https://github.com/rakjha/appium/blob/master/docs/en/writing-running-appium/android/android-mobile-gestures.md
	
	@Test
	public void longPressgesture()
	{
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Expandable Lists\"]")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		WebElement  element = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		longPressAction(element);
		String menuText = driver.findElement(By.xpath("(//*[@resource-id='android:id/title'])[1]")).getText();
		Assert.assertEquals(menuText, "Sample menu");
		
	}
	
	
	
}
