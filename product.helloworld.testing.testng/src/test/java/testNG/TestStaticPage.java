package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestStaticPage {
  
	private static WebDriver driver;
	private static String serverBaseURL= "http://192.168.33.14:8080";
	private static String webpageURI= "/helloworld/helloworld.html";
	
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
		String expectedString= "You have reached the same content here, but on a different web page. Congratulations!";
		String actualString= driver.findElement(By.id("content")).getText();
		Assert.assertEquals(expectedString, actualString);
		Thread.sleep(1000);
	}
	
		
	@AfterSuite
	public static void closeDriver() {
		driver.quit();
	}
	
	
}
