package Automation.Appium;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class ScrollGesture extends BaseTest{

	@SuppressWarnings("deprecation")
	@Test
	public void Scroll() throws InterruptedException
	{
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();		
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\".*TextClock.*\").instance(0))")).click();
		Thread.sleep(5000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(5000);
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		Thread.sleep(5000);
		
}
	
}
