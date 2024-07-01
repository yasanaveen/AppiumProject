package com.Appium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class cart_Tc_3 extends BaseTest {

	@Test
	public void fillform() throws InterruptedException
	{

		Thread.sleep(2000);

		//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		//		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.androidsample.generalstore:id/nameField")));
		//		element.sendKeys("Naveen");

		driver.findElement(By.xpath("//android.widget.EditText[@text='Enter name here']")).sendKeys("Naveen");
		driver.hideKeyboard();

		Thread.sleep(2000);
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();	
		driver.findElement(AppiumBy.androidUIAutomator
				("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Bangladesh\"));"));	
		Thread.sleep(2000);

		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Bangladesh\"]")).click();		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();		
		driver.findElement(AppiumBy.androidUIAutomator
				("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));	
		Thread.sleep(2000);


		int productcount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();

		for(int i=0;i<productcount;i++)
		{
			String pName=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();

			if(pName.equalsIgnoreCase("Jordan 6 Rings"))
			{
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			}
		}

		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

		//		WebDriverWait waitt = new WebDriverWait(driver,Duration.ofSeconds(5));
		//		waitt.until(ExpectedConditions.attributeContains(By.id("com.androidsample.generalstore:id/toolbar_title"), "text", "Cart"));

		Thread.sleep(2000);
		
		String cartPage = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		Assert.assertEquals(cartPage, "Jordan 6 Rings");


	}

}
