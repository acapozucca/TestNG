package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestFirstServlet {
  
	private static WebDriver driver;
	private static String serverBaseURL= "http://192.168.33.14:8080";
	private static String webpageURI= "/helloworld/FirstServlet";
	
	@BeforeTest
	public static void configureDriver() {
		System.setProperty("webdriver.chrome.driver" ,  "lib/mac/chromedriver");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	public static void testContent() throws InterruptedException {
		driver.get(serverBaseURL+webpageURI);
		Thread.sleep(1000);
		String expectedString= "Hi There!";
		String actualString= driver.findElement(By.id("hi")).getText();
		Assert.assertEquals(expectedString, actualString);
	}
	
	@Test //This should fail as we are asserting wrong time with that of the one shown in the page
	public static void testTime() throws InterruptedException {
		driver.get(serverBaseURL+webpageURI);
		Thread.sleep(1000);
		String actualDate= driver.findElement(By.id("date")).getText();
		Thread.sleep(1000);
		String expectedDate= "Date=Fri Apr 10 10:30:46 UTC 2020";
		Assert.assertEquals(expectedDate, actualDate);
	}
	
	@AfterSuite
	public static void closeDriver() {
		driver.quit();
	}
	
	
}
