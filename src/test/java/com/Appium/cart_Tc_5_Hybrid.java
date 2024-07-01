package com.Appium;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class cart_Tc_5_Hybrid extends BaseTest {

	@Test
	public void fillform() throws InterruptedException
	{

		//				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		//				WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.androidsample.generalstore:id/nameField")));
		//				element.sendKeys("Naveen");

		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Naveen");
		//driver.findElement(By.xpath("//android.widget.EditText[@text='Enter name here']")).sendKeys("Naveen");
		driver.hideKeyboard();

		Thread.sleep(2000);
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();	
		driver.findElement(AppiumBy.androidUIAutomator
				("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Bangladesh\"));"));	
		Thread.sleep(2000);

		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Bangladesh\"]")).click();		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();	

		driver.findElement(By.xpath("(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[1]")).click();
		driver.findElement(By.xpath("(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[2]")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

		//WebDriverWait waitt = new WebDriverWait(driver,Duration.ofSeconds(5));
		//waitt.until(ExpectedConditions.attributeContains(By.id("com.androidsample.generalstore:id/toolbar_title"), "text", "Cart"));

		List<WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		int count=productPrices.size();
		double totalSum=0;

		for(int i=0;i<count;i++)
		{
			Thread.sleep(6000);
			String amount=productPrices.get(i).getText();
			Double price=formattedAmount(amount);
			totalSum=totalSum+price;

		}

		String displaySum=driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		Double displayformattedsum=formattedAmount(displaySum);

		Assert.assertEquals(totalSum, displayformattedsum);
		WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));

		LongClickGesture(ele);

		String text=driver.findElement(By.id("com.androidsample.generalstore:id/alertTitle")).getText();

		Assert.assertEquals(text, "Terms Of Conditions");

		driver.findElement(By.id("android:id/button1")).click();


		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.className("android.widget.Button")).click();
		Thread.sleep(3000);

		// Hybrid

		Set<String> contexts =driver.getContextHandles();

		for(String context:contexts)
		{
			System.out.println(context);
		}
		Thread.sleep(3000);
		driver.context("WEBVIEW_com.androidsample.generalstore");
		driver.findElement(By.name("q")).sendKeys("Selenium");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		//		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		//		driver.context("NATIVE_APP");




	}

}
