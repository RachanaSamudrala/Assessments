package Selenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class demo 
{
	static void get()
	{
		System.setProperty("webdriver.chrome.driver" , "D:\\Share\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.gmail.com");
	}
	public static void main(String[] args)
	{
		demo obj = new demo();
		obj.get();
	}
	
}
