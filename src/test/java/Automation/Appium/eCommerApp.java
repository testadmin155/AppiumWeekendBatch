package Automation.Appium;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;

public class eCommerApp extends BaseTest{
	
	@Test
	public void eshopping() throws InterruptedException
	{
		Thread.sleep(5000);
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Testing");
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Belgium\").instance(0))")).click();
		//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable (new uiSelector()).scrollIntoView(text(\"India\"));"));
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		// to get text of toast message
		/*
		//String toastmessage= driver.findElement(By.xpath("/hierarchy/android.widget.Toast[1]")).getAttribute("text");
		String toastmessage= driver.findElement(By.xpath("/hierarchy/android.widget.Toast[1]")).getText();
		System.out.println(toastmessage);
		Assert.assertEquals(toastmessage, "Please enter your name");
		*/
		
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))"));
		Thread.sleep(5000);
		
		 int Productcount = driver.findElements(By.xpath("//*[@resource-id='com.androidsample.generalstore:id/productName']")).size();
		 for(int i=0; i<Productcount; i++)
		 {
			 String productname = driver.findElements(By.xpath("//*[@resource-id='com.androidsample.generalstore:id/productName']")).get(i).getText();
			 System.out.println(productname);
			 if(productname.equals("Jordan 6 Rings"))
			 {
				 driver.findElements(By.xpath("//*[@resource-id='com.androidsample.generalstore:id/productAddCart']")).get(i).click();
				 break;
			 }
		 }
		 
		 driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		 Thread.sleep(10000);
		 Set<String> contexts = driver.getContextHandles();
		 for(String contextName:contexts)
		 {
			 System.out.println(contextName);
		 }
		 
		 driver.context("WEBVIEW_com.androidsample.generalstore");
		 //driver.findElement(By.xpath("//*[@class='android.widget.EditText']")).sendKeys("AutomationTestAcademy");
		 //driver.findElement(By.xpath("//*[@class='android.widget.EditText']")).sendKeys(Keys.ENTER);
		
		 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Alles accepteren\").instance(0))")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.className("android.widget.EditText")).sendKeys("Testing");
		 
		 
	}

}
