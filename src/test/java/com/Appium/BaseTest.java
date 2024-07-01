   package com.Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

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

public class BaseTest {

	public AndroidDriver driver;

	@BeforeClass
	public void Appiumconfiguration() throws MalformedURLException, URISyntaxException
	{
        
		


		UiAutomator2Options options= new UiAutomator2Options();
		options.setDeviceName("Naveen");
		options.setChromedriverExecutable("C:\\Users\\yasan\\Downloads\\chromedriver-win64\\chromedriver.exe");
		//options.setApp("C:\\eclipse-workspace\\NewAppium\\resources\\ApiDemos-debug.apk");
		options.setApp("C:\\eclipse-workspace\\NewAppium\\resources\\General-Store.apk");
		
		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

	}
	
	public void LongClickGesture(WebElement ele)
	{
		
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) ele).getId(),
			    "duration",2000
			    
			));
		
	}
	
	public Double formattedAmount(String amount)
	{
		Double price=Double.parseDouble(amount.substring(1));
		return price;
	}

	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	

}
