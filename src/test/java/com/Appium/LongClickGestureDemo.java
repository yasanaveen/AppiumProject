package com.Appium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;

public class LongClickGestureDemo extends BaseTest{
	
	@Test
	public void LongPressGesture()
	{
		
		Activity activity= new Activity("io.appium.android.apis", "io.appium.android.apis.view.ExpandableList1");
((JavascriptExecutor)driver).executeScript("mobile:startActivity",ImmutableMap.of("intent","io.appium.android.apis/io.appium.android.apis.view.ExpandableList1"));
		
		//driver.findElement(AppiumBy.accessibilityId("Views")).click();
	WebElement peopleName = driver.findElement(By.xpath("//android.widget.TextView[@text=\"People Names\"]"));	

	LongClickGesture(peopleName);

	
	
	}

}
