package com.Appium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class ToastMsge_tc_2 extends BaseTest {
	
	@Test
	public void fillform() throws InterruptedException
	{
	
	//driver.findElement(By.xpath("//android.widget.EditText[@text='Enter name here']")).sendKeys("Naveen");
	
		
	driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();	
	driver.findElement(AppiumBy.androidUIAutomator
			("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Bangladesh\"));"));	
			Thread.sleep(2000);
			
	driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Bangladesh\"]")).click();		
	driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();		
	
	String toastText=driver.findElement(By.xpath("//android.widget.Toast[1]")).getText();
	//System.out.println(toastText);
	Assert.assertEquals(toastText,"Please enter your name");
	
	
	}

}
