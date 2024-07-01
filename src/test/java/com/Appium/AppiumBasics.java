package com.Appium;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;




public class AppiumBasics extends BaseTest{


	@Test
	public void wifinameSetup()
	{

	driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Preference\"]")).click();
	driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
	driver.findElement(By.id("android:id/checkbox")).click();
	driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"WiFi settings\"]")).click();
	String tittle=driver.findElement(By.id("android:id/alertTitle")).getText();
	Assert.assertEquals(tittle, "WiFi settings");
	
	driver.findElement(By.id("android:id/edit")).sendKeys("Naveen");
	
	driver.findElement(By.id("android:id/button1")).click();
	
	
	
	
	}

}
