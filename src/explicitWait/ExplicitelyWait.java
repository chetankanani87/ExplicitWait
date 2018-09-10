package explicitWait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import lib.BrowserDriverUtility;
import lib.ScreenshotUtility;

public class ExplicitelyWait {
	WebDriver dr;
	@Test
	public void Test1() throws InterruptedException {
		dr = BrowserDriverUtility.InvokeBrowser("webdriver.chrome.driver",
				"C:\\Chetan\\Softs\\SeleniumSuite\\WebDrivers\\chromedriver.exe",
				"http://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html");
		dr.findElement(By.xpath("//button[@onclick='timedText()']")).click();
		
		WebDriverWait wait = new WebDriverWait(dr, 30);
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='demo']")));
		
		boolean status = ele.isDisplayed();
		if (status) {
			System.out.println("Element is displayed.");
			Thread.sleep(12000);
			ScreenshotUtility.CaptureScreenshot(dr, "snap1");
		} else {
			System.out.println("Element is not displayed.");
		}
	}
}
