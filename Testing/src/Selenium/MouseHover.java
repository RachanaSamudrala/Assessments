package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover
{
	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Share\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		/*
		driver.get("http://www.ebay.com");
		
		//Screenshot.takepicture(driver , "img1");
		
		Actions action = new Actions(driver);
		WebElement electronics = driver.findElement(By.linkText("Electronics"));
		action.moveToElement(electronics).build().perform();
		//Screenshot.takepicture(driver , "img2");
		Thread.sleep(3000);
		
		WebElement samsung = driver.findElement(By.linkText("Samsung"));
		action.moveToElement(samsung).build().perform();
		//Screenshot.takepicture(driver , "img3");
		Thread.sleep(3000);
		
		samsung.click();
		//Screenshot.takepicture(driver , "img4");
		*/
		
        driver.get("http://www.amazon.in");
				
		Actions action = new Actions(driver);
		WebElement bestsellers = driver.findElement(By.linkText("Best Sellers"));
		action.moveToElement(bestsellers).build().perform();
		bestsellers.click();
		Thread.sleep(3000);
		
		WebElement books = driver.findElement(By.linkText("Books"));
		action.moveToElement(books).build().perform();
		Thread.sleep(3000);
		books.click();
	}
}
