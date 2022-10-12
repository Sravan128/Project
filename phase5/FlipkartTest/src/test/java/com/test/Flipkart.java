package com.test;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Flipkart {
	WebDriver driver,driver1;
	@Test(priority=1)
	public void google_flipkart() throws InterruptedException {
		Thread.sleep(3000);
		Dimension dimension = new Dimension(2256, 1504);
		driver.manage().window().setSize(dimension);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int contentHeight = ((Number) js.executeScript("return window.innerHeight")).intValue();
		int contentWidth = ((Number) js.executeScript("return window.innerWidth")).intValue();
		System.out.println("\nHeight: " + contentHeight + " Width: " + contentWidth + "\n");
		driver.get("https://www.flipkart.com/");
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver)
				.withTimeout(10,TimeUnit .SECONDS)
				 .pollingEvery(5,TimeUnit .SECONDS)
				 .ignoring(NoSuchElementException.class);
		 WebElement element =wait.until(new Function<WebDriver, WebElement>() {
                
				public WebElement apply(WebDriver driver) {
					// TODO Auto-generated method stub
					
					WebElement element= driver.findElement(By.name("q"));
					element.sendKeys("ipone 13");
					return element;
					
				}
				
			});
			driver.findElement(By.cssSelector("#container > div > div._1kfTjk > div._1rH5Jn > div._2Xfa2_ > div._1cmsER > form > div > button > svg")).click();
			try {
				Thread.sleep(5000);
			    element= driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[6]/div/div/div/a/div[2]"));
	            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
	            System.out.println(element.getText());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			WebElement img = driver.findElement(By
					.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[6]/div/div/div/a/div[1]/div[1]/div/div/img"));
			Boolean p = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete "
					+ "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", img);

			if (p) {
				System.out.println("\nImage present");
			} else {
				System.out.println("\nImage not present");
			}
           }
	    @Test(priority=2)
        public void edge_flipkart() throws InterruptedException {
	    	Thread.sleep(3000);
			Dimension dimension = new Dimension(2256, 1504);
			driver1.manage().window().setSize(dimension);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			int contentHeight = ((Number) js.executeScript("return window.innerHeight")).intValue();
			int contentWidth = ((Number) js.executeScript("return window.innerWidth")).intValue();
			System.out.println("\nHeight: " + contentHeight + " Width: " + contentWidth + "\n");
		driver1.get("https://www.flipkart.com/");
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver1)
				.withTimeout(10,TimeUnit .SECONDS)
				 .pollingEvery(5,TimeUnit .SECONDS)
				 .ignoring(NoSuchElementException.class);
		 WebElement element =wait.until(new Function<WebDriver, WebElement>() {
                
				public WebElement apply(WebDriver driver1) {
					// TODO Auto-generated method stub
					
					WebElement element= driver1.findElement(By.name("q"));
					element.sendKeys("ipone 13");
					return element;
					
				}
				
			});
			driver1.findElement(By.cssSelector("#container > div > div._1kfTjk > div._1rH5Jn > div._2Xfa2_ > div._1cmsER > form > div > button > svg")).click();
			try {
				Thread.sleep(5000);
			    element= driver1.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[6]/div/div/div/a/div[2]/div[1]"));
	            ((JavascriptExecutor)driver1).executeScript("arguments[0].scrollIntoView();", element);
	            System.out.println(element.getText());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			WebElement img = driver1.findElement(By
					.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[7]/div/div/div/a/div[1]/div[1]/div/div/img"));
			Boolean p = (Boolean) ((JavascriptExecutor) driver1).executeScript("return arguments[0].complete "
					+ "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", img);

			if (p) {
				System.out.println("\nImage present");
			} else {
				System.out.println("\nImage not present");
			}
           }
	@BeforeMethod
	public void beforeMethod() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\syama\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		System.setProperty("webdriver.edge.driver", "C:\\Users\\syama\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		driver1= new EdgeDriver();
	}
	@AfterMethod
	public void afterMethod() {
		//driver.close();
		driver=null;
		driver1=null;
	}
}
