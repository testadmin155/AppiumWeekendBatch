package Automation.Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BrowserBaseTest {
	
	public AndroidDriver driver ;
	public AppiumDriverLocalService service;

	
	//url to download the APp
	//https://github.com/appium-boneyard/sample-code/blob/master/sample-code/apps/ApiDemos/bin/ApiDemos-debug.apk
	
	//@BeforeClass
	public void AppiumConfiguration() throws MalformedURLException 
	{
		//code to start the server
				service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\skane\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).
						withIPAddress("192.168.0.9").usingPort(4723).build();
				
				service.start();
				
				//code to initialize the App
				UiAutomator2Options options = new UiAutomator2Options();
				options.setDeviceName("Pixel 3a API 30");
				options.setChromedriverExecutable("C:\\Users\\skane\\Desktop\\Testing\\Appium APPs\\chromedriver_win32");
				options.setCapability("browserName", "Chrome");
				
				driver = new AndroidDriver(new URL("http://192.168.0.9:4723"), options);
	}
	
	
	
    //@AfterClass
	public void teardown()
	{
		//to stop the appium server
				//driver.quit();
				service.stop();
	}
}
