package Automation.Appium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class Swipe extends BaseTest{

	@Test
	public void SwipeTest() throws InterruptedException
	{
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Gallery\"]")).click();
		driver.findElement(By.xpath("(//*[@resource-id='android:id/text1'])[1]")).click();
		WebElement element = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.Gallery/android.widget.ImageView[1]"));
		Assert.assertEquals(element.getAttribute("focusable"),"true");
		
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement) element).getId(),
			    "direction", "left",
			    "percent", 0.75
			));
		Thread.sleep(5000);
		Assert.assertEquals(element.getAttribute("focusable"),"false");
		
	}
}
