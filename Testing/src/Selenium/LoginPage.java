package Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage 
{
	private WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//targets
	private By email = By.name("email");
	private By password = By.name("password");
	private By continuebtn = By.id("continue");
	private By loginbtn = By.id("signInSubmit");
	
	//Actions
	private void setEmail()
	{
		driver.findElement(email).sendKeys("email");
	}
	private void setPassword()
	{
		driver.findElement(password).sendKeys("password");
	}
	private void clickOnContinue()
	{
		driver.findElement(continuebtn).click();
	}
	private void clickOnLogin()
	{
		driver.findElement(loginbtn).click();
	}
	
	//Login Action
	private void login() throws InterruptedException
	{
		this.setEmail();
		Thread.sleep(1000);
		this.clickOnContinue();
		Thread.sleep(1000);
		this.setPassword();
		Thread.sleep(1000);
		this.clickOnLogin();
	}
	
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver" , "D:\\Share\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/ap/signin?_encoding=UTF8&ignoreAuthState=1&openid.assoc_handle=inflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fie%3DUTF8%26tag%3Dgooginabkvernac-21%26ascsubtag%3D_k_CjwKCAiA6vXwBRBKEiwAYE7iS2TTHZzlbPoVvNOrKox6KVWYGtaH-ijOyxfr2f-r32wla1i4sJS16RoCLgUQAvD_BwE_k_%26ext_vrnc%3Dhi%26gclid%3DCjwKCAiA6vXwBRBKEiwAYE7iS2TTHZzlbPoVvNOrKox6KVWYGtaH-ijOyxfr2f-r32wla1i4sJS16RoCLgUQAvD_BwE%26ref_%3Dnav_custrec_signin&switch_account=");
		LoginPage page = new LoginPage(driver);
		page.login();
	}
}
