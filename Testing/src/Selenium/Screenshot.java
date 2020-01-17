package Selenium;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Screenshot 
{
	public static void takepicture(WebDriver driver , String filename) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File(".//screenshots//" + filename + ".png"));
	}
	
	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Share\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.amazon.in");
		Screenshot.takepicture(driver , "img1");
		
		Actions action = new Actions(driver);
		WebElement bestsellers = driver.findElement(By.linkText("Best Sellers"));
		action.moveToElement(bestsellers).build().perform();
		bestsellers.click();
		Screenshot.takepicture(driver , "img2");
		Thread.sleep(3000);
		
		WebElement books = driver.findElement(By.linkText("Books"));
		action.moveToElement(books).build().perform();
		Thread.sleep(3000);
		books.click();
		Screenshot.takepicture(driver , "img3");

	}
}
