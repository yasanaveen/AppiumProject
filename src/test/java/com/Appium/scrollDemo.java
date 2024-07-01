package com.Appium;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumBy.ByAndroidUIAutomator;

public class scrollDemo  extends BaseTest{

	@Test
	void scrollTest()
	{
		
	 driver.findElement(AppiumBy.accessibilityId("Views")).click();	
	driver.findElement(AppiumBy.androidUIAutomator
			("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));	
		
	}
	
	
}
